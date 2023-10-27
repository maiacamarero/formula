package edu.austral.ingsis.math.visitor.visitable

import edu.austral.ingsis.math.visitor.visitor.Visitor

class Mod(private val value : Visitable) : Visitable {
    override fun <T> accept(visitor: Visitor<T>): T {
        return visitor.visit(this)
    }

    fun getValue(): Visitable{
        return value
    }
}