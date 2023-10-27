package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.visitable.*;
import edu.austral.ingsis.math.visitor.visitor.ListVariablesVisitor;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ListVariablesTest {
    private final ListVariablesVisitor visitor = new ListVariablesVisitor();

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        final List<String> result = visitor.visit(new Sum(new Operand(1), new Operand(6)));

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        final List<String> result = visitor.visit(new Div(new Operand(12), new Variable("div")));

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        Div div = new Div(new Operand(9), new Variable("x"));
        final List<String> result = visitor.visit(new Mul(div, new Variable("y")));

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        Div div = new Div(new Operand(27), new Variable("a"));
        final List<String> result = visitor.visit(new Pow(div, new Variable("b")));

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        final List<String> result = visitor.visit(new Sqrt(new Variable("z")));

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        final List<String> result = visitor.visit(new Sub(new Mod(new Variable("value")), new Operand(8)));

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        final List<String> result = visitor.visit(new Sub(new Mod(new Variable("value")), new Operand(8)));

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        Sub sub = new Sub(new Operand(5), new Variable("i"));
        final List<String> result = visitor.visit(new Mul(sub, new Operand(8)));

        assertThat(result, containsInAnyOrder("i"));
    }
}