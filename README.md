# Tutorial on Flow-Based Programming (Filter File application)

This tutorial introduces the reader to the concepts of Flow-Based Programming, by means of diagrams built using DrawFBP, and generating running Java code, using precoded components, and (late) user-written components.


## Step 1.  Draw high level diagram of app to display contents of file. 

Here is a possible diagram:

![High level diagram](docs/Step1.png)

In this step, you should install DrawFBP (https://github.com/jpaulm/drawfbp ), and draw this diagram.

Save it in a work directory of your choice.  If you open it using Wordpad, it should look like the file you get when you click on [this link](docs/Step1.drw).

Of course, if you have trouble drawing the diagram, you can simply copy the `.drw` file, and open this file under DrawFBP.

Now at this point, you can simply assign real live components to the blocks in the diagrams (plus IIPs and port names), and you will basically have a running program.  However, I am going to assume that you want to add filter function between the two processes, so that is what we will do in Step2.

## Step2. Add a filter function 

In this step we are going to add a filter function between the two blocks shown above.  Filter functions (filters, for short) are commonly used in FBP, and typically have two outputs: accepted IPs, and rejected IPs.  Filters should not just drop rejected items, although they can be written this way - it is better for them to route rejected items to another process... which could very well just be a Discard process, if so desired.  In this case, we will do exactly that, as shown here.

![Diagram showing filter](docs/Step2.png)

In this example the filter will use a precoded FBP component called StartsWith, which takes a character string as its parameter (specified using an IIP), and whose output port names are ACC and REJ.
