
<link href="../style.css" rel="stylesheet" type="text/css">

## Step01 - Draw an end-to-end diagram. 

Here is a possible diagram, showing a simple application which displays the contents of a file:

![High level diagram](Step01.png)

To execute this step of the tutorial, you will need to install DrawFBP, and draw this diagram.

Drawing rules:

- block descriptions must be unique in a diagram (however, DrawFBP will make them unique if needed)
- port names need only be unique for a given block
- component names may be shared by multiple blocks

Save the result in a work directory of your choice.  If you open it using Wordpad, it should look like the file you get when you click on [this link](diagrams/Step01.drw).

Of course, if you have trouble drawing the diagram, you can go the other way - simply copy the `.drw` file, and open this file under DrawFBP.

At this point, you should take a look at the functions provided by DrawFBP. DrawFBP has a Help facility, which takes you through a lot of the DrawFBP functionality.

Now at this point, you can simply assign real live components to the blocks in the diagrams (plus IIPs and port names), and you will basically have a running program.  However, I am going to assume that you want to add a filter function between the two processes in the design phase (rather than later as the application "evolves"), so that is what we will do in Step2.

<span class=middle> &lt;== <a href="../Step00/">  Previous</a> / <a href="https://github.com/jpaulm/fbp-tutorial-filter-file/"> Index</a> / <a href="../Step02/"> Next</a> ==&gt;</span> 
