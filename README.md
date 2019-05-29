# Tutorial on Flow-Based Programming (Filter File application)

## Background

Flow-Based Programming (FBP) uses a "data processing factory" metaphor for designing and building applications. FBP defines applications as networks of "black box" processes, which communicate via data chunks (called Information Packets or IPs) travelling across predefined connections (think "conveyor belts"), where the connections are specified externally to the processes. These black box processes can be reconnected endlessly to form different applications without having to be changed internally. FBP is thus naturally component-oriented.

FBP is a special case of dataflow programming characterized by asynchronous, concurrent processes "under the covers", Information Packets with defined lifetimes, named ports, "bounded buffer" connections, and definition of connections external to the components - it has been found to support improved development time and maintainability, reusability, rapid prototyping, simulation, improved performance, and good communication among developers, maintenance staff, users, systems people, and management - not to mention that FBP naturally takes advantage of multiple cores... without the programmer having to struggle with the intricacies of multitasking!

During FBP's early days, networks were coded by hand, and initially we used pencil and paper, followed by more sophisticated graphical tools, whether or not they played well with FBP software. However, with the advent of good graphical support, we now have the powerful graphical tool [DrawFBP](https://github.com/jpaulm/drawfbp), and in recent years the emphasis has been shifting to doing the diagramming on-line, and then generating the networks (we can see this progression with other flow tools on the market). Now that compile and run functions have been added to DrawFBP, the developer can do much of the development graphically, and on-line. 

This tutorial introduces the reader to the concepts of Flow-Based Programming, by means of diagrams built using DrawFBP , which is specifically oriented towards flow-based design and development, in which the reader is led through the stages of designing networks, generating Java networks from them, and running the generated Java code, using precoded components, and (later) user-written components.  This example was originally developed by my collaborator, Bob Corrick.

Almost all data in FBP is managed as "chunks" called "Information Packets (IPs)", with well-defined lifetimes (from creation to disposition), and unique ownership - an IIP can only be owned by one process, unless it is in transit between processes.  A special type of IP is called an "Initial Information Packet (IIP)", and refers to the technique FBP uses to parameterize components - IIPs are specified in the network definition, but are converted into normal IPs when they are *received* by a process. 

## Tutorial Steps

[Step0. Setup.](Step0/Step0.md)

[Step1. Draw high level diagram of app to display contents of file.](Step1/Step1.md)

[Step2. Add a filter function.](Step2/Step2.md)

[Step3. Assigning a component to the filter block.](Step3/Step3.md)

[Step4. Specifying an IIP.](Step4/Step4.md)

[Step5. Associating components with the other blocks.](Step5/Step5.md)

[Step6. Generating a running program.](Step6/Step6.md)

[Step7. Running the program.](Step7/Step7.md)

[Step8. What does a component look like?](Step8/Step8.md)

[Step9. Design "directions".](Step9/Step9.md)

[Step10. Extending the diagram.](Step10/Step10.md)

[Step11. Combining the outputs.](Step11/Step11.md)


Following steps have not been factored out yet...



## Step8.  What does a component look like?

Building a component is relatively simple, but I would like to stress again that you can do a lot of the work involved in building an application without ever doing any coding!  However, if you are interested, you can click on [this link](StartsWith.md).  Theoretically you can write components in any language that has an FBP implementation, but you may find yourself having to be creative to get different languages to intercommunicate... especially languages that are implemented by means of a virtual machine.  We will be showing you how to do this later on in the tutorial.

## Step 9. Design "directions"

As you may have intuited, in FBP we like to go from a high-level design to progressively lower levels, until we are ready to start filling in component names.  High-level components can also be replaced with what are called "subnets": diagrams with "sticky" connections, that can both function as components but can be further broken down.  This keeps the visual mode of FBP without having huge networks with dozens of blocks in a single chart.  In fact DrawFBP has a facility called "Excise" where the designer marks off a section of the diagram and "excises" it, forming a subnet and replacing the excised subnet with a single block that instantiates the subnet.  The sticky ends are called "External Ports" - more about them later.

This style of development is usually called "top-down", but other "directions" have been found useful as well.  This section is from my book:

"... The data streams which tend to drive all the others are the ones which humans will see, e.g. reports, etc., so you design these first. Then you design the processes which generate these, then the processes which generate their input, and so on. This approach to design might be called 'output backwards'...." 

Another "direction" is one I call "centre out": again from my book: " ... the 'centre out' development approach – you can get the core logic working first, and then add formatting, input editing, etc., later."

FBP also lends itself very well to rapid prototyping, and simulation as well - see the discussion about simulation systems in [Chapter I of my book](http://www.jpaulmorrison.com/fbp/intro.shtml) .  You can also start with a *simulation* of your application, and gradually replace the blocks with real application functions. 

## Step10. Extending the diagram

For this step we will stay at the diagram level - these changes could of course be made to the *generated code*, but then the code would become progressively more out of step with the diagram, which is perhaps the most important tool of communication between the various groups involved in the development of an application.

Let us now suppose that we want to count the number of rejected IPs before discarding them.  Surprise!  We happen to have a Counter component in our bag of tricks: a count IP goes to one output port, incoming IPs are routed to the other (optional) output port.  

Here is the modified diagram (we are showing it without the components or port names filled in - to stress that this is happening at the high level design stage):

![Diagram with added counter](docs/Step10.png)

Here is the segment of [compList](http://htmlpreview.github.io/?https://github.com/jpaulm/javafbp/blob/master/compList.html) that gives the port names for Counter:

![Counter](docs/counter.png)

As you have probably figured out, the counter *creates* a count IP and sends it out.  

Port `OUT` is marked *optional*.  `Counter` tests if this port is connected - and, if not, it discards IPs that are sent to this port. In what follows, we will drop the `Ignore` block.

## Step11. Combining the outputs

Now you will have noticed that there are two `Display` blocks - if you use a windowing component like `ShowText`, you will see two windows; if you use console components the outputs may be intermingled - remember that FBP is totally asynchronous. So maybe we want to combine the outputs, with the count following the accepted IPs.  Our first attempt might look like this:

![Combined outputs](docs/Step11.png)

The count cannot be generated until the inputs have all been read, so the various outputs should be displayed in the right order, but the generated count could wind up intermixed with the "accepted" stream if certain changes are made to the network.  So we should really ensure that the count is not displayed until after *all* the accepted IPs have been displayed.  We do this using the `routing.ConcatStreams` component, as follows:

![Combined outputs](docs/Step11-2.png)

`ConcatStreams` reads and outputs all of its first input, followed by the second input, and so on.  If `ConcatStreams` could only handle, say, two input streams, it might call them `IN1` and `IN2`, but it can handle any number, so it uses something called an "array port", and the individual connection points are labelled using an indexing notation, e.g. `IN[0]`, `IN[1]`, and so on.  


