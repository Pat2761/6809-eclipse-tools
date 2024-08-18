**Subtract Memory from Register**

|     |     |
| --- | --- |
| Source Form | SUBD |
| Operation | D = D-M:M+1 |
| Condition Codes | H - Undefined.  <br>N - Set if the result is negative; cleared otherwise,  <br>Z - Set if the result is zero; cleared otherwise,  <br>V - Set if an overflow is generated; cleared otherwise.  <br>C - Set if a borrow is generated; cleared otherwise. |
| Description | Subtracts the value in memory location M:M + 1 from the contents of a designated 16-bit register. The C (carry) bit represents a borrow and is set to the inverse of the resulting binary carry. |
| Addressing mode | Immediate  <br>Extended  <br>Direct  <br>Indexed |