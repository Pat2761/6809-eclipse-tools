**Inclusive OR Memory Immediate Into Condition Code Register**

|     |     |
| --- | --- |
| Source Form | ORCC   #xx |
| Operation | CC = CC \| M |
| Condition Codes | Affected according to the operation. |
| Description | Performs an inclusive OR operation between the contents of the condition code registers and the immediate value, and the result is piaced in the condition code register. This instruction may be used to set interrupt maslcs (disable interrupts) or any other bit(s). |
| Addressing mode | Immediate |