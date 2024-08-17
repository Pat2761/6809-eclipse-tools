**Branch on Greater**

|     |     |
| --- | --- |
| Source Form | BGT dd |
| Operation | TEMP = Ml  <br>IFF Z & (N ^ V) = 0  then PC = PC + TEMP |
| Condition Codes | Not affected. |
| Description | Causes a branch if the N (negative) bit and V (overflow) bit are either both set or both clear and the Z (zero) bit is clear. In other words, branch if the sign of a valid twos complement result is, or would be, positive and not zero. When used after a subtract or compare operation on twos complement values, this instruction will branch if the register was greater than the memory operand. |
| Addressing mode | Relative |