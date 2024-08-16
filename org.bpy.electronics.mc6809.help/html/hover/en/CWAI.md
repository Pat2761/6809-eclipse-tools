# CWAI
**Clear CC bits and Wait for Interrupt**

|     |     |
| --- | --- |
| Source Form | CWAI #$XX           <img src="../../utils/StatusRegister.jpg" alt="StatusRegister.jpg" width="221" height="31"> |
| Operation | CCR'^CCR & Ml (Possibly clear masks)  <br>Set E (entire state saved)  <br>SP = SP-1, (SP) <- PCL  <br>SP = SP-1, (SP) <- PCH  <br>SP = SP-1, (SP) <- USL  <br>SP = SP-1, (SP) <- USH  <br>SP = SP-1, (SP) <- IYL  <br>SP = SP-1, (SP) <- lYH  <br>SP = SP-1, (SP) <- IXL  <br>SP = SP-1, (SP) <- IXH  <br>SP = SP-1, (SP) <- DPR  <br>SP = SP-1, (SP) <- ACCB  <br>SP = SP-1, (SP) <- ACCA  <br>SP = SP-1, (SP) <- CCR |
| Condition Codes | Affected according to the operation. |
| Description | This instruction ANDs an immediate byte with the condition code register which may clear the interrupt mask bits I and F, stacks the entire machine state on the hardware stack and then looks for an interrupt. When a non-masked interrupt occurs, no further machine state information need be saved before vectoring to the interrupt handling routine. This instruction replaced the MC6800 CLI WAI sequence, but does not place the buses in a high-impedance state. A FIRQ (fast interrupt request) may enter its interrupt handler with its entire machine state saved. The RTI (return from interrupt) instruction will automatically return the entire machine state after testing the E (entire) bit of the recovered condition code register. |
| Addressing mode | Immediate |
| Comment | The following immediate values will have the following results:  <br>  FF = enable neither  <br>  EF = enable IRQ  <br>  BF = enable FIRQ  <br>  AF = enable both |

&nbsp;