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

import org.parboiled.BaseParser
import org.parboiled.Rule
import org.parboiled.annotations.BuildParseTree
import org.parboiled.matchers.CharMatcher
import org.parboiled.support.StringVar
import org.parboiled.support.Var

@BuildParseTree
open class ExprPegParser : BaseParser<Any>() {

  open fun Root(): Rule {
    return Sequence(
        ZeroOrMore(Whitespace()),
        Expression(),
        ZeroOrMore(Whitespace()),
        EOI
    )
  }

  open fun Expression() : Rule {
    return Sequence(
      Term(),
      ZeroOrMore(
        Sequence(
          OneOrMore(Whitespace()),
          Conjunction(),
          OneOrMore(Whitespace()),
          Term()
        )
      ),
      ZeroOrMore(Whitespace())
    )
  }

  open fun Term() : Rule {
    return FirstOf(
      Not(),
      Statement(),
      Parens()
    )
  }

  open fun Parens() : Rule {
    return Sequence(
      CharMatcher('('),
      pushOpenParen(false),
      ZeroOrMore( Whitespace() ),
      Expression(),
      ZeroOrMore( Whitespace() ),
      CharMatcher(')'),
      pushCloseParen()
    )
  }

  open fun Not() : Rule {
    return Sequence(
      IgnoreCase("NOT"),
      ZeroOrMore(Whitespace()),
      CharMatcher('('),
      pushOpenParen(true),
      ZeroOrMore(Whitespace()),
      Expression(),
      CharMatcher(')'),
      pushCloseParen()
    )
  }

  open fun Statement() : Rule {
    val v = Var<ExNode>()
    return Sequence(
      v.set(ExNode(ExNodeType.LOGIC_STATEMENT)),
      FirstOf(MathStatement(), Value()),
      v.get().setLeft(pop() as ExVal),
      ZeroOrMore(Whitespace()),
      LogicOperator(),
      ZeroOrMore(Whitespace()),
      v.get().setOp(pop() as String),
        FirstOf(MathStatement(), Value()),
      v.get().setRight(pop() as ExVal),

      Optional(
          ZeroOrMore(Whitespace()),
          LogicOperator(),
          ZeroOrMore(Whitespace()),
          v.get().setOp2(pop() as String),
          FirstOf(MathStatement(), Value()),
          v.get().setRight2(pop() as ExVal)
      ),

      pushStatement(v.get())
    )
  }

  open fun MathStatement() : Rule {
      val l = Var<ExVal>()
      val o = Var<ExMathOpType>()
      val r = Var<ExVal>()

      return Sequence(
          Value(),
          l.set(pop() as ExVal),
          ZeroOrMore(Whitespace()),
          MathOperator(),
          ZeroOrMore(Whitespace()),
          o.set(ExMathOpType.fromSymbol(pop() as String)),
          FirstOf(MathStatement(), Value()),
          r.set(pop() as ExVal),
          push(ExCom(l.get(), o.get(), r.get()))
      )
  }

  open fun Value() : Rule {
    return FirstOf(
        LiteralValue(), // first because of literal keywords (e.g.: null)
        VariableName(),
        ListValue(),
    )
  }

  open fun Conjunction() : Rule {
    return Sequence(
      FirstOf(
        IgnoreCase("AND"),
        IgnoreCase("OR")
      ),
      pushConjunction(match())
    )
  }

  open fun LogicOperator() : Rule {
    return Sequence(
      FirstOf( ExLogicOpType.symbols.toTypedArray() ),
      push(match())
    )
  }

  open fun MathOperator() : Rule {
    return Sequence(
      FirstOf( ExMathOpType.symbols.toTypedArray() ),
      push(match())
    )
  }

  open fun Whitespace() : Rule {
    return AnyOf(" \t\n")
  }

  open fun LiteralValue() : Rule {
    return FirstOf(
        DecimalValue(),
        StringValue(),
        RegexValue(),
        DateTimeValue(),
        DateValue(),
        TimeValue(),
        BooleanLiteral(),
        NullLiteral()
      )
  }

  open fun DecimalValue() : Rule {
    return Sequence(
        Decimal(),
        push(ExLit(ExDataType.NUMBER, match()))
    )
  }

  open fun Decimal() : Rule {
    return Sequence(
        Optional(CharMatcher('-')),
        OneOrMore(Digit()),
        Optional(
            Sequence(
                CharMatcher('.'),
                OneOrMore(Digit())
            )
        )
    )
  }

  open fun StringValue(): Rule {
    val text = StringVar()
    return Sequence(
        "\"",
        TextOrEmpty(charsRequiringEscape = "\"", var_ = text),
        "\"",
        push( ExLit( ExDataType.STRING, text.get() )
      )
    )
  }

  open fun RegexValue(): Rule {
    val text = StringVar()
    return Sequence(
        "/",
        TextOrEmpty(charsRequiringEscape = "/", var_ = text),
        "/",
        push( ExLit( ExDataType.REGEX, text.get() )
        )
    )
  }

  open fun DateValue(): Rule {
    val text = StringVar()
    return Sequence(
      IgnoreCase("d'"),
      TextOrEmpty(charsRequiringEscape = "\'", var_ = text),
      "'",
      push( ExLit( ExDataType.DATE, text.get() )
      )
    )
  }

  open fun TimeValue(): Rule {
    val text = StringVar()
    return Sequence(
      IgnoreCase("t'"),
      TextOrEmpty(charsRequiringEscape = "\'", var_ = text),
      "'",
      push( ExLit( ExDataType.TIME, text.get() )
      )
    )
  }

  open fun DateTimeValue(): Rule {
    val text = StringVar()
    return Sequence(
      IgnoreCase("dt'"),
      TextOrEmpty(charsRequiringEscape = "\'", var_ = text),
      "'",
      push( ExLit( ExDataType.DATETIME, text.get() )
      )
    )
  }

  open fun BooleanLiteral(): Rule {
    return Sequence(
      FirstOf(
        IgnoreCase( "true" ),
        IgnoreCase( "false" )
      ),
      push( ExLit( ExDataType.BOOLEAN, match() ) )
    )
  }

  open fun NullLiteral(): Rule {
    return Sequence(
        IgnoreCase( "null" ),
        push( ExLit( ExDataType.STRING, null ) )
    )
  }

  /**
   * A text string where the specified characters and backslash must be escaped with a backslash.
   * The text can be empty.
   *
   * @param charsRequiringEscape
   * @param var_ Var to set text to.
   */
  open fun TextOrEmpty(charsRequiringEscape: String, var_: StringVar): Rule {
    return Sequence(
        var_.append( "" ),
        ZeroOrMore(
            FirstOf(
                Sequence('\\', AnyOf(charsRequiringEscape + '\\'), var_.append(match()) ),
                OneOrMore(
                    Sequence(TestNot(AnyOf(charsRequiringEscape + '\\')), ANY, var_.append(match()) )
                ).suppressSubnodes()
            )
        )
    )
  }

  open fun ListValue(): Rule {
    return Sequence(
        "[",
        push(ExList()),
        ZeroOrMore(Whitespace()),
        ListItem(),
        ZeroOrMore(
            ZeroOrMore(Whitespace()),
            ",",
            ZeroOrMore(Whitespace()),
            ListItem(),
        ),
        Optional( "," ),
        ZeroOrMore(Whitespace()),
        "]",
    )
  }

  open fun ListItem(): Rule {
    return Sequence(
        Value(),
        ( peek(1) as ExList ).values.add( pop() as ExVal )
    )
  }

  open fun VariableName() : Rule {
    return Sequence(
      Letter(),
      push(match()),
      ZeroOrMore(LetterOrDigit()),
      push("${pop() as String}${match()}"),
      TestNot(LetterOrDigit()),
      push(ExVar(pop() as String))
    )
  }

  open fun LetterOrDigit() : Rule {
    return FirstOf(CharRange('a', 'z'), CharRange('A', 'Z'), CharRange('0', '9'), '_')
  }

  open fun Letter() : Rule {
    return FirstOf(CharRange('a', 'z'), CharRange('A', 'Z'), '_')
  }

  open fun Digit() : Rule {
    return CharRange('0', '9')
  }

  fun peekOrAddTop(): ExNode {
    return try {
      peek() as ExNode
    } catch (iae: IllegalArgumentException) {
      val nn = ExNode(ExNodeType.CONJUNCTION)
      push(nn)
      nn
    }
  }

  fun pushOpenParen(isNot: Boolean) : Boolean {
    val top = peekOrAddTop()
    val pnode = pop() as ExNode
    val cnode = ExNode(ExNodeType.CONJUNCTION)
    cnode.setNot(isNot)
    pnode.addChild(cnode)
    return push(cnode)
  }

  fun pushCloseParen() : Boolean {
    val top = try {
      pop() as ExNode
    } catch (iae: IllegalArgumentException) {
      throw Exception("conjunction without previous statement")
    }
    if (top.node_type != ExNodeType.CONJUNCTION) {
      throw Exception("top node is not a conjunction")
    }
    if (top.parent == null) {
      throw Exception("close paren without open paren")
    }
    return push(top.parent!!)
  }

  fun pushStatement(cnode: ExNode) : Boolean {
    val top = peekOrAddTop()
    if (top.node_type != ExNodeType.CONJUNCTION) {
      throw Exception("top node is not a conjunction")
    }
    top.addChild(cnode)
    return true
  }

  fun pushConjunction(conj: String) : Boolean {
    try {
      val conj_type = ExConjType.valueOf(conj.toUpperCase())
      val top = try {
        peek() as ExNode
      } catch (iae: IllegalArgumentException) {
        throw Exception("conjunction without previous statement")
      }
      if (top.node_type != ExNodeType.CONJUNCTION) {
        throw Exception("top node is not a conjunction")
      }
      if (top.conj_type == null) {
        top.setConjType(conj_type)
      } else if (top.conj_type != conj_type) {
        // pull the parent, add ourself as child, push ourself
        val pnode = pop() as ExNode
        val cnode = ExNode(ExNodeType.CONJUNCTION)
        cnode.setConjType(conj_type)
        pnode.addChild(cnode)
        return push(cnode)
      }
    } catch(e: Exception) {
      return false
    }
    return true
  }

}

// when parsing values (either a variable name or a literal),
// one of these objects is used.
// There is no type model at this point, so there is no type for variables, only for literals.
sealed class ExVal
class ExLit( val type:ExDataType, val value:String? ): ExVal()
class ExVar( val name:String ): ExVal()
class ExCom( val left:ExVal, val op: ExMathOpType, val right: ExVal): ExVal()
class ExList( val values:MutableList<ExVal> = mutableListOf()): ExVal()
