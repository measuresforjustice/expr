grammar Expr;

expression: term ( CONJUNCTION expression )?;

term : statement | not | parens | bool;

parens: '(' expression ')';

not: 'not(' expression ')';

statement : value OPERATOR value /*( operator value )?*/;

value : varName | literalValue /*| list*/;

CONJUNCTION: 'and' | 'or';

OPERATOR : '!=' | '<>' | '>=' | '<=' | '>' | '<' | '=~' | '=' /*| 'in' | '!in' | 'contains' | '!contains'*/;

literalValue : nul | number | string | bool | regex /*| DATE | TIME | DATE_TIME*/;

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

varName: VAR_NAME;
VAR_NAME: [a-zA-Z_][a-zA-Z0-9_]*;

WS : [ \t\r\n]+ -> skip ;