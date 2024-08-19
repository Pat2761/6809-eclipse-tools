**End of program**

|     |     |
| --- | --- |
| Source Form | END \[&lt;expression&gt;\] |
| Description | The END pseudo-op is used to signal the assembler that the end of the source input has occurred. This terminates whatever pass is currently being executed. No label is allowed and no code is generated. An expression may be given (as shown below) as the transfer address to be placed in a binary file.  \* It is optional, and if supplied when no binary file is being produced, will be ignored. |
| Comments | Note that an end statement is not strictly required, but is the only means of getting a transfer address appended to a binary output file. |

&nbsp;