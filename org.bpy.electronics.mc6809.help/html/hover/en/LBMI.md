**Branch on Minus**

|     |     |
| --- | --- |
| Source Form | LBMI dddd |
| Operation | TEMP = Ml  <br>IFF  N = 1  then PC = PC + TEMP |
| Condition Codes | Not affected. |
| Description | Tests the state of the N (negative) bit and causes a branch if set. That is, branch if the sign of the twos complement result is negative. |
| Addressing mode | Relative |
| Comments | When used after an operation on signed binary values, this instruction will branch if the result is minus. It is generally preferred to use the LBLT instruction after signed operations. |

&nbsp;