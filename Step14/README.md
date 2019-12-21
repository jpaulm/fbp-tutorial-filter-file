<link rel="stylesheet" type="text/css" href="../style.css">

## Step14 - Interactive Applications

### Overall design

Another interesting application of bracket IPs is in interactive applications.  In this case, typically the application end user sends something to the system, and then waits for a result.  We thus have a very high level diagram that looks like this:

![High-level Interactive Application](Step14-1.png)

You will notice that we have split the user interaction into two processes: "Send to program" and "send to human" - this allows IPs being sent to the program from different users to be interspersed... and similarly for data returning to humans.  If these two processes had been combined into a single process, it would have had to wait while a human handled the previous response from the machine... and human think time is *much* slower than machine think time!   With separated processes, you will now have data connected with  different users chasing each other round the network.  Of course substreams have to be kept intact, which is why the [LoadBalancer](https://github.com/jpaulm/javafbp/blob/master/src/main/java/com/jpaulmorrison/fbp/core/components/routing/LoadBalance.java) component now sends all IPs in a substream to the same output port...

This approach seems a good match with substreams.  It makes sense to have the first IP in each substream contain information about the context or source of the transaction, e.g. user ID, date and time, maybe language, etc.,  followed by zero or more IPs containing relevant data being sent to or from the application.  Substreams are a good way to represent lists, for example when you want to display all the college courses a student has taken...

There is a practical example of this architecture in the [Web Sockets](https://github.com/jpaulm/javafbp-websockets) repository.  Here we split the above diagram between client and server.  The client code is written in HTML and JavaScript and simply sends a request substream across the sockets connection, and then displays the resulting list substream.  `Receive` and `Respond` are simple "off the shelf" FBP components, and the subnet can be any combination of components and subnets which produce a result substream which will be processed by `Respond`.  As stated above, you can do anything - as long as substreams are not broken up!  I have copied the schematic from [Web Sockets](https://github.com/jpaulm/javafbp-websockets):

![ClientServer](ClientServer.png "Diagram of Client and Server Network")

"WS" of course stands for Web Sockets.

I realize this may seem rather simple, but a real-life example will of course be more complex... and there are a number of ways performance can be improved, as e.g. by multiplexing (using the [LoadBalancer](https://github.com/jpaulm/javafbp/blob/master/src/main/java/com/jpaulmorrison/fbp/core/components/routing/LoadBalance.java), as shown in the diagram at the end of [JavaFBP-WebSockets](https://github.com/jpaulm/javafbp-websockets/blob/master/README.md)), use of caches, etc.


### Database access

Now let's consider what is going on at the "back end" of this diagram...

So far I have just drawn a single subnet processing input, but of course most applications will need to access data...




<span class=middle> &lt;== <a href="../Step12/">  Previous</a> / <a href="https://github.com/jpaulm/fbp-tutorial-filter-file/"> Index</a> /  Next ==&gt; (none)</span>
