package edu.austral.ingsis.math.composite

interface Function {
    fun evaluate(map: Map<String, Double>) : Double
    fun evaluate() : Double{
        return evaluate(mapOf())
    }
    fun print() : String
    fun listVariables() : List<String>
}