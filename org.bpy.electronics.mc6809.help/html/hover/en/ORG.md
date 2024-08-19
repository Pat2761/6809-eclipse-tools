**Set program counter origin**

|     |     |
| --- | --- |
| Source Form | ORG &lt;expression&gt; |
| Description | The ORG directive changes the program counter to the value specified by the expression in the operand field. Subsequent statements are assembled into memory locations starting with the new program counter value. If no ORG directive is encountered in a source program, the program counter is initialized to zero. |