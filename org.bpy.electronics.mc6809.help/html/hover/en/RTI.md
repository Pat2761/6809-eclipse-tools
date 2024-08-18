**Return from Interrupt**

|     |     |
| --- | --- |
| Source Form | RTI |
| Operation | OCR = (SP), SP = SP + 1, then  <br>IFF COR bit E is set, then: ACCA = (SP), SP = P + 1  <br>                                           ACCB = (SP), SP'-SP + 1  <br>                                           DPR = (SP), SP = SP + 1  <br>                                           IXH = (SP), SP = SP + 1  <br>                                           IXL = (SP), SP = SP + 1  <br>                                           lYH = (SP), SP = SP + 1  <br>                                           lYL = (SP), SP = SP + 1  <br>                                           USH = (SP), SP = SP + 1  <br>                                           USL = (SP), SP = SP + 1  <br>                                           PCH = (SP), SP = SP + 1  <br>                                           POL = (SP), SP = SP + 1  <br>IFF CCR bit E is clear, then:PCH = (SP), SP = SP + 1  <br>                                             PCL = (SP), SP = SP + 1 |
| Condition Codes | Recovered from the stack. |
| Description | The saved machine state is recovered from the hardware stack and control is returned to the Interrupted program. If the recovered E (entire) bit is clear, it indicates that only a subset of the machine state was saved (return address and condition codes) and only that subset is recovered. |
| Addressing mode | Inherent |