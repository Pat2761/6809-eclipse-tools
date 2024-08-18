**Negate**

|     |     |
| --- | --- |
| Source Form | NEG m |
| Operation | M = 0 - M |
| Condition Codes | H - Undefined,  <br>N - Set if the result is negative; cleared otherwise,  <br>Z - Set if the result is zero; cleared otherwise,  <br>V - Set if the original operand was 10000000.  <br>C - Set if a borrow is generated; cleared otherwise. |
| Description | Replaces the operand with its twos complement. The (carry) bitrepresents a borrow and is set to the inverse of the resulting binary carry. Note that 80i6 is replaced by itself and only in this case is the V (overflow) bit set. The value OOie is also replaced by itself, and only in this case is the C (carry) bit cleared. |
| Addressing mode | Extended  <br>Direct  <br>Indexed |