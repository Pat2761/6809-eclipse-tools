Branch on Overflow Set

|     |     |
| --- | --- |
| Source Form | BVS dd |
| Operation | TEMP = Ml  <br>IFF  V = 1  then PC = PC + TEMP |
| Condition Codes | Not affected. |
| Description | Tests the state of the V (overflow) bit and causes a branch if it is set. That is, branch if the twos complement result was invalid. When used after an operation on twos complement binary values, this instruction will branch if there was an overflow. |
| Addressing mode | Relative |

&nbsp;