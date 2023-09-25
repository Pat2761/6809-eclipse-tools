
#### Extended mode

The effective address of the argument is contained in the two bytes following the opcode. Instructions using the extended addressing mode can reference arguments anywhere in the 64K addressing space. Extended addressing is generally not used In position independent programs because it supplies an absolute address.

The immediate mode is identified by the > code at the beginning of the operand

Example: 

					LDA >CAT
					LDA >$FFFF

