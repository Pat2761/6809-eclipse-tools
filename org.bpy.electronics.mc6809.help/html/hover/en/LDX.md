**Load Register from Memory**

|     |     |
| --- | --- |
| Source Form | LDX P |
| Operation | X = M:M+1 |
| Condition Codes | H - Not affected.  <br>N - Set if the loaded data is negative; cleared otherwise.  <br>Z - Set if the loaded data is zero; cleared otherwise.  <br>V - Always cleared.  <br>C  - Not affected. |
| Description | Load the contents of the memory location M:M + 1 into the designated 16-bit register. |
| Addressing mode | Immediate  <br>Extended  <br>Direct  <br>Indexed |

&nbsp;