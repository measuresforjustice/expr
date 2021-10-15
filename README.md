# Expr

Expr is a handy expression parser.

_Expr_ is released under the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0).

_Expr_ is deployed to [Maven Central](https://repo1.maven.org/maven2/io/mfj/expr/) with GAV `io.mfj:expr`.

## The grammar:

```
* Expression :      Term ( Conjunction Term )*
* Term :            Statement | Not | Parens
* Parens :          '(' Expression ')'
* Not :             'not' Whitespace* '(' Expression ')'
* Statement :       Value Operator Value ( Operator Value )?
* Value :           MathStatement | VariableName | LiteralValue | List
* MathStatement :   Value MathOperator Value
* Conjunction :     Whitespace+ ( 'and' | 'or' ) Whitespace+
* Operator :        '!=' | '<>' | '>=' | '<=' | '>' | '<' | '=~' | '=' | 'in' | '!in' | 'contains' | '!contains'
* MathOperator :    '+' | '-'
* Whitespace :      ' ' | '\t' | '\n'
* LiteralValue :    Null | Integer | Decimal | String | Regex | Boolean | Date | Time | DateTime
* Null :            'null'
* String :          '"' TextOrEmpty{" escaped by \} '"'
* Regex :           '/' TextOrEmpty{/ escaped by \} '/'
* Number :          '-'? Digit+ ( '.' Digit+ )?
* Boolean :         'true' | 'false'
* Date :            "d'" ISO_8601_Date "'"
* Time :            "t'" ISO_8601_Time "'"
* DateTime :        "dt'" ISO_8601_DateTime "'"
* VariableName :    /[a-zA-Z_][a-zA-Z0-9_]*/
* List:             '[' ( Value ( ',' Value )* ','? )? ']'
```

[ANTLR4 Grammar](src/main/antlr4/Expr.g4)

### What is up with the optional part of Statement?

`1 < myVar <= 6` is valid. It means `1 < myVar and myVar <= 6`.

It is awesome.

## Variable types

* String - `kotlin.String`
* Regex - `kotlin.text.Regex`
* Number - `java.math.BigDecimal`
* Date - `java.time.LocalDate`
* Time - `java.time.LocalTime`
* DateTime - `java.time.LocalDateTime`
* Boolean - `kotlin.Boolean`
* List - `java.util.List`

## Versioning

_Expr_'s version is of the format `major.minor.build`.

The major number is incremented for breaking changes or major new features.

The minor number is incremented for minor new features.

The build number is generated by [Measures for Justice](https://measuresforjustice.org)'s private CI tool.
It is incremented for each build, regardless of the major and minor numbers
(it does not reset to zero when minor or major numbers are increased).
