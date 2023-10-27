package edu.austral.ingsis.math.visitor.visitable

import edu.austral.ingsis.math.visitor.visitor.Visitor

interface Visitable {
    fun <T> accept(visitor: Visitor<T>) : T
}