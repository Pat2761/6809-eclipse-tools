**Branch to Subroutine**

|     |     |
| --- | --- |
| Source Form | LBSR dddd |
| Operation | TEMP = Ml  <br>SP = SP-1,(SP) = POL  <br>SP = SP-1,(SP) = PCH  <br>PC =  PC + TEMP |
| Condition Codes | Not affected. |
| Description | The program counter is pushed onto the stack. The program counter is then loaded with the sum of the program counter and the offset. |
| Addressing mode | Relative |
| Comments | A return from subroutine (RTS) Instruction is used to reverse this process and must be the last instruction executed in a subroutine. |

&nbsp;