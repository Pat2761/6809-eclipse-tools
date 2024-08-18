**Rotate left**

|     |     |
| --- | --- |
| Source Form | ROLA |
| Operation | <img src="../_resources/rol.jpg" alt="rol.jpg" width="122" height="51" class="jop-noMdConv"> |
| Condition Codes | H - Not affected.  <br>N - Set if the result is negative; cleared otherwise,  <br>Z - Set if the result is zero; cleared otherwise,  <br>V - Loaded with the result of the exclusive OR of bits six and seven of the original operand.  <br>C - Loaded with bit seven of the original operand. |
| Description | Rotates all bits of the operand one place left through the (carry) bit. This is a 9-bit rotation. |
| Addressing mode | Inherent |