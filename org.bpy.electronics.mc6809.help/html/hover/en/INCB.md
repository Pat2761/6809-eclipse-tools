**Incement**

|     |     |
| --- | --- |
| Source Form | INCB |
| Operation | B =  B + 1 |
| Condition Codes | H - Not affected.  <br>N - Set if the result is negative; cleared otherwise.  <br>Z - Set if the result is zero; cleared otherwise..  <br>V - Set if the original operand was 01111111; cleared otherwise.  <br>C - Not affected.. |
| Description | Adds to the operand. The carry bit is not affected, thus allowing this instruction to be used as a loop counter in multiple-precision computations. When operating on unsigned values, only the BEQ and BNE branches can be expected to behave consistently. When operating on twos complement values, all signed branches are correctly available. |
| Addressing mode | Inherent |