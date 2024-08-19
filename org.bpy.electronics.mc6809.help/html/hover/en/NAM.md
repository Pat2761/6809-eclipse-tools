**Name of the program**

|     |     |
| --- | --- |
| Source Form | TTL &lt;text for the title&gt;  <br>NAM &lt;text for the title&gt; |
| Description | The TTL or NAM directive allows the user to specify a title or name to the program being assembled. This title is then printed in the header at the top of each output listing page if the page option is selected. If the page option is not selected, this directive is ignored.<br><br>All the text following the TTL or NAM directive (excluding leading spaces) is placed in the title buffer. Up to 32 characters are allowed with any excess being ignored. It is possible to have any number of TTL or NAM directives in a source program. The latest one encountered will always be the one used for printing at the top of the following page(s). |