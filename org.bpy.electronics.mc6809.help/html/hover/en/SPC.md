**Define space for listing**

|     |     |
| --- | --- |
| Source Form | SPC \[&lt;space count&gt;\[,&lt;keep count&gt;\]\] |
| Description | The SPC or Space directive causes the specified number of spaces (line feeds) to be inserted into the output listing.<br><br>The space count can be any number from 0 to 255. If the page option is selected, SPC will not cause spacing past the top of a new page. The &lt;keep count&gt; is optional and is the number of lines which the user wishes to keep together on a page. If there are not enough lines left on the current page, a page eject is performed. If there are &lt;keep count&gt; lines left on the page (after printing &lt;space count&gt; spaces), output will continue on the current page. If the page option is not selected, the &lt;keep count&gt; will be ignored. If no operand is given (ie. just the directive SPC), the assembler will default to one blank line in the output listing. |