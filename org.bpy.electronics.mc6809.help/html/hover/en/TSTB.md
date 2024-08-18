**Test**

|     |     |
| --- | --- |
| Source Form | TSTB |
| Operation | TEMP = B - 0 |
| Condition Codes | H - Not affected.  <br>N - Set if the result is negative; cleared otherwise,  <br>Z - Set if the result is zero; cleared otherwise,  <br>V - Always cleared.  <br>C - Not affected. |
| Description | Set the N (negative) and Z (zero) bits according to the contents of memory location M, and clear the V (overflow) bit. The TST instruction provides only minimum information when testing unsigned values; since no unsigned value is less than zero, BLO and BLS have no utility. While BHI could be used after TST, it provides exactly the same control as BNE, which is preferred. The signed branches are available. |
| Addressing mode | Inherent |
| Comments | The MC6800 processor clears the (carry) bit. |