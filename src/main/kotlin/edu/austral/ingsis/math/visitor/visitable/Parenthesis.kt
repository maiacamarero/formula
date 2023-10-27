package edu.austral.ingsis.math.visitor.visitable

import edu.austral.ingsis.math.visitor.visitor.Visitor

class Parenthesis(private val parenthesis : Visitable) : Visitable {
    override fun <T> accept(visitor: Visitor<T>): T {
        return visitor.visit(this)
    }

    fun getParenthesis() : Visitable{
        return parenthesis
    }
}