
## Step 9. Design "directions"

As you may have intuited, in FBP we like to go from a high-level design to progressively lower levels, until we are ready to start filling in component names.  High-level components can also be replaced with what are called "subnets": diagrams with "sticky" connections, that can both function as components but can be further broken down.  This keeps the visual mode of FBP without having huge networks with dozens of blocks in a single chart.  In fact DrawFBP has a facility called "Excise" where the designer marks off a section of the diagram and "excises" it, forming a subnet and replacing the excised subnet with a single block that instantiates the subnet.  The sticky ends are called "External Ports" - more about them later.

This style of development is usually called "top-down", but other "directions" have been found useful as well.  This section is from my book:

"... The data streams which tend to drive all the others are the ones which humans will see, e.g. reports, etc., so you design these first. Then you design the processes which generate these, then the processes which generate their input, and so on. This approach to design might be called 'output backwards'...." 

Another "direction" is one I call "centre out": again from my book: " ... the 'centre out' development approach – you can get the core logic working first, and then add formatting, input editing, etc., later."

FBP also lends itself very well to rapid prototyping, and simulation as well - see the discussion about simulation systems in [Chapter I of my book](http://www.jpaulmorrison.com/fbp/intro.shtml) .  You can also start with a *simulation* of your application, and gradually replace the blocks with real application functions. 

<div class=middle>  <a href="../Step8/README.md"> &lt;== Previous</a> / <a href="../README.md"> Index</a> / <a href="../Step10/README.md"> Next ==&gt; </a> </div>
