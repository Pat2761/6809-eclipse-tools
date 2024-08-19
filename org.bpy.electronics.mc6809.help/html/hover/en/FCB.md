**Form constant byte**

|     |     |
| --- | --- |
| Source Form | (&lt;label&gt;) FCB &lt;expr&gt;(,&lt;expr&gt;,...,&lt;expr&gt;) |
| Description | The FCB directive may have one or more operands separated by commas. The value of each operand is truncated to eight bits, and is stored in a single byte of the object program. Multiple operands are stored in successive bytes. The operand may be a numeric constant, a character constant, a symbol, or an expression. If multiple operands are present, one or more of them can be null (two adjacent commas), in which case a single byte of zero will be assigned for that operand. |

&nbsp;