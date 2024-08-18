**Inclusive OR Memory into Register**

|     |     |
| --- | --- |
| Source Form | ORB |
| Operation | B = B \| M |
| Condition Codes | H - Not affected.  <br>N - Set if the result is negative; cleared otherwise,  <br>Z - Set if the result is zero; cleared otherwise,  <br>V - Always cleared.  <br>C - Not affected. |
| Description | Performs an inclusive OR operation between the contents of accumulator B and the contents of memory location M and the result is stored in accumulator B . |
| Addressing mode | Immediate  <br>Extended  <br>Direct  <br>Indexed |