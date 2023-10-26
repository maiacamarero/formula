package edu.austral.ingsis.math;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        Function sum = new Sum(new Operand(1), new Operand(6));
        final String expected = "1 + 6";
        final String result = sum.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        Function div = new Div(new Operand(12), new Operand(2));
        final String expected = "12 / 2";
        final String result = div.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        Function div = new Div(new Operand(9), new Operand(2));
        Function mul = new Mul(div, new Operand(3));
        final String expected = "(9 / 2) * 3";
        final String result = mul.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        Function base = new Div(new Operand(27), new Operand(6));
        Function pow = new Pow(base, new Operand(2));
        final String expected = "(27 / 6) ^ 2";
        final String result = pow.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        Function mod = new Mod(new Variable("value"));
        Function sub = new Sub(mod, new Operand(8));
        final String expected = "|value| - 8";
        final String result = sub.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        Function mod = new Mod(new Variable("value"));
        Function sub = new Sub(mod, new Operand(8));
        final String expected = "|value| - 8";
        final String result = sub.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        Function sub = new Sub(new Operand(5), new Variable("i"));
        Function mul = new Mul(sub, new Operand(8));
        final String expected = "(5 - i) * 8";
        final String result = mul.print();

        assertThat(result, equalTo(expected));
    }
}
