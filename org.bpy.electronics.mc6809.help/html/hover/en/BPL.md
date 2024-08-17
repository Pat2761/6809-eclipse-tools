**Branch on Plus**

|     |     |
| --- | --- |
| Source Form | BPL dd |
| Operation | TEMP = Ml  <br>IFF  N = 0  then PC = PC + TEMP |
| Condition Codes | Not affected. |
| Description | Tests the state of the N (negative) bit and causes a branch if it is clear. That is, branch if the sign of the twos complement result ispositive. |
| Addressing mode | Relative |
| Comments | When used after an operation on signed binary values, this instruction will branch if the result (possibly invalid) is positive. It is generally preferred to use the BGE instruction after signed operations. |

&nbsp;