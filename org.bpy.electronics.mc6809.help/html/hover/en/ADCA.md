**Add A with Carry into Register**

|     |     |
| --- | --- |
| Source Form | ADCA    P |
| Operation | R = R + M + C |
| Condition Codes | H - Set if a half-carry is generated; cleared otherwise,  <br>N - Set if the result is negative; cleared otherwise,  <br>Z - Set if the result is zero; cleared otherwise,  <br>V - Set if an overflow is generated; cleared otherwise,  <br>C - Set if a carry is generated; cleared otherwise. |
| Description | Adds the contents of the C (carry) bit and the memory byte into an8-blt accumulator. |
| Addressing mode | Immediate  <br>Extended  <br>Direct  <br>Indexed |