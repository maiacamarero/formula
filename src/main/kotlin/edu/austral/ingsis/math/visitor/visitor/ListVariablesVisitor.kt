package edu.austral.ingsis.math.visitor.visitor

import edu.austral.ingsis.math.visitor.visitable.*

class ListVariablesVisitor : Visitor<List<String>> {
    override fun visit(sum: Sum): List<String> {
        return (sum.getA().accept(this).asSequence() + sum.getB().accept(this).asSequence()).toList()
    }

    override fun visit(sub: Sub): List<String> {
        return (sub.getA().accept(this).asSequence() + sub.getB().accept(this).asSequence()).toList()
    }

    override fun visit(mul: Mul): List<String> {
        return (mul.getA().accept(this).asSequence() + mul.getB().accept(this).asSequence()).toList()
    }

    override fun visit(div: Div): List<String> {
        return (div.getA().accept(this).asSequence() + div.getB().accept(this).asSequence()).toList()
    }

    override fun visit(pow: Pow): List<String> {
        return (pow.getBase().accept(this).asSequence() + pow.getExponent().accept(this).asSequence()).toList()
    }

    override fun visit(sqrt: Sqrt): List<String> {
        return sqrt.getValue().accept(this)
    }

    override fun visit(mod: Mod): List<String> {
        return mod.getValue().accept(this)
    }

    override fun visit(operand: Operand): List<String> {
        return listOf()
    }

    override fun visit(variable: Variable): List<String> {
        return listOf(variable.getVariable())
    }

    override fun visit(parenthesis: Parenthesis): List<String> {
        return parenthesis.getParenthesis().accept(this)
    }
}