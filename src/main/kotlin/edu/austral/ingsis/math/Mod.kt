package edu.austral.ingsis.math

import kotlin.math.abs

class Mod(private val function: Function) : Function {
    override fun evaluate(map: Map<String, Double>): Double {
        return abs(function.evaluate(map))
    }

    override fun print(): String {
        return "|" + function.print() + "|"
    }

    override fun listVariables(): List<String> {
        return function.listVariables().toList()
    }
}