**Branch if Higher**

|     |     |
| --- | --- |
| Source Form | BHI dd |
| Operation | TEMP = Ml  <br>IFF  C \| Z = 0  then PC = PC + TEMP |
| Condition Codes | Not affected. |
| Description | Causes a branch if the previous operation caused neither a carry nor a zero result. When used after a subtract or compare operation on unsigned binary values, this instruction will branch if the register was higher than the memory operand. |
| Addressing mode | Relative |
| Comments | Generally not useful after INC/DEC, LD/TST, and TST/CLR/COM instructions. |