# Tutorial on Flow-Based Programming (Filter File application)

## Background

Flow-Based Programming (FBP) uses a "data processing factory" metaphor for designing and building applications. FBP defines applications as networks of "black box" processes, which communicate via data chunks (called Information Packets or IPs) travelling across predefined connections (think "conveyor belts"), where the connections are specified externally to the processes. These black box processes can be reconnected endlessly to form different applications without having to be changed internally. FBP is thus naturally component-oriented.

FBP is a special case of dataflow programming characterized by asynchronous, concurrent processes "under the covers", Information Packets with defined lifetimes, named ports, "bounded buffer" connections, and definition of connections external to the components - it has been found to support improved development time and maintainability, reusability, rapid prototyping, simulation, improved performance, and good communication among developers, maintenance staff, users, systems people, and management - not to mention that FBP naturally takes advantage of multiple cores... without the programmer having to struggle with the intricacies of multitasking!

During FBP's early days, networks were coded by hand, and initially we used pencil and paper, followed by more sophisticated graphical tools, whether or not they played well with FBP software. However, with the advent of good graphical support, we now have the powerful graphical tool [DrawFBP](https://github.com/jpaulm/drawfbp), and in recent years the emphasis has been shifting to doing the diagramming on-line, and then generating the networks (we can see this progression with other flow tools on the market). Now that compile and run functions have been added to DrawFBP, the developer can do much of the development graphically, and on-line. 

This tutorial introduces the reader to the concepts of Flow-Based Programming, by means of diagrams built using DrawFBP , which is specifically oriented towards flow-based design and development, in which the reader is led through the stages of designing networks, generating Java networks from them, and running the generated Java code, using precoded components, and (later) user-written components.  This example was originally developed by my collaborator, Bob Corrick.

Almost all data in FBP is managed as "chunks" called "Information Packets (IPs)", with well-defined lifetimes (from creation to disposition), and unique ownership - an IIP can only be owned by one process, unless it is in transit between processes.  A special type of IP is called an "Initial Information Packet (IIP)", and refers to the technique FBP uses to parameterize components - IIPs are specified in the network definition, but are converted into normal IPs when they are *received* by a process. 

## Tutorial Steps

[Step0. Setup.](Step0/README.md)

[Step1. Draw high level diagram of app to display contents of file.](Step1/README.md)

[Step2. Add a filter function.](Step2/README.md)

[Step3. Assigning a component to the filter block.](Step3/README.md)

[Step4. Specifying an IIP.](Step4/README.md)

[Step5. Associating components with the other blocks.](Step5/README.md)

[Step6. Generating a running program.](Step6/README.md)

[Step7. Running the program.](Step7/README.md)

[Step8. What does a component look like?](Step8/README.md)

[Step9. Design "directions".](Step9/README.md)

[Step10. Extending the diagram.](Step10/README.md)

[Step11. Combining the outputs.](Step11/README.md)

