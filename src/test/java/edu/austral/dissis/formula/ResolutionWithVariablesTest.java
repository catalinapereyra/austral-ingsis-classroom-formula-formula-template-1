package edu.austral.dissis.formula;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

  /**
   * Case 1 + x where x = 3.
   */
  @Test
  public void shouldResolveFunction1() {
    Expression expr = new Sum(new Constant(1), new Variable("x"));
    final Double result = expr.evaluate(Map.of("x", 3d));
    assertThat(result, equalTo(4d));
  }

  /**
   * Case 12 / div where div = 4.
   */
  @Test
  public void shouldResolveFunction2() {
    Expression expr = new Division(new Constant(12), new Variable("div"));
    final Double result = expr.evaluate(Map.of("div", 4d));
    assertThat(result, equalTo(3d));
  }

  /**
   * Case (9 / x) * y where x = 3 and y = 4.
   */
  @Test
  public void shouldResolveFunction3() {
    Expression expr = new Multiply(
        new Division(new Constant(9), new Variable("x")),
        new Variable("y")
    );
    final Double result = expr.evaluate(Map.of("x", 3d, "y", 4d));
    assertThat(result, equalTo(12d));
  }

  /**
   * Case (27 / a) ^ b where a = 9 and b = 3.
   */
  @Test
  public void shouldResolveFunction4() {
    Expression expr = new Power(
        new Division(new Constant(27), new Variable("a")),
        new Variable("b")
    );
    final Double result = expr.evaluate(Map.of("a", 9d, "b", 3d));
    assertThat(result, equalTo(27d));
  }

  /**
   * Case z ^ (1/2) where z = 36.
   */
  @Test
  public void shouldResolveFunction5() {
    Expression expr = new Power(
        new Variable("z"),
        new Division(new Constant(1), new Constant(2))
    );
    final Double result = expr.evaluate(Map.of("z", 36d));
    assertThat(result, equalTo(6d));
  }

  /**
   * Case |value| - 8 where value = 8.
   */
  @Test
  public void shouldResolveFunction6() {
    Expression expr = new Substraction(
        new Absolut(new Variable("value")),
        new Constant(8)
    );
    final Double result = expr.evaluate(Map.of("value", 8d));
    assertThat(result, equalTo(0d));
  }

  /**
   * Case |value| - 8 where value = 8.
   */
  @Test
  public void shouldResolveFunction7() {
    Expression expr = new Substraction(
        new Absolut(new Variable("value")),
        new Constant(8)
    );
    final Double result = expr.evaluate(Map.of("value", 8d));
    assertThat(result, equalTo(0d));
  }

  /**
   * Case (5 - i) * 8 where i = 2.
   */
  @Test
  public void shouldResolveFunction8() {
    Expression expr = new Multiply(
        new Substraction(new Constant(5), new Variable("i")),
        new Constant(8)
    );
    final Double result = expr.evaluate(Map.of("i", 2d));
    assertThat(result, equalTo(24d));
  }
}
