package edu.austral.ingsis.math.composite

import kotlin.math.sqrt

class Sqrt(private val function : Function) : Function {
    override fun evaluate(map: Map<String, Double>): Double {
        return sqrt(function.evaluate(map))
    }

    override fun print(): String {
        return "sqrt( " + function.print() + " )"
    }

    override fun listVariables(): List<String> {
        return function.listVariables()
    }
}