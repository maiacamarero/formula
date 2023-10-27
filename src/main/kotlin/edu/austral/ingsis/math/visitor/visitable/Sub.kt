package edu.austral.ingsis.math.visitor.visitable

import edu.austral.ingsis.math.visitor.visitor.Visitor

class Sub(private val a : Visitable, private val b : Visitable) : Visitable {
    override fun <T> accept(visitor: Visitor<T>): T {
        return visitor.visit(this)
    }

    fun getA() : Visitable{
        return a
    }

    fun getB() : Visitable{
        return b
    }
}