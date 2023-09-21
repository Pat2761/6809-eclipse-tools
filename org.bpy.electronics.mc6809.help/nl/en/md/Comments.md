
### The comments


In an assembly file, comments have no impact on the generated code. On the other hand, they are very useful for understanding the assembly code that has been written. In classic assembler, there are two common forms of comments.

*  The first form allows the different blocks of assembly instructions to be separated and describes the function of these blocks. generally, they constitute an entire line of assembly code. In this case the line must start with a ';' as in the following example


	; ---------------------------------------------------
	; this is an example
	; ---------------------------------------------------

*  The second form is a comment which is placed at the end of an instruction or directive. As in the first case, the comment begins with a ';'.


	Label      EQU     18     ; so label is equal to 18

* The last form is not strictly speaking a comment, but a way to make the assembly code more readable. This is the empty line which also allows you to separate the different parts of the assembly code.


	Label      EQU     18     

	Label2     EQU     19 
	
	