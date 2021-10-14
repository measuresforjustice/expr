grammar Expr;

expression: term ( CONJUNCTION expression )?;

term : statement | not | parens | bool;

parens: '(' expression ')';

not : NOT_START expression ')';
NOT_START : NOT_P | NOT_SPACE_P;
NOT_P : NOT'(';
NOT_SPACE_P : NOT '(';
NOT: [nN][oO][tT];

statement : value OPERATOR value /*( operator value )?*/;

value : varName | literalValue /*| list*/;

CONJUNCTION: AND | OR;
fragment AND : [aA][nN][dD];
fragment OR : [oO][rR];

OPERATOR : '!=' | '<>' | '>=' | '<=' | '>' | '<' | '=~' | '=' /*| 'in' | '!in' | 'contains' | '!contains'*/;

literalValue : nul | number | string | bool | regex | date | time | datetime;

nul: 'null';

string : '"' (ESC|.)*? '"';
fragment ESC : '\\"' | '\\\\';

regex : '/' (RESC|.)*? '/';
fragment RESC : '\\/' | '\\\\';

number: INT | DECIMAL;
INT : '-'? DIGIT+;
DECIMAL : '-'? DIGIT* '.' DIGIT*;
DIGIT: [0-9];

bool : TRUE | FALSE;
TRUE: 'true';
FALSE: 'false';

date : 'd\'' (SQESC|.)*? '\'';
time : 't\'' (SQESC|.)*? '\'';
datetime: 'dt\'' (SQESC|.)*? '\'';
fragment SQESC : '\\\'' | '\\\\';

varName: VAR_NAME;
VAR_NAME: [a-zA-Z_][a-zA-Z0-9_]*;

WS : [ \t\r\n]+ -> skip ;