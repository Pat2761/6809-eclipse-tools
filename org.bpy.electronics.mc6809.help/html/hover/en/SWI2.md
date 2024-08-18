**Software Interrupt 2**

|     |     |
| --- | --- |
| Source Form | SWI2 |
| Operation | Set E (entire state will be saved)  <br>SP = SP - 1, (SP) = PCL  <br>SP = SP - 1, (SP) = PCH  <br>SP = SP - 1, (SP) = USL  <br>SP = SP - 1, (SP) = USH  <br>SP = SP - 1, (SP) = lYL  <br>SP = SP - 1, (SP) = lYH  <br>SP = SP - 1, (SP) = IXL  <br>SP = SP - 1, (SP) = IXH  <br>SP = SP - 1, (SP) = DPR  <br>SP = SP - 1, (SP) = ACCB  <br>SP = SP - 1, (SP) = ACCA  <br>SP = SP - 1, (SP) = CCR  <br>Set I, F (mask interrupts)  <br>PC = (FFF4):(FFF5) |
| Condition Codes | Not affected. |
| Description | All of the processor registers are pushed onto the hardware stack(with the exception of the hardware stack pointer itself), and control is transferred through the software interrupt 2 vector. This interrupt is available to the end user and must not be used in packaged software. This interrupt does not mask (disable) the norma! and fast interrupts. |
| Addressing mode | Inherent |