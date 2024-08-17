**Branch on Overflow Clear**

|     |     |
| --- | --- |
| Source Form | BVC dd |
| Operation | TEMP = Ml  <br>IFF  V = 0  then PC = PC + TEMP |
| Condition Codes | Not affected. |
| Description | Tests the state of the V (overflow) bit and causes a branch if it is clear. That is, branch if the twos complement result was valid. When used after an operation on twos complement binary values, this instruction will branch if there was no overflow.. |
| Addressing mode | Relative |

&nbsp;