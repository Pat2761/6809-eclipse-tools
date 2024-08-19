**Fill memory**

|     |     |
| --- | --- |
| Source Form | (&lt;label&gt;) FILL &lt;expression&gt;,&lt;expression&gt; |
| Description | The FILL directive causes the assembler to initialize an area of memory with a constant value. The first expression signifies the one byte value to be placed in the memory and the second expression indicates the total number of successive bytes to be initialized. The first expression must evaluate to the range 0-255. Expressions cannot contain forward references or undefined symbols. |