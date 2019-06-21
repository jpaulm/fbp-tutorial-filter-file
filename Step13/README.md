
<link rel="stylesheet" type="text/css" href="../style.css">

## Step13-"Brackets" and "substreams"

Up to now we have been dealing with "streams" of data chunks called "Information Packets" (IPs), but very often we want to subdivide the IP stream into smaller (often nested) groupings.  We call them "substreams", and they are delimited by special non-data IPs called "open bracket" and "close bracket".

Here is an example from the book "Flow-Based Programming" (Fig. 9.1): 

 IP type     | branch   | acct #   | date     | amount  | DEP/WD
 --- | --- | --- | --- | ---:| --- 

 account | 1 | 1 | | |
 trans | 1 | 1 | 1992/3/12 |  12.82 | DEP
 trans | 1 | 1 | 1992/3/12 | 101.99 | WD
 trans | 1 | 1 | 1992/3/12 |  43.56 | WD
 trans | 1 | 1 | 1992/3/26 |  54.77 | WD
 trans | 1 | 1 | 1992/3/26 |  12.26 | WD
 
 account | 1 | 2 | | |
 trans | 1 | 2 | 1992/3/03 |  34.88 | DEP
 trans | 1 | 2 | 1992/3/03 |  10.00 | WD
       
 account | 2 | 1 | | |
 trans | 2 | 1 | 1992/2/29 |  25.99 | DEP
 trans | 2 | 1 | 1992/3/25 |  87.56 | DEP

 account | 2 | 3 | | |
 trans | 2 | 3 | 1992/3/01 |  34.88 | WD
 trans | 2 | 3 | 1992/3/17 |  88.22 | DEP

<span class=middle> &lt;== <a href="../Step12/">  Previous</a> / <a href="https://github.com/jpaulm/fbp-tutorial-filter-file/"> Index</a> /  Next ==&gt; (none)</span>
