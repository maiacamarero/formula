package edu.austral.ingsis.math.visitor.visitor

import edu.austral.ingsis.math.visitor.visitable.*

class PrintVisitor : Visitor<String> {
    override fun visit(sum: Sum): String {
        return sum.getA().accept(this) + " + " + sum.getB().accept(this)
    }

    override fun visit(sub: Sub): String {
        return sub.getA().accept(this) + " - " + sub.getB().accept(this)
    }

    override fun visit(mul: Mul): String {
        return mul.getA().accept(this) + " * " + mul.getB().accept(this)
    }

    override fun visit(div: Div): String {
        return div.getA().accept(this) + " / " + div.getB().accept(this)
    }

    override fun visit(pow: Pow): String {
        return pow.getBase().accept(this) + " ^ " + pow.getExponent().accept(this)
    }

    override fun visit(sqrt: Sqrt): String {
        return " √ " + sqrt.getValue().accept(this)
    }

    override fun visit(mod: Mod): String {
        return "|" + mod.getValue().accept(this) + "|"
    }

    override fun visit(operand: Operand): String {
        return if (operand.getValue() % 1 == 0.0){
            operand.getValue().toInt().toString()
        }else operand.getValue().toString()
    }

    override fun visit(variable: Variable): String {
        return variable.getVariable()
    }

    override fun visit(parenthesis: Parenthesis): String {
        return "(" + parenthesis.getParenthesis().accept(this) + ")"
    }
}