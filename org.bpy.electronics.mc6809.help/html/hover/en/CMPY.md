**Compare Memory from Register**

|     |     |
| --- | --- |
| Source Form | CMPY P |
| Operation | TEMP = Y - M |
| Condition Codes | H - Undefined,  <br>N - Set if the result is negative; cleared otherwise,  <br>Z - Set if the result is zero; cleared otherwise,  <br>V - Set if an overflow is generated; cleared otherwise.  <br>C - Set if a borrow is generated; cleared otherwise. |
| Description | Compares the contents of memory location to the contents of the specified register and sets the appropriate condition codes. Neither memory location M nor the specified register is modified. The carry flag represents a borrow and is set to the inverse of the resulting binary carry. |
| Addressing mode | Extended  <br>Direct  <br>Indexed |