**Reserve memory bytes**

|     |     |
| --- | --- |
| Source Form | (&lt;label&gt;) RMB &lt;expression&gt; |
| Description | The RMB directive causes the location counter to be advanced by the value of the expression in the operand field. This directive reserves a block of memory the length of which in bytes is equal to the value of the expression. The block of memory reserved is not initialized to any given value. The expression cannot contain any forward references or undefined symbols. This directive is commonly used to reserve a scratchpad or table area for later use. |