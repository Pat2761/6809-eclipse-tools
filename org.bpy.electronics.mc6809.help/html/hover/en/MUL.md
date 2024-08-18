**Multiply**

|     |     |
| --- | --- |
| Source Form | MUL |
| Operation | ACCA:ACCB = ACCA x ACCB |
| Condition Codes | H - Not affected.  <br>N - Not affected.,  <br>Z - Set if the result is zero; cleared otherwise,  <br>V - Not affected..  <br>C - Set if ACCB bit 7 of result is set; cleared otherwise.. |
| Description | Multiply the unsigned binary numbers in the accumulators and place the result In both accumulators (ACCA contains the most significant byte of the result). Unsigned multiply allows multiple precision operations. |
| Addressing mode | Inherent |
| Comments | The C (carry) bit allows rounding the most-significant byte through the sequence: MUL, ADCA #0. |