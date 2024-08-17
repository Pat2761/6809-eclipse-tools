**Branch if Higher or Same**

|     |     |
| --- | --- |
| Source Form | LBHS dddd |
| Operation | TEMP = Ml  <br>IFF  C = 0  then PC = PC + TEMP |
| Condition Codes | Not affected. |
| Description | Tests the state of the C (carry) bit and causes a branch if it is clear. When used after a subtract or compare on unsigned binary values, this instruction will branch if the register was higher than or thesame as the memory operand. |
| Addressing mode | Relative |
| Comments | This is a duplicate assembly-language mnemonic for the single machine instruction BCC. Generally not useful after INC/DEC,LD/ST, and TST/CLR/COM instructions. |