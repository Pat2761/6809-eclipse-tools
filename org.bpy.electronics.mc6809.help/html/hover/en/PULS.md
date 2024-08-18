**Pull Registers from the Hardware Stack**

|     |     |
| --- | --- |
| Source Form | PULS register list  <br>PULS #LABEL  <br>Pull order:  <br><img src="../_resources/puls.jpg" alt="puls.jpg" width="201" height="53"> |
| Operation | IFF b0 of post byte set, then: CC = SP, SP = SP + 1  <br>IFF b1 of post byte set, then: A = SP, SP = SP + 1  <br>IFF b2 of post byte set, then: B = SP, SP = SP + 1  <br>IFF b3 of post byte set, then: DP = SP, SP = SP + 1  <br>IFF b4 of post byte set, then: XH = SP, SP = SP + 1  <br>                                               XL = SP, SP = SP + 1  <br>IFF b5 of post byte set, then: YH = SP, SP = SP + 1  <br>                                               YL = SP, SP = SP + 1  <br>IFF b6 of post byte set, then: UH = SP, SP = SP + 1  <br>                                               UL = SP, SP = SP + 1  <br>IFF b7 of post byte set, then: PC = SP, SP = SP + 1  <br>                                               PC = SP, SP = SP + 1 |
| Condition Codes | May be pulled from stack; not affected otherwise.Not affected |
| Description | All, some, or none of the processor registers are pulled from the hardware stack (with the exception of the hardware stack pointer itself). |
| Addressing mode | Immediate |
| Comments | A single register may be pulled from the stack with condition codes set by doing an auto increment load from the stack (example:LDX,S++). |