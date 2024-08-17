**Branch on Carry Clear**

|     |     |
| --- | --- |
| Source Form | LBCC dddd |
| Operation | TEMP = Ml  <br>IFF C = 0 then PC = PC + TEMP |
| Condition Codes | Not affected. |
| Description | Tests the state of the C (carry) bit and causes a branch If it Is clear. |
| Addressing mode | Relative |
| Comment | Equivalent to LBHS dddd |