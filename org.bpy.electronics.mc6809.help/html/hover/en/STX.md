**Store Register into Memory**

|     |     |
| --- | --- |
| Source Form | STX P |
| Operation | M:M + 1 = X |
| Condition Codes | H - Not affected.  <br>N - Set if the loaded data is negative; cleared otherwise.  <br>Z - Set if the loaded data is zero; cleared otherwise.  <br>V - Always cleared.  <br>C  - Not affected. |
| Description | Writes the contents of a 16-bit register into two consecutive memory locations. |
| Addressing mode | Extended  <br>Direct  <br>Indexed |

&nbsp;