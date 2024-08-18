**Sign Extended**

|     |     |
| --- | --- |
| Source Form | SEX |
| Operation | If bit seven of ACCB is set then ACCA =FF else ACCA = OO |
| Condition Codes | H — Not affected.  <br>N — Set if the result is negative; cleared otherwise.  <br>Z — Set if the result is zero; cleared otherwise.  <br>V — Not affected.  <br>C — Not affected. |
| Description | This instruction transforms a twos complement 8-bit value in accumulator B into a twos complement 16-bit value in the D accumulator. |
| Addressing mode | Inherent |