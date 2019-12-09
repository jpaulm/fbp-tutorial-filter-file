
<link href="../style.css" rel="stylesheet" type="text/css">

## Step06 - Generate a Java program
 
Now we have all the necessary information filled in to generate a running program, so click on `File/Generate ... Network` - Java is the default language, so in the `File` menu, this function will show up as `Generate Java Network`.  You can switch languages by clicking on `Select Diagram Language`, and this menu entry will change accordingly: currently 4 languages are supported - Java, C#, JSON and FBP.

Here is the result:

![Generated Java program](Step06_code.png)

DrawFBP remembers the last used package name, so it allows the developer to change it to whatever matches the directory structure - or Eclipse will prompt him/her to change it, if necessary, when the code is executed. 

DrawFBP's colouring of code is mostly to make character strings and comments stand out from the rest of the text.

`component` and `connect` are self-explanatory! `initialize` builds an IIP, and connects it to an input port of a component.

When using `Save As`, to get ready for compiling and running the FBP network, please be aware that for Java DrawFBP uses the convention of matching sub-directories under `src` (for the `.java` files) and `bin` (for the compiled `.class` files).


<span class=middle> &lt;== <a href="../Step05/">  Previous</a> / <a href="https://github.com/jpaulm/fbp-tutorial-filter-file/"> Index</a> / <a href="../Step07/"> Next</a> ==&gt;</span>
