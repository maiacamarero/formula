package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.visitable.*;
import edu.austral.ingsis.math.visitor.visitor.PrintVisitor;
import edu.austral.ingsis.math.visitor.visitor.Visitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    private final Visitor<String> visitor = new PrintVisitor();

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "1 + 6";
        final String result = visitor.visit(new Sum(new Operand(1), new Operand(6)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "12 / 2";
        final String result = visitor.visit(new Div(new Operand(12), new Operand(2)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "(9 / 2) * 3";
        Div div = new Div(new Operand(9), new Operand(2));
        final String result = visitor.visit(new Mul(new Parenthesis(div), new Operand(3)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "(27 / 6) ^ 2";
        Div div = new Div(new Operand(27), new Operand(6));
        final String result = visitor.visit(new Pow(new Parenthesis(div), new Operand(2)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "|value| - 8";
        final String result = visitor.visit(new Sub(new Mod(new Variable("value")), new Operand(8)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "|value| - 8";
        final String result = visitor.visit(new Sub(new Mod(new Variable("value")), new Operand(8)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "(5 - i) * 8";
        Sub sub = new Sub(new Operand(5), new Variable("i"));
        final String result = visitor.visit(new Mul(new Parenthesis(sub), new Operand(8)));

        assertThat(result, equalTo(expected));
    }
}
