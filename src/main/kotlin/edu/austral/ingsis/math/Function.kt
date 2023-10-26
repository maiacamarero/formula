package edu.austral.ingsis.math

interface Function {
    fun evaluate(map: Map<String, Double>) : Double
    fun evaluate() : Double{
        return evaluate(mapOf())
    }
    fun print() : String
    fun listVariables(list: List<String>) : List<String>
}