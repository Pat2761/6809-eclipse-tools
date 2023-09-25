
#### Immediate mode

The operand is contained in one or two bytes immediately following the opcode. This addressing mode is used to provide constant data values that do not change during program execution. Both 8- bit and 16-bit operands are used depending on the size of the argument specified in the opcode.

The immediate mode is identified by the # code at the beginning of the operand

Example: 


				LDA 		#CR
				LDB			#7
				LDA 		#$F0
				LDB			#%1110000
				LDX 		#$8004
