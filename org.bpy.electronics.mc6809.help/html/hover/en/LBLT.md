**Branch on Less than Zero**

|     |     |
| --- | --- |
| Source Form | LBLT dddd |
| Operation | TEMP = Ml  <br>IFF  (N ^ V) = 1  then PC = PC + TEMP |
| Condition Codes | Not affected. |
| Description | Causes a branch if either, but not both, of the N (negative) or V (overflow) bits is set. That is, branch if the sign of a valid twos complement result is, or would be, negative. When used after a subtract or compare operation on twos complement binary values, this instruction will branch if the register was less than the memory operand. |
| Addressing mode | Relative |

&nbsp;