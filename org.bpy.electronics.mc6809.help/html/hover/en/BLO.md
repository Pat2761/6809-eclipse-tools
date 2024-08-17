**Branch on Lower**

|     |     |
| --- | --- |
| Source Form | BLO dd |
| Operation | TEMP = Ml  <br>IFF  C = 1  then PC = PC + TEMP |
| Condition Codes | Not affected. |
| Description | Tests the state of the C (carry) and causes a branch if kit is set .When used after a subtract or compare on unsigned binary values, this instruction will branch if the register was lower than the memory operand. |
| Addressing mode | Relative |
| Comments | This is a duplicate assembly-language mnemonic for the single machine instruction BOS. Generally not useful after INO/DEO,LD/ST, and TST/OLR/OOM instructions. |

&nbsp;