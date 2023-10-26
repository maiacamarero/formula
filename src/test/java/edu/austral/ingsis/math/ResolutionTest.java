package edu.austral.ingsis.math;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        Function sum = new Sum(new Operand(1), new Operand(6));
        final Double result = sum.evaluate();

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        Function div = new Div(new Operand(12), new Operand(2));
        final Double result = div.evaluate();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        Function div = new Div(new Operand(9), new Operand(2));
        Function mul = new Mul(div, new Operand(3));
        final Double result = mul.evaluate();

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        Function base = new Div(new Operand(27), new Operand(6));
        Function pow = new Pow(base, new Operand(2));
        final Double result = pow.evaluate();

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        Function sqrt = new Sqrt(new Operand(36));
        final Double result = sqrt.evaluate();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        Function mod = new Mod(new Operand(136));
        final Double result = mod.evaluate();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        Function mod = new Mod(new Operand(-136));
        final Double result = mod.evaluate();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        Function sub = new Sub(new Operand(5), new Operand(5));
        Function mul = new Mul(sub, new Operand(8));
        final Double result = mul.evaluate();

        assertThat(result, equalTo(0d));
    }
}
