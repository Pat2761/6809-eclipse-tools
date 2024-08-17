**Arithmetic Shift Left**

|     |     |
| --- | --- |
| Source Form | ASLA |
| Operation | <img src="../_resources/asl.jpg" alt="asl.jpg" width="203" height="40" class="jop-noMdConv"> |
| Condition Codes | H - Undefined,  <br>N - Set if the result is negative; cleared otherwise,  <br>Z - Set if the result is zero; cleared otherwise,  <br>V - Loaded with the result of the exclusive OR of bits six and seven of the original operand.  <br>C - Not affected. |
| Description | Shifts all bits of the operand one place to the left. Bit zero is loaded with a zero. Bit seven is shifted into the C (carry) bit. |
| Addressing mode | Inherent |