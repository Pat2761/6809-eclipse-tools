**Branch on Less than or Equal to Zero**

|     |     |
| --- | --- |
| Source Form | BLE dd |
| Operation | TEMP = Ml  <br>IFF  Z \| \[N ^ V\] = 1  then PC = PC + TEMP |
| Condition Codes | Not affected. |
| Description | Causes a branch if the exclusive OR of the N (negative) and V (overflow) bits is 1 or if the Z (zero) bit is set. That is, branch if the sign of a valid twos complement result is, or would be negative. When used after a subtract or compare operation on twos complement values, this instruction will branch if the register was less than or equal to the memory operand. |
| Addressing mode | Relative |