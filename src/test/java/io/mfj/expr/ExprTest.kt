/*
Copyright 2018 Measures for Justice Institute.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package io.mfj.expr

import org.junit.Assert.*
import org.junit.Test
import java.time.LocalDate
import java.time.LocalDateTime

class ExprTest {

	val model = mapOf(
			"zero" to ExDataType.INTEGER,
			"one" to ExDataType.INTEGER,
			"two" to ExDataType.INTEGER,
			"aa" to ExDataType.INTEGER,
			"bb" to ExDataType.INTEGER,
			"cc" to ExDataType.INTEGER,
			"dd" to ExDataType.INTEGER,
			"ddd" to ExDataType.DOUBLE,
			"ss" to ExDataType.STRING,
			"rr" to ExDataType.REGEX,
			"dt" to ExDataType.DATE,
			"tm" to ExDataType.TIME,
			"ts" to ExDataType.DATETIME,
			"qed" to ExDataType.BOOLEAN
	)

	fun test( exprStr:String,
						vp:Map<String,Any?>,
						value:Boolean
						) {
		val expr = ExprParser.parseToExpr(exprStr, MapVarTypeProvider(model) )
		val ret = expr.value( MapVarProvider( vp ) )
		assertEquals( value, ret )
	}

	@Test
	fun test1() = test(
			"NOT(aa=0 AND bb=1 AND cc=2)",
			mapOf(
					"aa" to 0,
					"bb" to 1,
					"cc" to 2 ),
			false )

	@Test
	fun test2() = test(
			"NOT(aa=0 AND bb=1 AND cc=2)",
			mapOf(
					"aa" to 1,
					"bb" to 1,
					"cc" to 2 ),
			true )

	@Test
	fun test3() = test(
			"NOT(aa=2)",
			mapOf( "aa" to 2 ),
			false )

	@Test
	fun test4() = test(
			"NOT(aa=2)",
			mapOf( "aa" to 1 ),
			true )

	@Test
	fun test5() = test(
			"aa=0 AND NOT(bb=1) AND cc=2",
			mapOf(
					"aa" to 0,
					"bb" to 2,
					"cc" to 2 ),
			true )

	@Test
	fun test6() = test(
			"aa=0 AND NOT(bb=1) AND cc=2",
			mapOf(
					"aa" to 0,
					"bb" to 1,
					"cc" to 2 ),
			false )

	@Test
	fun test7() = test(
			"NOT(aa=0 AND bb=1) OR cc=2",
			mapOf(
					"aa" to 0,
					"bb" to 1,
					"cc" to 2 ),
			true )

	@Test
	fun test8() = test(
			"NOT(aa=0 AND bb=1) OR cc=2",
			mapOf(
					"aa" to 3,
					"bb" to 1,
					"cc" to 3 ),
			true )

	@Test
	fun test9() = test(
			"NOT(aa=0 AND bb=1) OR cc=2",
			mapOf(
					"aa" to 0,
					"bb" to 1,
					"cc" to 3 ),
			false )

	@Test
	fun test10() = test(
			"NOT(0=aa AND 1=bb) OR 2=cc",
			mapOf(
					"aa" to 0,
					"bb" to 1,
					"cc" to 3 ),
			false )

	@Test
	fun test11() = test(
			"NOT(zero=aa AND one=bb) OR two=cc",
			mapOf(
					"zero" to 0,
					"one" to 1,
					"two" to 2,
					"aa" to 0,
					"bb" to 1,
					"cc" to 3 ),
			false )

	@Test
	fun test12() = test(
			"ss=\"abc\"",
			mapOf( "ss" to "abc" ),
			true )

	@Test
	fun test13() = test(
			"ss=\"abc\"",
			mapOf( "ss" to "def" ),
			false )

	@Test
	fun test14() = test(
			"ss=\"a\\\"bc\"",
			mapOf( "ss" to "a\"bc" ),
			true )

	@Test
	fun test15() = test(
			"ss=~/a.+c/",
			mapOf( "ss" to "abc" ),
			true )

	@Test
	fun test16() = test(
			"ss =~ /a.+c/",
			mapOf( "ss" to "adc" ),
			true )

	@Test
	fun test17() = test(
			"ss=~\"a.+c\"",
			mapOf( "ss" to "abc" ),
			true )

	@Test
	fun test18() = test(
			"ss =~ \"a.+c\"",
			mapOf( "ss" to "adc" ),
			true )

	@Test
	fun test19() = test(
			"\"abc\" =~ rr",
			mapOf( "rr" to Regex( "a.+c" ) ),
			true )

	@Test
	fun test20() = test(
			"\"abc\" =~ ss",
			mapOf( "ss" to "a.+c" ),
			true )

	@Test
	fun test21() = test(
			"1 < aa < 5",
			mapOf( "aa" to 2 ),
			true )

	@Test
	fun test22() = test(
			"1 < aa < 5",
			mapOf( "aa" to 6 ),
			false )

	@Test
	fun test23() = test(
			"not(1 < aa < 5)",
			mapOf( "aa" to 2 ),
			false )

	@Test
	fun test24() = test(
			"not( 1 < aa < 5 )",
			mapOf( "aa" to 6 ),
			true )

	@Test
	fun test25() = test(
			"1 <= aa <= 5 and bb = 7 and ss =~ /.*/",
			mapOf( "aa" to 4, "bb" to 7, "ss" to "x" ),
			true )

	@Test
	fun test26() = test(
			"1.0 = aa",
			mapOf( "aa" to 1 ),
			true )

	@Test
	fun test27() = test(
			"1 = ddd",
			mapOf( "ddd" to 1.0 ),
			true )

	@Test
	fun test28() = test(
			"ss = null",
			mapOf( "ss" to null ),
			true )

	@Test
	fun test33() = test(
			"ss = null",
			mapOf( "ss" to "a" ),
			false )

	@Test
	fun test29() = test(
			"aa > 1.0",
			mapOf( "aa" to 2 ),
			true )

	@Test
	fun test30() = test(
			"ddd > 1",
			mapOf( "ddd" to 2.0 ),
			true )

	@Test
	fun test31() = test(
			"aa=0 AND bb=1 AND cc=2",
			mapOf(
					"aa" to 0,
					"bb" to 1,
					"cc" to 2 ),
			true )

	@Test
	fun test32() = test(
			"(aa=0) AND (bb=1) AND (cc=2)",
			mapOf(
					"aa" to 0,
					"bb" to 1,
					"cc" to 2 ),
			true )

	@Test(expected=Exception::class)
	fun test34() = test(
			"1 = 1 ad 2 = 2",
			mapOf(),
			true )

	@Test
	fun testWhitespace() = test(
			"""
				 1
				=     1

				and
				 NOT
				 (
				 3
				 =
				 2
				 )
				 and

				 (    1    =   2   or   1   =   1  )

				 and

				 "one" =~ /[oO]n[eE]/

				 and

				ss    =

				 "hello"   """,
			mapOf( "ss" to "hello" ),
			true )

	@Test(expected=Exception::class)
	fun invalidDateDays() = test(
		"d'2018-01-01' = d'2018-12-34'",
		mapOf(),
		false
	)

	@Test(expected=Exception::class)
	fun invalidDateFormat() = test(
		"d'2018-01-01' = d'2018-12-12T12:03:12Z'",
		mapOf(),
		false
	)

	@Test
	fun testDateGreaterThan() = test(
		"d'2018-03-28' > d'2017-12-12'",
		mapOf(),
		true
	)

	@Test
	fun testDateLessThan() = test(
		"dt < d'2017-12-12'",
		mapOf("dt" to LocalDate.now()),
		false
	)

	@Test
	fun testDateEquals() = test(
		"dt = d'2017-12-12'",
		mapOf("dt" to LocalDate.of(2017, 12, 12)),
		true
	)

	@Test(expected=Exception::class)
	fun invalidDateTimeSeconds() = test(
		"dt'2018-01-01T12:03:12Z' = dt'2018-12-12T22:88:00Z'",
		mapOf(),
		false
	)

	@Test(expected=Exception::class)
	fun invalidDateTimeFormat() = test(
		"dt'2018-01-01T12:03:12Z' = dt'2018-12-12'",
		mapOf(),
		false
	)

	@Test
	fun testDateTimeGreaterThan() = test(
		"dt'2018-03-28T01:20:35Z' > dt'2017-12-12T14:23:18Z'",
		mapOf(),
		true
	)

	@Test
	fun testDateTimeLessThan() = test(
		"ts < dt'2017-12-12T13:33:33Z'",
		mapOf("ts" to LocalDateTime.now()),
		false
	)

	@Test
	fun testDateTimeEquals() = test(
		"ts = dt'2017-12-13T21:22:23Z'",
		mapOf("ts" to LocalDateTime.of(2017, 12, 13, 21, 22, 23)),
		true
	)

	@Test
	fun testBooleanVar() = test(
		"qed = true and qed != false",
		mapOf("qed" to true),
		true
	)

	@Test(expected=Exception::class)
	fun testInvalidBooleanLiteral() = test(
		"qed = truedat",
		mapOf("qed" to true),
		true
	)

}