**Block storage of zeros**

|     |     |
| --- | --- |
| Source Form | BSZ &lt;expression&gt; |
| Description | The BSZ directive causes the Assembler to allocate a block of bytes. Each byte is assigned the initial value of zero. The number of bytes allocated is given by the expression in the operand field. If the expression contains symbols that are either undefined or forward referenced (i.e. the definition occurs later on in the file), or if the expression has a value of zero, an error will be generated. |