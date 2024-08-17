**Branch on Greater than or Equal to Zero**

|     |     |
| --- | --- |
| Source Form | LBGE dddd |
| Operation | TEMP = Ml  <br>IFF (N ^ V) = 0  then PC = PC + TEMP |
| Condition Codes | Not affected. |
| Description | Causes a branch if the N (negative) bit and the V (overflow) bit are either both set or both clear. That is, branch if the sign of a valid twos complement result is, or would be, positive. When used after a subtract or compare operation on twos complement values, this instruction will branch if the register was greater than or equal to the memory operand. |
| Addressing mode | Relative |