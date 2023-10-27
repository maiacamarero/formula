package edu.austral.ingsis.math

import kotlin.math.pow

class Pow(private val base : Function, private val exponent : Function) : Function {
    override fun evaluate(map: Map<String, Double>): Double {
        return base.evaluate(map).pow(exponent.evaluate(map))
    }

    override fun print(): String {
        return if (base::class.simpleName == "Operand"){
            base.print() + " ^ " + exponent.print()
        }else "(" + base.print() + ")" + " ^ " + exponent.print()
    }

    override fun listVariables(): List<String> {
        return (base.listVariables().asSequence() + exponent.listVariables().asSequence()).toList()
    }
}