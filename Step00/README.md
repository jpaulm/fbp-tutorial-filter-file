
<link href="../style.css" rel="stylesheet" type="text/css">

## Step00 - Setup DrawFBP

### DrawFBP essentials

Essential parts: DrawFBP diagram tool for FBP networks, DrawFBP help file, JavaFBP library of FBP components.  

We will start by installing DrawFBP, the FBP diagramming tool.  Go to https://github.com/jpaulm/drawfbp/releases , download the latest (non-pre-Release) DrawFBP jar file, and store it on your chosen location for DrawFBP (either your desktop, or another location specifically for your DrawFBP work).

*Our working assumption is that most users will have access to Windows, and that unix users will be able to adapt these steps to their preferences.*

Alternatively, you can do a search for `DrawFBP` on Maven.  *This will become the preferred location for DrawFBP, its Help facility, and the Java FBP Jar file, once this tutorial is commissioned after our current regression testing.  

Make sure you have Java installed, by issuing

       java -version
       
from the command line.  You will also need to define JAVA_HOME to include jre (Java Runtime Environment) and jdk (Java Development Kit) properties, using the `set` command, such as:

      `C:\Users\bob\drawfbp>set JAVA_HOME=C:\PROGRA~1\Java\jre1.8.0_191\lib;C:\PROGRA~1\Java\jdk1.8.0_191'

### Starting DrawFBP

Just double click on the jar file.  Alternatively, you can enter the command

       java -jar DrawFBP-[all-]x.y.z.jar
       
from the command line (you need `all-` if it came from Releases, and not if it came from Maven).

When you first fire up DrawFBP, you will see the DrawFBP logo, with 3 connected blocks of different colours.  This will last for a few seconds... or until you move the mouse.  In normal use, DrawFBP displays the diagram you were working on, so you will not see the logo.

As you develop various functions in DrawFBP, useful information will be stored in `C:Users\<username>\DrawFBPProperties.xml`.

If at some later stage of testing, you want to point at a diagram's `.drw` file and run DrawFBP, go to your DrawFBP local directory, and type 

      drawfbp.bat <diagram file name>
      
`drawfbp.bat` references the current DrawFBP jar file, but you can create your own version  if you prefer.

### Help Facility - Locating DrawFBP Help jar file

Download the file https://github.com/jpaulm/drawfbp/blob/master/lib/javahelp-2.0.05.jar to your preferred DrawFBP work area. 

Use the DrawFBP function `File/Locate Draw FBP Help File` to tell DrawFBP where it is: DrawFBP will remember your chosen location.
      
### Locating JavaFBP jar file and preparing Java FBP classes for use

At this point, you should locate the JavaFBP jar file (it can be found on [Maven](https://search.maven.org/search?q=g:%22com.jpaulmorrison%22%20AND%20a:%22javafbp%22) or in [JavaFBP Releases](https://github.com/jpaulm/javafbp/releases)), download it, and tell DrawFBP where it is, by using the DrawFBP function `File/Locate JavaFBP Jar File`.  Once you tell DrawFBP where it is, DrawFBP will remember the location from then on.  

<!--
From the Windows System Command Prompt, change directory to your DrawFBP working area, and expand the JavaFBP jar file into sub-directories, using: 

      `%JDK%\bin\jar.exe -xvf javafbp-4.1.0.jar`      

-->

The .class files you are likely to use are available under sub-directories such as `com/jpaulmorrison/fbp/core/components/` and `com/jpaulmorrison/fbp/resourcekit/examples` and so on.

<span class=middle> <a href="https://github.com/jpaulm/fbp-tutorial-filter-file/"> Index</a> / <a href="../Step01/"> Next </a>==&gt;</span> 

