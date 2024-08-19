**Form constant character string**

|     |     |
| --- | --- |
| Source Form | (&lt;label&gt;) FCC &lt;delimiter&gt;&lt;string&gt;&lt;delimiter&gt; |
| Description | The FCC directive is used to store ASCII strings into consecutive bytes of memory. The byte storage begins at the current program  <br>counter. The label is assigned to the first byte in the string. Any of the printable ASCII characters can be contained in the string. The string is specified between two identical delimiters which can be any printable ASCII character. The first non-blank character after the FCC directive is used as the delimiter. |

&nbsp;