**Bit test**

|     |     |
| --- | --- |
| Source Form | BITB P |
| Operation | TEMP = B & M |
| Condition Codes | H - Not affected.  <br>N - Set if the result is negative; cleared otherwise.  <br>Z - Set if the result is zero; cleared otherwise.  <br>V - Always cleared.  <br>C - Not affected. |
| Description | Performs the logical AND of the contents of accumulator B and the contents of memory location M and modifies the condition codes accordingly. The contents of accumulator B and memory location M are not affected. |
| Addressing mode | Immediate  <br>Extended  <br>Direct  <br>Indexed |