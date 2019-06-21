
<link href="../style.css" rel="stylesheet" type="text/css">

## Step00-Setup DrawFBP

### DrawFBP

We will start by installing DrawFBP, the FBP diagramming tool.  Go to https://github.com/jpaulm/drawfbp/releases/tag/v2.16.15 (8,597,247 bytes), and download the DrawFBP jar file, and store it on your desktop.  

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

If at some later stage of testing, you want to point at a diagram's `.drw` file and run DrawFBP, go to your DrawFBP local directory, and type 

      drawfbp.bat <diagram file name>
      
`drawfbp.bat` references the current DrawFBP jar file, but you can create your own version  if you prefer.
      
      
### Locating JavaFBP jar file

At this point, you should locate the JavaFBP jar file (it can be found in `https://github.com/jpaulm/javafbp/releases`), download it, and tell DrawFBP where it is, by using the DrawFBP function `File/Locate JavaFBP Jar File`.  Once you tell DrawFBP where it is, DrawFBP will remember the location from then on.  

### Help facility

The DrawFBP Help facility uses the standard `JavaHelp` facility, which you can download from Maven Central, by doing a search for the artifact called `javahelp` .  After downloading it and saving it, click on the DrawFBP function `File/Locate DrawFBP Help File`.   Once you tell DrawFBP where it is, DrawFBP will remember the location from then on.  

<span class=middle> <a href="https://github.com/jpaulm/fbp-tutorial-filter-file/"> Index</a> / <a href="../Step01/"> Next </a>==&gt;</span> 

