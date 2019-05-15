# Tutorial on Flow-Based Programming (Filter File application)

## Background

Flow-Based Programming (FBP) uses a "data processing factory" metaphor for designing and building applications. FBP defines applications as networks of "black box" processes, which communicate via data chunks (called Information Packets or IPs) travelling across predefined connections (think "conveyor belts"), where the connections are specified externally to the processes. These black box processes can be reconnected endlessly to form different applications without having to be changed internally. FBP is thus naturally component-oriented.

FBP is a special case of dataflow programming characterized by asynchronous, concurrent processes "under the covers", Information Packets with defined lifetimes, named ports, "bounded buffer" connections, and definition of connections external to the components - it has been found to support improved development time and maintainability, reusability, rapid prototyping, simulation, improved performance, and good communication among developers, maintenance staff, users, systems people, and management - not to mention that FBP naturally takes advantage of multiple cores... without the programmer having to struggle with the intricacies of multitasking!

This tutorial introduces the reader to the concepts of Flow-Based Programming, by means of diagrams built using DrawFBP ( https://github.com/jpaulm/drawfbp ), a diagramming tool specifically oriented towards flow-based design and development, in which the reader is led through the stages of designing networks, generating Java networks from them, and running the generated Java code, using precoded components, and (later) user-written components.  This example was originally developed by my collaborator, Bob Corrick.

Almost all data in FBP is managed as "chunks" called "Information Packets (IPs)", with well-defined lifetimes (from creation to disposition), and unique ownership - an IIP can only be owned by one process, unless it is in transit between processes.  A special type of IP is called an "Initial Information Packet (IIP)", and refers to the technique FBP uses to parameterize components - IIPs are specified in the network definition, but are converted into normal IPs when they are *received* by a process. 


## Step 1.  Draw high level diagram of app to display contents of file. 

Here is a possible diagram, showing a simple application which displays the contents of a file:

![High level diagram](docs/Step1.png)

To execute this step of the tutorial, you will need to install DrawFBP ( https://github.com/jpaulm/drawfbp ), and draw this diagram.

Save the result in a work directory of your choice.  If you open it using Wordpad, it should look like the file you get when you click on [this link](docs/Step1.drw).

Of course, if you have trouble drawing the diagram, you can go the other way - simply copy the `.drw` file, and open this file under DrawFBP.

At this point, you should take a look at the functions provided by DrawFBP.  DrawFBP has a Help facility, which takes you through a lot of the DrawFBP functionality.

Now at this point, you can simply assign real live components to the blocks in the diagrams (plus IIPs and port names), and you will basically have a running program.  However, I am going to assume that you want to add a filter function between the two processes in the design phase (rather than later as the application "evolves"), so that is what we will do in Step2.

## Step2. Add a filter function 

In this step we are going to add a filter function between the two blocks shown above.  Filter functions (filters, for short) are commonly used in FBP, and conventionally have two outputs: *accepted* IPs, and *rejected* IPs.  Filters should not just drop rejected items, although they can be written this way - it is better for them to route rejected items to another process... which could very well just be a Discard process, if so desired.  In this case, we will do exactly that, as shown here.

![Diagram showing filter](docs/Step2.png)

The captions `accepted` and `rejected` are generated using a block type in DrawFBP called "Legend".

When you are ready to add the filter function, you will of course need to delete the existing arrow - right click on the arrow itself, and select Delete.

## Step3. Assigning a component to the filter block

For the filter function, we need a component that will match the first character against a character provided as a parameter. As it happens(!), JavaFBP provides a precoded, reusable FBP component called `StartsWith`, which takes a character string as its parameter (specified using an IIP), and whose output port names are ACC and REJ.  **FBP is not designed to be a coding language**.  The ideal is to work with a library of precoded, pretested components.  **You only need to write a component if you can't find an appropriate one - and in that case, you should try to write one that other people will find useful.**

How do we find a suitable component?  Well, the first step is to install JavaFBP ( https://github.com/jpaulm/javafbp ) in a directory called `javafbp`.  Components are grouped by function, so you can either go there directly, or you can display the JavaFBP components list by clicking on https://htmlpreview.github.io/?https://github.com/jpaulm/javafbp/blob/master/compList.html then `Edit/Find in This Page` (unfortunately you cannot click on the `compList.html` file directly on GitHub).  The Javadoc facility does not provide the information you will need, so we will not be maintaining it in future releases.

**TODO: javadoc doesn't show port names and their functions! See issue #1. Closed**

Here is a portion of `compList`:

![compList part](docs/compListPart.png)

We now have to associate the `StartsWith` component with the filter block.  Since the component is in JavaFBP, you will need to use DrawFBP's `Locate JavaFBP Jar File` function, and then find `StartsWith` in that jar file, using the using the `Choose Component/Subnet Class` block function provided by DrawFBP. 

Since different components specify different port names, you need to find out the port names used by `StartsWith`.  There are three ways available to do this:

- go to the source code for the component in the JavaFBP repo ( `src/main/java/com/jpaulmorrison/fbp/core` ), and look at the annotations (`@OutPorts` and `@InPorts`), or 

- once you have associated a component with your block in the diagram, you can right click on the `Display Description and Port Info` function provided for DrawFBP blocks, which will bring up a display like the following (doing the associate function will also bring this up):

![StartsWith ports](docs/StartsWith.png)

Of course, if you haven't filled in any of the port names, this display will show `NO` in the `Connected?` column.

- look at `compList.html` by clicking on http://htmlpreview.github.io/?https://github.com/jpaulm/javafbp/blob/master/compList.html , then `Edit/Find in This Page` .

**TODO: Port display for many components are missing port function annotations - these need to be filled in in JavaFBP.  See issue #2**

After filling in the `IN`, `ACC` and `REJ` port names, the diagram should now look like this:

![Diagram using StartsWith](docs/Step3.png)

If any port names have been misspelled, you will see a port name `Missing`, and another one unrecognized (`?` under `Connected?`).

## Step4.  Specifying an IIP

Now, as shown in the port list shown above, `TEST` is the port name for the IIP which specifies the test character for matching. As stated above, IIPs are the way FBP reusable components are parameterized.  Usually the parameter is specified in a network definition, so that a network can use the same component in more than one place in the network - with different parameters - but IIPs have the added advantage that the network can easily be changed to present the parameter information as a normal IP, obtained from an upstream process.

In this case the parameter for `StartsWith` will be provided as an IIP, specified in the diagram.  In DrawFBP just click on the button at the bottom marked `Initial IP`, after which clicking on the drawing screen will now create an IIP, and allow some text to be entered.  The diagram now looks like this:

![Diagram with IIP](docs/Step4.png)

Selecting `StartWith` and clicking on `Display Description and Port Info` will verify that all ports are now correctly connected.

## Step5.  Associating components with the other blocks

Pretty straightforward: just click on each block, and select `Choose Component/Subnet Class`.  

The first block (`read sample file`) would most probably use the `ReadFile` component in the `core/components/io` package in the JavaFBP jar file.  This requires an IIP containing the file name - port name `SOURCE`.

The `ignore` block would most likely use the `Discard` component in the `core/components/routing` package, although of course you could use any component here, or even route the "ignored" IPs to other parts of the diagram.

That just leaves `display accepted lines`.  In his example, Bob Corrick decided to use the `ShowText` component.  This component puts up its output in a separate window, and requires an IIP with port name `TITLE`.  `ShowText` has an optional port called `OUT` - if this is connected, incoming IPs are routed to this port after being displayed.

Here is the final diagram:

![Diagram with components and IIPs filled in](docs/Step5.png)

## Step6.  Generating a running program

Now we have all the necessary information filled in to generate a running program, so click on `Generate Java Network` - Java is the default language, so this function has `Java` filled in in the File menu. This can be changed by clicking on `Select Diagram Language`: currently 4 languages are supported - Java, C#, JSON and FBP.

Here is the result:

![Generated Java program](docs/Step5_code.png)

DrawFBP remembers the last used package name, so it allows the developer to change it to whatever matches the directory structure - or Eclipse will prompt him/her to change it, if necessary, when the code is executed. 

DrawFBP's colouring of code is mostly to make character strings and comments stand out from the rest of the text.

`component` and `connect` are self-explanatory! `initialize` builds an IIP, and connects it to an input port of a component.


## Step7.  Running the program

The generated code shown above is a standard JavaFBP network, and can be executed as described in https://github.com/jpaulm/javafbp/blob/master/README.md .

Nearly forgot - we need to give it some data: ReadFile handles any sequential file.  In this case we are pointing it at a CSV file ( https://en.wikipedia.org/wiki/Comma-separated_values ), and the selected records will appear in a separate window. 


## Step8.  What does a component look like?

Building a component is relatively simple, but I would like to stress again that you can do a lot of the work involved in building an application without ever doing any coding!  To see the JavaFBP `StartsWith` component, click on [this link](StartsWith.md).


