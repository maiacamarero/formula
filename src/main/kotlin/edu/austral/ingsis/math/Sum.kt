package edu.austral.ingsis.math

class Sum(private val a: Function, private val b: Function) : Function {
    override fun evaluate(map: Map<String, Double>): Double {
        return a.evaluate(map) + b.evaluate(map)
    }

    override fun print(): String {
        return a.print() + " + " + b.print()
    }

    override fun listVariables(list: List<String>): List<String> {
        return (a.listVariables(list).asSequence() + b.listVariables(list).asSequence()).toList()
    }


}