**Register definition**

|     |     |
| --- | --- |
| Source Form | &lt;label&gt; REG &lt;register list&gt; |
| Description | The REG directive allows the user to setup a list of registers for use by the push and pull instructions. This list is represented by a value and the value is equated to the label supplied. In this respect, the REG directive is similar to the EQU directive.<br><br>As an example, suppose a program has a large number of occurences of the following instructions:  <br>   <br>  PSHS A,B,Y,U,DP  <br>  PULS A,B,Y,U,DP  <br>   <br>  To make things more convenient and less error prone the REG directive could be used as shown here:  <br>   <br>  RLIST2 REG A,B,Y,U,DP  <br>   <br>  Now all the pushes and pulls referred to above could be accomplished with the statements:  <br>   <br>  PSHS #RLIST2  <br>  PULS #RLIST2  <br>   <br> Of course, the register list may still be typed out on push and pull instructions or an immediate value   (with the desired bit pattern) may be specified. |

&nbsp;