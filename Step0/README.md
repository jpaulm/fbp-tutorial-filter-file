## Step 0.  Setup

### DrawFBP

We will start by installing DrawFBP, the FBP diagramming tool.  Go to https://github.com/jpaulm/drawfbp , and obtain the DrawFBP jar file from the latest release in DrawFBP/Releases, and store the jar file on your desktop.  

Alternatively, you can do a search for `DrawFBP` on Maven.  

Make sure you have Java installed, by issuing

       java -version
       
from the command line.

Either way, to run the tool, just double click on the jar file.

Alternatively, you can enter the command

       java -jar DrawFBP-[all-]x.y.z.jar
       
from the command line (you need `all-` if it came from Releases, and not if it came from Maven).

When you first fire up DrawFBP, you will see the DrawFBP logo, with 3 connected blocks of different colours.  This will last for a few seconds... or until you move the mouse.  In normal use, DrawFBP displays the diagram you were working on, so you will not see the logo.

As you develop various functions in DrawFBP, useful information will be stored in `C:Users\<username>\DrawFBPProperties.xml`.

### Locating JavaFBP jar file

At this point, you should locate the JavaFBP jar file (it can be found in `https://github.com/jpaulm/javafbp/releases`), download it, and tell DrawFBP where it is, by using the DrawFBP function `File/Locate JavaFBP Jar File`.  Once you tell DrawFBP where it is, DrawFBP will remember the location from then on.  

### Help facility

The DrawFBP Help facility uses the standard `JavaHelp` facility, which you can download from Maven Central, by doing a search for the artifact called `javahelp` .  After downloading it and saving it, click on the DrawFBP function `File/Locate DrawFBP Help File`.   Once you tell DrawFBP where it is, DrawFBP will remember the location from then on.  

Next:  [Step1. Draw high level diagram of app to display contents of file. ](../Step1/Step1.md)

Index: [Go to higher level.](../README.md)