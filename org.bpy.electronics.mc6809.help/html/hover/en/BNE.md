**Branch Not Equal**

|     |     |
| --- | --- |
| Source Form | BNE dd |
| Operation | TEMP = Ml  <br>IFF  Z = 0  then PC = PC + TEMP |
| Condition Codes | Not affected. |
| Description | Tests the state of the Z (zero) bit and causes a branch if it is clear. When used after a subtract or compare operation on any binary values, this instruction will branch if the register is, or would be, not equal to the memory operand. |
| Addressing mode | Relative |

&nbsp;