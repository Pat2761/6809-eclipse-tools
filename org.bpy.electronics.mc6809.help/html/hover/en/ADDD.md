**Add Memory into 16 bits Register**

|     |     |
| --- | --- |
| Source Form | ADDD    P |
| Operation | R = R + M:M + 1 |
| Condition Codes | H - Set if a half-carry is generated; cleared otherwise,  <br>N - Set if the result is negative; cleared otherwise,  <br>Z - Set if the result is zero; cleared otherwise,  <br>V - Set if an overflow is generated; cleared otherwise,  <br>C - Set if a carry is generated; cleared otherwise. |
| Description | Adds the memory byte into an 16-bit accumulator. |
| Addressing mode | Immediate  <br>Extended  <br>Direct  <br>Indexed |