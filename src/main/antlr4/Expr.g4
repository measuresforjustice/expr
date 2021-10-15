grammar Expr;

@header {
package io.mfj.expr.antlr4;
}

root : expression EOF;

expression: term ( CONJUNCTION expression )?;

term : statement | parens | not;

parens: '(' expression ')';

not : notStart expression ')';
notStart : NOTP | notSpaceP;
NOTP : [nN][oO][tT]'(';
notSpaceP : NOT '(';
NOT: [nN][oO][tT];

statement : value OPERATOR value ( OPERATOR value )?;

value : value MATH_OP value | varName | literalValue | list;

CONJUNCTION: AND | OR;
fragment AND : [aA][nN][dD];
fragment OR : [oO][rR];

OPERATOR : '!=' | '<>' | '>=' | '<=' | '>' | '<' | '=~' | '=' | IN | CONTAINS ;

fragment IN : '!'?[iI][nN];
fragment CONTAINS: '!'?[cC][oO][nN][tT][aA][iI][nN][sS];

literalValue : nul | number | string | bool | regex | date | time | datetime;

nul: 'null';

string : DQUOTED;
DQUOTED: '"' (DQUOTED_ESC|.)*? '"';
fragment DQUOTED_ESC : '\\"' | '\\\\';

regex : SLASHED;
SLASHED: '/' (SLASHED_ESC|.)*? '/';
fragment SLASHED_ESC: '\\/' | '\\\\';

number: INT | DECIMAL;
INT : '-'? DIGIT+;
DECIMAL : '-'? DIGIT* '.' DIGIT*;
DIGIT: [0-9];

bool : TRUE | FALSE;
TRUE: 'true';
FALSE: 'false';

date: DATEQUOTED;
DATEQUOTED: 'd' SQUOTED;
time: TIMEQUOTED;
TIMEQUOTED: 't' SQUOTED;
datetime: DATETIMEQUOTED;
DATETIMEQUOTED: 'dt' SQUOTED;
fragment SQUOTED: '\'' (SQUOTED_ESC|.)*? '\'';
fragment SQUOTED_ESC : '\\\'' | '\\\\';

varName: VAR_NAME;
VAR_NAME: [a-zA-Z_][a-zA-Z0-9_]*;

list : '[' ( value ( ',' value )+ ','? )? ']';

MATH_OP : '+' | '-';

WS : [ \t\r\n]+ -> skip ;