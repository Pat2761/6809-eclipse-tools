**Complement**

|     |     |
| --- | --- |
| Source Form | COM M |
| Operation | M =  0 + !M |
| Condition Codes | H - Not affected.  <br>N - Set if the result is negative; cleared otherwise.  <br>Z - Set if the result is zero; cleared otherwise..  <br>V - Always cleared.  <br>C - Always Set. |
| Description | Replaces the contents of memory location M  with its logical complement. When operating on unsigned values, only BEQ and BNE branches can be expected to behave properly following a COM instruction. When operating on twos complement values, all signed branches are available. |
| Addressing mode | Extended  <br>Direct  <br>indexed |