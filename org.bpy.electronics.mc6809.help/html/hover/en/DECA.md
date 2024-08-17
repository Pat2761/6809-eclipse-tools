**Drecement**

|     |     |
| --- | --- |
| Source Form | DECA |
| Operation | A =  A - 1 |
| Condition Codes | H - Not affected.  <br>N - Set if the result is negative; cleared otherwise.  <br>Z - Set if the result is zero; cleared otherwise..  <br>V - Set if the original operand was 10000000; cleared otherwise.  <br>C - Not affected.. |
| Description | Subtract one from the operand. The carry bit is not affected, thus allowing this instruction to be used as a loop counter in multiple precision computations. When operating on unsigned values, only BEQ and BNE branches can be expected to behave consistently. When operating on twos complement values, all signed branches are available. |
| Addressing mode | Extended  <br>Direct  <br>indexed |