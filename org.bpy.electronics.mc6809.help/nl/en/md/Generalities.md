
###  Generalities

Assembler syntax is relatively simple. Each instruction is based on a single line which can be broken down into three main elements and can end with a comment.
for example, a line is defined like this


	Label      Instruction      Operand      ; a comment

The label must start at the start of the line and there must not be a space before this element. the label must begin with a capital letter then followed by letters, numbers or the character _

There are two categories of instructions. 

1.  The first is the 6809 assembler instruction. It is common to all 6809 assemblers since it is linked to this microprocessor.
2.   The second is the directive which allows you to influence the behavior of the assembler. These directives are specific to each assembler although some are common to all assemblers

The operand is used to describe the data on which the instruction or directive is carried out. The operand can be made up of numbers, variable names, labels or arithmetic or logical expressions.

And finally, a comment can be added at the end of the line to give information on this line.


