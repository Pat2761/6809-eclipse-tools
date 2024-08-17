**Branch on Lower or Same**

|     |     |
| --- | --- |
| Source Form | LBLS dd |
| Operation | TEMP = Ml  <br>IFF  (C \| Z) = 1  then PC = PC + TEMP |
| Condition Codes | Not affected. |
| Description | Causes a branch if the previous operation caused either a carry or a zero result. When used after a subtract or compare operation on unsigned binary values, this instruction will branch if the register was lower than or the same as the memory operand. |
| Addressing mode | Relative |
| Comments | Generally not useful after INC/DEC, LD/ST, and TST/CLR/COM instructions. |

&nbsp;