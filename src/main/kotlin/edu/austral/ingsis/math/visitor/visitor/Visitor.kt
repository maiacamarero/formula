package edu.austral.ingsis.math.visitor.visitor

import edu.austral.ingsis.math.visitor.visitable.*

interface Visitor<T> {
    fun visit(sum: Sum) : T
    fun visit(sub: Sub) : T
    fun visit(mul: Mul) : T
    fun visit(div: Div) : T
    fun visit(pow: Pow) : T
    fun visit(sqrt: Sqrt) : T
    fun visit(mod: Mod) : T
    fun visit(operand: Operand) : T
    fun visit(variable: Variable) : T
    fun visit(parenthesis: Parenthesis) : T
}