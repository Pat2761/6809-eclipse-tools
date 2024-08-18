**Subtract with Borrow**

|     |     |
| --- | --- |
| Source Form | SBCB |
| Operation | B = B-M-C |
| Condition Codes | H - Undefined.  <br>N - Set if the result is negative; cleared otherwise,  <br>Z - Set if the result is zero; cleared otherwise,  <br>V - Set if an overflow is generated; cleared otherwise.  <br>C - Set if a borrow is generated; cleared otherwise. |
| Description | Subtracts the contents of memory location M and the borrow (in the C (carry) bit) from the contents of the designated 8-bit register, and places the result in that register. The C bit represents a borrow and is set to the inverse of the resulting binary carry. |
| Addressing mode | Immediate  <br>Extended  <br>Direct  <br>Indexed |