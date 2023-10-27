package edu.austral.ingsis.math.visitor;
import edu.austral.ingsis.math.visitor.visitable.*;
import edu.austral.ingsis.math.visitor.visitor.EvaluateVisitor;
import edu.austral.ingsis.math.visitor.visitor.Visitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {
    private final Visitor<Double> visitor = new EvaluateVisitor();

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        final Double result = visitor.visit(new Sum(new Operand(1), new Operand(6)));

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        final Double result = visitor.visit(new Div(new Operand(12), new Operand(2)));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        Div div = new Div(new Operand(9), new Operand(2));
        final Double result = visitor.visit(new Mul(div, new Operand(3)));

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        Div div = new Div(new Operand(27), new Operand(6));
        final Double result = visitor.visit(new Pow(div, new Operand(2)));

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        final Double result = visitor.visit(new Sqrt(new Operand(36)));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        final Double result = visitor.visit(new Mod(new Operand(136)));

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        final Double result = visitor.visit(new Mod(new Operand(-136)));

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        Sub sub = new Sub(new Operand(5), new Operand(5));
        final Double result = visitor.visit(new Mul(sub, new Operand(8)));

        assertThat(result, equalTo(0d));
    }
}