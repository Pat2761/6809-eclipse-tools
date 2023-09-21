
#### EQU Directive

The EQU directive is the equivalent of #define in C language. It allows you to define a predefined value for a label which will be used in the assembly code. It thus allows a value to be defined only once which can be used several times elsewhere. This avoids code errors by modifying this value wherever it is used.

Here is an example of using the EQU directive


	Mylabel      EQU    18

In this case, each time we refer to myLabel, the assembler will replace it with the value 18.


