package edu.austral.ingsis.math

import kotlin.collections.mutableListOf as mutableListOf

class Variable(private val variable : String) : Function {
    override fun evaluate(map: Map<String, Double>): Double {
        return map[variable]!!
    }

    override fun print(): String {
        return variable
    }

    override fun listVariables(list: List<String>): List<String> {
        val names: MutableList<String> = mutableListOf()
        names.add(variable)
        return (list.asSequence() + names.asSequence()).toList()
    }
}