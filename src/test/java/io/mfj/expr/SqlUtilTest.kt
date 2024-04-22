package io.mfj.expr

import org.junit.Assert.assertEquals
import org.junit.Test

class SqlUtilTest {
  private val model = mapOf(
      "aString" to ExDataType.STRING,
      "aNumber" to ExDataType.NUMBER,
      "aDate" to ExDataType.DATE,
      "aTime" to ExDataType.TIME,
      "aDateTime" to ExDataType.DATETIME,
      "aBoolean" to ExDataType.BOOLEAN,
  )

  fun test(exprStr: String,
           model: Map<String,ExDataType>,
           expected: String
  ) {
    val expr = ExprParser.parseToExpr(exprStr, MapVarTypeProvider(model))
    val sql = SqlUtil.toSqlExpression(expr)
    assertEquals(expected, sql)
  }

  // ----- basic value equality -----

  @Test
  fun testStringMatch() = test(
    """aString="abc"""",
    model,
    "aString = 'abc'"
  )

  @Test
  fun testNumberMatch() = test(
    "aNumber = 1",
    model,
    "aNumber = 1"
  )

  @Test
  fun testBooleanMatch() = test(
    "aBoolean = true",
    model,
    "aBoolean = TRUE"
  )

  @Test
  fun testDateMatch() = test(
    "aDate = d'2020-02-25'",
    model,
    "aDate = '2020-02-25'"
  )

  @Test
  fun testTimeMatch() = test(
    "aTime = t'20:22:33'",
    model,
    "aTime = '20:22:33'"
  )

  @Test
  fun testDateTimeMatch() = test(
    "aDateTime = dt'2024-04-14T14:04:44'",
    model,
    "aDateTime = '2024-04-14 14:04:44'"
  )

  // ----- advanced value matching -----

  @Test
  fun testRegexMatchWithRegexLiteral() = test(
    "aString =~ /a.b/",
    model,
    "aString ~ 'a.b'"
  )

  @Test
  fun testRegexMatchWithStringLiteral() = test(
    "aString =~ \"a.b\"",
    model,
    "aString ~ 'a.b'"
  )

  @Test
  fun testIn() = test(
    "aNumber in [1, 2, 3, 5, 8, 13]",
    model,
    "aNumber IN (1, 2, 3, 5, 8, 13)"
  )

  @Test
  fun testNotIn() = test(
    "aNumber !in [1, 2, 3, 5, 8, 13]",
    model,
    "aNumber NOT IN (1, 2, 3, 5, 8, 13)"
  )

  @Test
  fun testContains() = test(
    "[1, 2] contains aNumber",
    model,
    "aNumber IN (1, 2)"
  )

  @Test
  fun testNotContains() = test(
    "[1, 2] !contains aNumber",
    model,
    "aNumber NOT IN (1, 2)"
  )

  // ----- other comparison operators -----

  @Test
  fun testNotEquals() = test(
    "aNumber != 0",
    model,
    "aNumber <> 0"
  )

  @Test
  fun testLessThan() = test(
    "aDate < d'2020-02-25'",
    model,
    "aDate < '2020-02-25'"
  )

  @Test
  fun testGreaterThan() = test(
    "aTime > t'04:44:14'",
    model,
    "aTime > '04:44:14'"
  )

  @Test
  fun testLessThanOrEqual() = test(
    "aNumber <= 3",
    model,
    "aNumber <= 3"
  )

  @Test
  fun testGreaterThanOrEqual() = test(
    "aNumber >= 3",
    model,
    "aNumber >= 3"
  )

  @Test
  fun testBetween() = test(
    "1 < aNumber <= 6",
    model,
    "(1 < aNumber AND aNumber <= 6)"
  )

  // ----- conjunctions -----

  @Test
  fun testAnd() = test(
    "aString = \"foo\" and aNumber = 2" ,
    model,
    "(aString = 'foo' AND aNumber = 2)"
  )

  @Test
  fun testOr() = test(
    "aNumber = 1 or aNumber = 2" ,
    model,
    "(aNumber = 1 OR aNumber = 2)"
  )

  @Test
  fun testMultiConjunction() = test(
    "aNumber = 1 or aNumber = 2 and aString = \"foo\"",
    model,
    "(aNumber = 1 OR (aNumber = 2 AND aString = 'foo'))"
  )

  @Test
  fun testMultiConjunctionCustomPrecedence() = test(
    "( aNumber = 1 or aNumber = 2 ) and aString = \"foo\"",
    model,
    "((aNumber = 1 OR aNumber = 2) AND aString = 'foo')"
  )

  // ----- negated statements -----

  @Test
  fun testNegatedLogic() = test(
    "not (aString > \"a\")",
    model,
    "NOT (aString > 'a')"
  )

  @Test
  fun testNegatedConjunction() = test(
    "not(aNumber = 1 or aNumber = 2)",
    model,
    "NOT (aNumber = 1 OR aNumber = 2)"
  )

  @Test
  fun testNegatedNotLogic() = test(
    "not (aString !in [\"foo\", \"bar\"])",
    model,
    "NOT (aString NOT IN ('foo', 'bar'))"
  )

  @Test
  fun testDoubleNegation() = test(
    "not (NOT (aNumber < 10))",
    model,
    "NOT (NOT (aNumber < 10))"
  )

  // ----- math statements -----

  @Test
  fun testAddStatement() = test(
    "aNumber+3=anotherNumber",
    model.plus(mapOf("anotherNumber" to ExDataType.NUMBER)),
    "aNumber + 3 = anotherNumber"
  )

  @Test
  fun testSubtractStatement() = test(
    "5 - aNumber>=anotherNumber",
    model.plus(mapOf("anotherNumber" to ExDataType.NUMBER)),
    "5 - aNumber >= anotherNumber"
  )

  // ----- nulls -----

  @Test
  fun testStringEqualsNull() = test(
    "aString = null",
    model,
    "aString IS NULL"
  )

  @Test
  fun testNullEqualsString() = test(
    "null = aString",
    model,
    "aString IS NULL"
  )

  @Test
  fun testStringNotEqualsNull() = test(
    "aString != null",
    model,
    "aString IS NOT NULL"
  )

  @Test
  fun testNullNotEqualsString() = test(
    "null != aString",
    model,
    "aString IS NOT NULL"
  )

  @Test
  fun testDateEqualsNull() = test(
    "aDate = null",
    model,
    "aDate IS NULL"
  )

  // ----- operand type validity checks -----

  @Test(expected=IllegalArgumentException::class)
  fun testRegexAgainstDate() = test(
    "aDate =~ /a.b/",
    model,
    "aDate ~ 'a.b'" // INVALID
  )

  @Test(expected=IllegalArgumentException::class)
  fun testRegexAgainstBoolean() = test(
    "aBoolean =~ /a.b/",
    model,
    "aBoolean ~ 'a.b'" // INVALID
  )

  @Test(expected=IllegalArgumentException::class)
  fun testRegexAgainstNumber() = test(
    "aNumber =~ /a.b/",
    model,
    "aNumber ~ 'a.b'" // INVALID
  )

  @Test(expected=IllegalArgumentException::class)
  fun testRegexLiteralWithWrongOperator() = test(
    "aString < /a.b/",
    model,
    "aString < 'a.b'" // NOT WHAT WE INTENDED
  )

  @Test(expected=IllegalArgumentException::class)
  fun testRegexOperatorWithNonLiteral() = test(
    "aString =~ anotherString",
    model.plus(mapOf("anotherString" to ExDataType.STRING)),
    "aString ~ anotherString" // INVALID
  )

  @Test(expected=IllegalArgumentException::class)
  fun testGreaterWithMismatchedOperands() = test(
    "aNumber > aDate",
    model,
    "aNumber > aDate" // INVALID
  )

  @Test(expected=IllegalArgumentException::class)
  fun testGreaterWithInvalidOperandType() = test(
    "aBoolean > anotherBoolean",
    model.plus("anotherBoolean" to ExDataType.BOOLEAN),
    "aBoolean > anotherBoolean" // INVALID
  )

  @Test(expected=IllegalArgumentException::class)
  fun testGreaterOrEqualWithMismatchedOperands() = test(
    "aString >= aDate",
    model,
    "aString >= aDate" // INVALID
  )

  @Test(expected=IllegalArgumentException::class)
  fun testGreaterOrEqualWithInvalidOperandType() = test(
    "aNumber >= /a.b/",
    model,
    "aNumber >= 'a.b'" // INVALID
  )

  @Test(expected=IllegalArgumentException::class)
  fun testLessWithMismatchedOperands() = test(
    "aDate < aDateTime",
    model,
    "aDate < aDateTime" // INVALID
  )

  @Test(expected=IllegalArgumentException::class)
  fun testLessWithInvalidOperandType() = test(
    "[1, 2] < [2, 1]",
    model,
    "(1, 2) < (2, 1)" // INVALID
  )

  @Test(expected=IllegalArgumentException::class)
  fun testLessEqualWithMismatchedOperands() = test(
    "aTime <= 5",
    model,
    "aTime <= 5" // INVALID
  )

  @Test(expected=IllegalArgumentException::class)
  fun testLessEqualWithInvalidOperandType() = test(
    "aBoolean <= false",
    model,
    "aBoolean <= FALSE" // INVALID
  )

  @Test(expected=IllegalArgumentException::class)
  fun testNullWithIn() = test(
    "aString IN [\"foo\", null, \"bar\"]",
    model,
    "aString IN ('foo', NULL, 'bar')", // INVALID
  )

  @Test(expected=IllegalArgumentException::class)
  fun testNullWithContains() = test(
    "[\"foo\", null, \"bar\"] !contains aString",
    model,
    "aString NOT IN ('foo', NULL, 'bar')", // INVALID
  )
  
  // TODO a big complex nested expression with parens, not, multiple operators, etc.
}