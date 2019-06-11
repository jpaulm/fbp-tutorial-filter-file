
<link href="../style.css" rel="stylesheet" type="text/css">

## Step08-Inside a component

Building a component is relatively simple, but I would like to stress again that you can do a lot of the work involved in building an application without ever doing any coding!  However, if you want to see what a component looks like, I have included the code for `StartsWith.java`:

### Code for a simple "filter" component.

This component tests the first characters of every incoming Information Packet (IP) against a string of characters specified in an IIP which is `receive`d at port `TEST`.  

*Accepted* IPs are sent to port `ACC`; *rejected* IPs are sent to port `REJ`.

```java
 /**
 * JavaFBP - A Java Implementation of Flow-Based Programming (FBP)
 * Copyright (C) 2009, 2016 J. Paul Morrison
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, see the GNU Library General Public License v3
 * at https://www.gnu.org/licenses/lgpl-3.0.en.html for more details.
 */

package com.jpaulmorrison.fbp.core.components.text;


import com.jpaulmorrison.fbp.core.engine.Component;
import com.jpaulmorrison.fbp.core.engine.ComponentDescription;
import com.jpaulmorrison.fbp.core.engine.InPort;
import com.jpaulmorrison.fbp.core.engine.InPorts;
import com.jpaulmorrison.fbp.core.engine.InputPort;
import com.jpaulmorrison.fbp.core.engine.OutPort;
import com.jpaulmorrison.fbp.core.engine.OutPorts;
import com.jpaulmorrison.fbp.core.engine.OutputPort;
import com.jpaulmorrison.fbp.core.engine.Packet;


/**
 * Select packets starting with specified string.  
 */
@ComponentDescription("Select packets starting with specified string")

@OutPorts({ @OutPort(value = "ACC", description = "IPs accepted by filter"), 
	@OutPort(value = "REJ", description = "IPs rejected by filter") })
@InPorts({ @InPort(value = "IN", description = "input stream"), 
	@InPort(value = "TEST", description = "char string being tested against") })

public class StartsWith extends Component {

  
  private InputPort inport, testport;

  private OutputPort accport, rejport;

  @Override
  protected void execute() {

    Packet<?> testPkt = testport.receive();
    if (testPkt == null) {
      return;
    }
    String testStr = (String) testPkt.getContent();
    testport.close();
    drop(testPkt);

    Packet<?> p = inport.receive();
    while (p != null) {
      String content = (String) p.getContent();
      if (content.startsWith(testStr)) {
        accport.send(p);
      } else {
        rejport.send(p);
      }
      p = inport.receive();
    }
  }

  @Override
  protected void openPorts() {

    inport = openInput("IN");
    testport = openInput("TEST");

    accport = openOutput("ACC");
    rejport = openOutput("REJ");

  }
}
```

As you can see, there are only four sections in a component's code:

* copyright information if desired
* import statements
* annotations: component description and port information
* class header and declares for input and output port instance variables
* two methods: 
	* `execute()`
	* `openPorts()`
	
`openports()` is invoked for each JavaFBP process once per run of the network; `execute()` is invoked for each *activation* of a process (see the description of FBP scheduling in the book on Flow-Based Programming). 

All JavaFBP components have this structure.

Theoretically you can write components in any language that has an FBP implementation, but you may find yourself having to be creative to get different languages to intercommunicate... especially languages that are implemented by means of a virtual machine.  We will be showing you how to do this later on in the tutorial.

<span class=middle> &lt;== <a href="../Step07/">  Previous</a> / <a href="https://github.com/jpaulm/fbp-tutorial-filter-file/"> Index</a> / <a href="../Step09/"> Next</a> ==&gt;</span>