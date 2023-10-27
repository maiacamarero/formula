package edu.austral.ingsis.math.visitor.visitor

import edu.austral.ingsis.math.visitor.visitable.*
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

class EvaluateVisitor(private val map: Map<String, Double>) : Visitor<Double> {
    constructor() : this(mapOf())
    override fun visit(sum: Sum): Double {
        return sum.getA().accept(this) + sum.getB().accept(this)
    }

    override fun visit(sub: Sub): Double {
        return sub.getA().accept(this) - sub.getB().accept(this)
    }

    override fun visit(mul: Mul): Double {
        return mul.getA().accept(this) * mul.getB().accept(this)
    }

    override fun visit(div: Div): Double {
        return div.getA().accept(this) / div.getB().accept(this)
    }

    override fun visit(pow: Pow): Double {
        return pow.getBase().accept(this).pow(pow.getExponent().accept(this))
    }

    override fun visit(sqrt: Sqrt): Double {
        return sqrt(sqrt.getValue().accept(this))
    }

    override fun visit(mod: Mod): Double {
        return abs(mod.getValue().accept(this))
    }

    override fun visit(operand: Operand): Double {
        return operand.getValue()
    }

    override fun visit(variable: Variable): Double {
        return if (map.containsKey(variable.getVariable())){
            map[variable.getVariable()]!!
        }else 0.0
    }

    override fun visit(parenthesis: Parenthesis): Double {
        return parenthesis.getParenthesis().accept(this)
    }
}