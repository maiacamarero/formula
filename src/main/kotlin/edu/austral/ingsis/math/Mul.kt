package edu.austral.ingsis.math

class Mul(private val a: Function, private val b: Function) : Function {
    override fun evaluate(map: Map<String, Double>): Double {
        return a.evaluate(map) * b.evaluate(map)
    }

    override fun print(): String {
        return if (a::class.simpleName == "Operand"){
            a.print() + " * " + b.print()
        }else "(" + a.print() + ")" + " * " + b.print()
    }

    override fun listVariables(): List<String> {
        return (a.listVariables().asSequence() + b.listVariables().asSequence()).toList()
    }


}