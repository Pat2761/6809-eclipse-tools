**Push Registers on the User Stack**

|     |     |
| --- | --- |
| Source Form | PSHU register list  <br>PSHU #LABEL  <br>Push order:  <br><img src="../_resources/pshu.jpg" alt="pshu.jpg" width="218" height="54" class="jop-noMdConv"> |
| Operation | IFF b7 of post byte set, then: SP = SP -1 , SP = PCL  <br>                                              SP = SP -1 , SP = PCH  <br>IFF b6 of post byte set, then: SP = SP -1 , SP = SL  <br>                                              SP = SP -1 , SP = SH  <br>IFF b5 of post byte set, then: SP = SP -1 , SP = YL  <br>                                              SP = SP -1 , SP = YH  <br>IFF b4 of post byte set, then: SP = SP -1 , SP = XL  <br>                                              SP = SP -1 , SP = XH  <br>IFF b3 of post byte set, then: SP = SP -1 , SP = DP  <br>IFF b2 of post byte set, then: SP = SP -1 , SP = B  <br>IFF b1 of post byte set, then: SP = SP -1 , SP = A  <br>IFF b0 of post byte set, then: SP = SP -1 , SP = CC |
| Condition Codes | Not affected |
| Description | All, some, or none of the processor registers are pushed onto the user stack (with the exception of the user stack pointer itself). |
| Addressing mode | Immediate |
| Comments | A single register may be placed on the stack with the condition codes set by doing an auto decrement store onto the stack (example: STX,--U). |

&nbsp;