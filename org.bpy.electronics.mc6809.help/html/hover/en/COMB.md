**Complement**

|     |     |
| --- | --- |
| Source Form | COMB |
| Operation | B> =  0 + !B |
| Condition Codes | H - Not affected.  <br>N - Set if the result is negative; cleared otherwise.  <br>Z - Set if the result is zero; cleared otherwise..  <br>V - Always cleared.  <br>C - Always Set. |
| Description | Replaces the accumulator B with its logical complement. When operating on unsigned values, only BEQ and BNE branches can be expected to behave properly following a COM instruction. When operating on twos complementvalues, all signed branches are available. |
| Addressing mode | Inherent |