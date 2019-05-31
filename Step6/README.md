## Step6.  Generating a running program

Now we have all the necessary information filled in to generate a running program, so click on `Generate Java Network` - Java is the default language, so this function has `Java` filled in in the File menu. This can be changed by clicking on `Select Diagram Language`: currently 4 languages are supported - Java, C#, JSON and FBP.

Here is the result:

![Generated Java program](docs/Step6_code.png)

DrawFBP remembers the last used package name, so it allows the developer to change it to whatever matches the directory structure - or Eclipse will prompt him/her to change it, if necessary, when the code is executed. 

DrawFBP's colouring of code is mostly to make character strings and comments stand out from the rest of the text.

`component` and `connect` are self-explanatory! `initialize` builds an IIP, and connects it to an input port of a component.


Next:  [Step7. Running the program.](../Step7/Step7.md)

Index: [Go to higher level.](../README.md)
