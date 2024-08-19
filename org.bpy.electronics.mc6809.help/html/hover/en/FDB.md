**Form double byte constant**

|     |     |
| --- | --- |
| Source Form | (&lt;label&gt;) FDB &lt;expr&gt;(,&lt;expr&gt;,...,&lt;expr&gt;) |
| Description | The FDB directive may have one or more operands separated by commas. The 16-bit value corresponding to each operand is stored into two consecutive bytes of the object program. The storage begins at the current program counter. The label is assigned to the first 16-bit value. Multiple operands are stored in successive bytes. The operand may be a numeric constant, a character constant, a symbol, or an expression. If multiple operands are present, one or more of them can be null (two adjacent commas), in which case two bytes of zeros will be assigned for that operand. |