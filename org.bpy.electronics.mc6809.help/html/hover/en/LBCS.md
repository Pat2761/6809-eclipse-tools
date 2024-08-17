**Branch on Carry Set**

|     |     |
| --- | --- |
| Source Form | LBCS dddd |
| Operation | TEMP = Ml  <br>IFF C = 1 then PC = PC + TEMP |
| Condition Codes | Not affected. |
| Description | Tests the state of the C (carry) bit and causes a branch If it Is set. |
| Addressing mode | Relative |
| Comment | Equivalent to LBLO dddd |