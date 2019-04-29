# Tutorial on Flow-Based Programming (Filter File application)

## Background

Flow-Based Programming (FBP) uses a "data processing factory" metaphor for designing and building applications. FBP defines applications as networks of "black box" processes, which communicate via data chunks (called Information Packets or IPs) travelling across predefined connections (think "conveyor belts"), where the connections are specified externally to the processes. These black box processes can be reconnected endlessly to form different applications without having to be changed internally. FBP is thus naturally component-oriented.

FBP is a special case of dataflow programming characterized by asynchronous, concurrent processes "under the covers", Information Packets with defined lifetimes, named ports, "bounded buffer" connections, and definition of connections external to the components - it has been found to support improved development time and maintainability, reusability, rapid prototyping, simulation, improved performance, and good communication among developers, maintenance staff, users, systems people, and management - not to mention that FBP naturally takes advantage of multiple cores... without the programmer having to struggle with the intricacies of multitasking!

This tutorial introduces the reader to the concepts of Flow-Based Programming, by means of diagrams built using DrawFBP, stepping the reader through the stages of designing networks, generating Java networks from them, and running the generated Java code, using precoded components, and (late) user-written components.

The term "IIP" refers to an Initial Information Packet, and refers to the technique FBP uses to parameterize components - IIPs are specified in the network definition, but are converted into normal IPs when they are "received" by a process. 


## Step 1.  Draw high level diagram of app to display contents of file. 

Here is a possible diagram:

![High level diagram](docs/Step1.png)

In this step, you should install DrawFBP (https://github.com/jpaulm/drawfbp ), and draw this diagram.

Save it in a work directory of your choice.  If you open it using Wordpad, it should look like the file you get when you click on [this link](docs/Step1.drw).

Of course, if you have trouble drawing the diagram, you can simply copy the `.drw` file, and open this file under DrawFBP.

At this point, you should take a look at the functions provided by DrawFBP.  DrawFBP has a Help facility, which takes you through a lot of the DrawFBP functionality.

Now at this point, you can simply assign real live components to the blocks in the diagrams (plus IIPs and port names), and you will basically have a running program.  However, I am going to assume that you want to add filter function between the two processes, so that is what we will do in Step2.

## Step2. Add a filter function 

In this step we are going to add a filter function between the two blocks shown above.  Filter functions (filters, for short) are commonly used in FBP, and typically have two outputs: accepted IPs, and rejected IPs.  Filters should not just drop rejected items, although they can be written this way - it is better for them to route rejected items to another process... which could very well just be a Discard process, if so desired.  In this case, we will do exactly that, as shown here.

![Diagram showing filter](docs/Step2.png)

For the purposes of this tutorial, we will specify that the records read by the 'read' process need to be selected by matching on the first character. As it happens, there is a precoded, reusable FBP component called StartsWith, which takes a character string as its parameter (specified using an IIP), and whose output port names are ACC and REJ.  We will therefore associate this component with the filter block, using the Choose Component/Subnet Class function provided for DrawFBP blocks.  This function is provided by DrawFBP for both the Java and C# language choices.

Since different components specify different port names, you can check whether you have set up the port names correctly by clicking on the Display Description and Port Info function provided for DrawFBP blocks.  In addition, once you have chosen a component, this function will indicate whether the ports have all been connected, and whether in fact any port names have been misspelled.

This display should look like this at this point:

![StartsWith ports](docs/StartsWith.png)


