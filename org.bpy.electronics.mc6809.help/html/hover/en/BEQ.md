**Branch on Equal**

|     |     |
| --- | --- |
| Source Form | BEQ dd |
| Operation | TEMP = Ml  <br>IFF Z = 1 then PC = PC + TEMP |
| Condition Codes | Not affected. |
| Description | Tests the state of the Z (zero) bit and causes a branch if it is set. When used after a subtract or compare operation, this Instruction will branch If the compared values, signed or unsigned, were exactly the same. |
| Addressing mode | Relative |