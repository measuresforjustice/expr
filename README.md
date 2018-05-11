# Expr

A parser of expressions.

_Expr_ is released under the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0).

## The grammar:

```
* Expression :      Term ( Conjunction Term )*
* Term :            Statement | Not | Parens
* Parens :          '(' Expression ')'
* Not :             'not' Whitespace* '(' Expression ')'
* Statement :       Value Operator Value ( Operator Value )?
* Value :           VariableName | LiteralValue
* Conjunction :     Whitespace+ ( 'and' | 'or' ) Whitespace+
* Operator :        '!=' | '<>' | '>=' | '<=' | '>' | '<' | '=~' | '='
* Whitespace :      ' ' | '\t' | '\n'
* LiteralValue :    Integer | Decimal | String | Regex | Boolean | Date | Time | DateTime
* String :          '"' TextOrEmpty{" escaped by \} '"'
* Regex :           '/' TextOrEmpty{/ escaped by \} '/'
* Decimal :         '-'? Digit+ ( '.' Digit+ )?
* Integer :         '-'? Digit+
* Boolean :         'true' | 'false'
* Date :            "d'" ISO_8601_Date "'"
* Time :            "t'" ISO_8601_Time "'"
* DateTime :        "dt'" ISO_8601_DateTime "'"
* VariableName :    /[a-zA-Z_][a-zA-Z0-9_]+/
```

### What is up with the optional part of Statement?

`1 < myVar <= 6` is valid. It means `1 < myVar and myVar <= 6`.

It is awesome.

## Variable types

* STRING - `kotlin.String`
* Regex - `kotlin.text.Regex`
* Integer - `kotlin.Int`
* Double - `kotlin.Double`
* Date - `java.time.LocalDate`
* Time - `java.time.LocalTime`
* DateTime - `java.time.LocalDateTime`
* Boolean - `kotlin.Boolean`
