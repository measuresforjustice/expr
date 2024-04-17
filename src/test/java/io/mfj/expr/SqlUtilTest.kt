package io.mfj.expr

import org.junit.Assert.assertEquals
import org.junit.Test

class SqlUtilTest {
  val model = mapOf(
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
  fun testRegexMatch() = test(
    "aString =~ /a.b/",
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

  // TODO inverted statements (not)
  // TODO math statements
  // TODO nulls
  // TODO complex nested expression with parens, not, multiple operators, etc.
  // TODO operand type validity checks
}