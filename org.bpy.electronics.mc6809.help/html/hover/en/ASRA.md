**Arithmetic Shift Right**

|     |     |
| --- | --- |
| Source Form | ASRA |
| Operation | <img src="../_resources/asr.jpg" alt="asr.jpg" width="190" height="46" class="jop-noMdConv"> |
| Condition Codes | H - Undefined,  <br>N - Set if the result is negative; cleared otherwise,  <br>Z - Set if the result is zero; cleared otherwise,  <br>V - Not affected..  <br>C - Loaded with bit zero of the original operand. |
| Description | Shifts all bits of the operand one place to the right. Bit seven is held constant. Bit zero is shifted into the C (carry) bit. |
| Addressing mode | Inherent |