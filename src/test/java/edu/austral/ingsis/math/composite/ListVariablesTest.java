package edu.austral.ingsis.math.composite;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        Function sum = new Sum(new Operand(1), new Operand(6));
        final List<String> result = sum.listVariables();

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        Function div = new Div(new Operand(12), new Variable("div"));
        final List<String> result = div.listVariables();

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        Function div = new Div(new Operand(9), new Variable("x"));
        Function mul = new Mul(div, new Variable("y"));
        final List<String> result = mul.listVariables();

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        Function div = new Div(new Operand(27), new Variable("a"));
        Function pow = new Pow(div, new Variable("b"));
        final List<String> result = pow.listVariables();

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        Function div = new Div(new Operand(1), new Operand(2));
        Function pow = new Pow(new Variable("z"), div);
        final List<String> result = pow.listVariables();

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        Function mod = new Mod(new Variable("value"));
        Function sub = new Sub(mod, new Operand(8));
        final List<String> result = sub.listVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        Function mod = new Mod(new Variable("value"));
        Function sub = new Sub(mod, new Operand(8));
        final List<String> result = sub.listVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        Function sub = new Sub(new Operand(5), new Variable("i"));
        Function mul = new Mul(sub, new Operand(8));
        final List<String> result = mul.listVariables();

        assertThat(result, containsInAnyOrder("i"));
    }
}
