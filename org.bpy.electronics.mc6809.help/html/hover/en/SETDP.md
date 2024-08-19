**Define DP register**

|     |     |
| --- | --- |
| Source Form | SETDP \[&lt;page value&gt;\] |
| Description | The SETDP or Set Direct Page directive allows the user to set which memory page the assembler will use for the direct page addressing mode.<br><br>As an example, if "SETDP $D0" is encountered, the assembler will then use direct addressing for any address in the range of $D000 to $D0FF. It is important to note that this directive does not actually affect the contents of the direct page register. The value set is what will be used at assembly time to determine direct addressing, but it is up to the user to be sure the DP register corresponds at run time. If there is no &lt;page value&gt; supplied, direct addressing will be disabled and all addresses will be full 16 bit values. Any number of SETDP instructions may occur in a program. The default value is page 0 (for 6800 compatibility). |