# Tutorial on Flow-Based Programming (Filter File application)

## Background

In the real world, "everything flows".  Heraclitus (Ancient Greece, ca.535 – ca.475 BC, known as "the weeping philosopher"), said it first: πάντα ῥεῖ (pronounced "panta rhei").  In the real world things flow!  It is reasonable that data should flow too - it flows to and from storage devices, to and from screens, from keyboards, to printers, and sometimes it loops around and gets fed in again!  However, this concept doesn't really fit very well with what we call "procedural programming", which feels very different. In fact humans are not particularly good at procedural thinking!  Dr. Lance Miller of IBM looked for instances of procedural thinking in real life, and all he could come up with were recipes, and assembling toy kits...  Even recipes often have implicit parallelism which we donʼt notice. For instance, “add boiling water” implies that the water must have started boiling while some other step was going on, so that it would be available when needed

How do you square this circle?  Years of training? Even that may not help a lot!  I once had the dubious pleasure of having to modify an update program (not FBP, obviously!) whose author had written the client an explanation of why his enhancement request could not be satisfied, which started, “Owing to the limitations of data processing,...”! My clear recollection is that modifying that program (and, for a conventional program, it was really quite well-written) was only *almost* impossible!

If application development is mostly about processing *data*, why not use an approach that is data-, rather than procedure-, oriented?  Describe the data, and the transforms that have to be applied to it.  Maybe start off with the final output data, and then work backwards to the original inputs...?

This tutorial is designed not only to introduce you, the reader, to the *concepts* of Flow-Based Programming (FBP), but  to give you a feeling for what it feels like to actually use the tool which supports these concepts in a number of different ways. FBP is "language-agnostic", but in this case we will using Java, as it is more closely integrated with the tool we will be using - [DrawFBP](https://github.com/jpaulm/drawfbp).  However, we could equally well use any other language which has an FBP implementaion, although it would involve a bit more jumping back and forth between different tools.

FBP uses a "data processing factory" metaphor for designing and building applications. FBP defines applications as networks of "black box" processes, which communicate via data chunks (called Information Packets or IPs) travelling across predefined connections (think "conveyor belts"), where the connections are specified externally to the processes. These black box processes can be reconnected endlessly to form different applications without having to be changed internally. FBP is thus naturally component-oriented.

## Tutorial Steps

[Step 0. Setup.](Step0/)

[Step 1. Draw high level diagram of app to display contents of file.](Step1/)

[Step 2. Add a filter function.](Step2/)

[Step 3. Assigning a component to the filter block.](Step3/)

[Step 4. Specifying an IIP.](Step4/)

[Step 5. Associating components with the other blocks.](Step5/)

[Step 6. Generating a running program.](Step6/)

[Step 7. Running the program.](Step7/)

[Step 8. What does a component look like?](Step8/)

[Step 9. Design "directions".](Step9/)

[Step 10. Extending the diagram.](Step10/)

[Step 11. Combining the outputs.](Step11/)

