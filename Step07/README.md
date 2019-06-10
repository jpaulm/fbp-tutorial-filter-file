
<link href="../style.css" rel="stylesheet" type="text/css">

## Step07-Run the program

The generated code shown above is a standard JavaFBP network, and can be executed as described in https://github.com/jpaulm/javafbp/blob/master/README.md .  

### Running on DOS

Essentially, you will have downloaded the JavaFBP jar file earlier, so position to the `bin` directory of your project, and enter the following into the DOS window:

      java -cp "<JavaFBP directory>/javafbp-x.y.z.jar;." <program class name> 
      
where `x.y.z` is the version of the jar file you downloaded in **Step0**.  Note the final **;.**.

<program class name> should include the package ID, with periods instead of slashes, and the final `.class` should be dropped.


### Running on *nix
      
Replace the ';'  in the `-cp` parameter with ":" for *nix.   

### Running in Eclipse

Go to `Properties/Java Build Path` for your project; click on `Add External Jars`, add your JavaFBP jar file to the list, and then hit `Apply' and `OK`.   

Select `Debug` for your project.


### Set up some data   

Nearly forgot - we need to give it some data: ReadFile handles any sequential file.  In this case the file reader's IIP names at a CSV file (https://en.wikipedia.org/wiki/Comma-separated_values ), and the selected records will appear in a separate window. 

<span class=middle> &lt;== <a href="../Step06/">  Previous</a> / <a href="../README.md"> Index</a> / <a href="../Step08/"> Next</a> ==&gt;</span>