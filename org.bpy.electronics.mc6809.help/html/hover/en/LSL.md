Logical Shift Left

|     |     |
| --- | --- |
| Source Form | LSL M |
| Operation | <img src="../_resources/asl.jpg" alt="asl.jpg" width="203" height="40" class="jop-noMdConv"> |
| Condition Codes | H - Undefined,  <br>N - Set if the result is negative; cleared otherwise,  <br>Z - Set if the result is zero; cleared otherwise,  <br>V - Loaded with the result of the exclusive OR of bits six and seven of the original operand.  <br>C - Loaded with bit seven of the original operand. |
| Description | Shifts all bits of memory location M one place to the left. Bit zero is loaded with a zero. Bit seven of memory location M is shifted into the (carry) bit. |
| Addressing mode | Extended  <br>Direct  <br>Indexed |
| Comments | This is a duplicate assembly-language mnemonic for the single machine instruction ASL. |