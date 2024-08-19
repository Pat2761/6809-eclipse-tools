**Set symbol to a value**

|     |     |
| --- | --- |
| Source Form | &lt;label&gt; SET &lt;expression&gt; |
| Description | The SET directive is used to set a symbol to the value of some expression, much as an EQU directive. The difference is that a symbol may be SET several times within the source (to different values) while a symbol may be Equated only once. If a symbol is SET to several values within the source, the current value of the symbol will be the value last SET. |