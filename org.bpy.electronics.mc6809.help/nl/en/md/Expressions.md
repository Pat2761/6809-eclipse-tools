
### Expressions

Expressions may consist of symbols, constants or the character '*' (denoting the current value of the program counter) joined together by one of the operators: +-*/%&|^. The operators are the same as in C. The entire expression is treated as one Operand field so no white space is permitted in the expression.

Expression Operators

1. + add
2. - subtract
3. * multiply
4. / divide
5. % remainder after division
6. & bitwise and
7. | bitwise or
8. ^ bitwise exclusive-or

Expression may used parenthesis for specify the priority of the operation like this

	Const     EQU     2
	Label     EQU     (10+Const)/2


