**Push Registers on the Hardware Stack**

|     |     |
| --- | --- |
| Source Form | PSHS register list  <br>PSHS #LABEL  <br>Push order:  <br><img src="../_resources/pshs.jpg" alt="pshs.jpg" width="213" height="52"> |
| Operation | IFF b7 of postbyte set, then: SP = SP -1 , SP = PCL  <br>                                              SP = SP -1 , SP = PCH  <br>IFF b6 of postbyte set, then: SP = SP -1 , SP = UL  <br>                                              SP = SP -1 , SP = UH  <br>IFF b5 of postbyte set, then: SP = SP -1 , SP = YL  <br>                                              SP = SP -1 , SP = YH  <br>IFF b4 of postbyte set, then: SP = SP -1 , SP = XL  <br>                                              SP = SP -1 , SP = XH  <br>IFF b3 of postbyte set, then: SP = SP -1 , SP = DP  <br>IFF b2 of postbyte set, then: SP = SP -1 , SP = B  <br>IFF b1 of postbyte set, then: SP = SP -1 , SP = A  <br>IFF b0 of postbyte set, then: SP = SP -1 , SP = CC |
| Condition Codes | Not affected |
| Description | All, some, or none of the processor registers are pushed onto the hardware stack (with the exception of the hardware stack pointer itself). |
| Addressing mode | Immediate |
| Comments | A single register may be placed on the stack with the condition codes set by doing an auto decrement store onto the stack (example: STX,--S). |

&nbsp;