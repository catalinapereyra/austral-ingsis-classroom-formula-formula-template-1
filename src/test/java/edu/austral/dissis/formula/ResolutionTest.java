package edu.austral.dissis.formula;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

  /**
   * Case 1 + 6.
   */
  @Test
  public void shouldResolveSimpleFunction1() {
    Expression expr = new Sum(new Constant(1), new Constant(6));
    final Double result = expr.evaluate(Map.of());
    assertThat(result, equalTo(7d));
  }

  /**
   * Case 12 / 2.
   */
  @Test
  public void shouldResolveSimpleFunction2() {
    Expression expr = new Division(new Constant(12), new Constant(2));
    final Double result = expr.evaluate(Map.of());
    assertThat(result, equalTo(6d));
  }

  /**
   * Case (9 / 2) * 3.
   */
  @Test
  public void shouldResolveSimpleFunction3() {
    Expression expr = new Multiply(
        new Division(new Constant(9), new Constant(2)),
        new Constant(3)
    );
    final Double result = expr.evaluate(Map.of());
    assertThat(result, equalTo(13.5d));
  }

  /**
   * Case (27 / 6) ^ 2.
   */
  @Test
  public void shouldResolveSimpleFunction4() {
    Expression expr = new Power(
        new Division(new Constant(27), new Constant(6)),
        new Constant(2)
    );
    final Double result = expr.evaluate(Map.of());
    assertThat(result, equalTo(20.25d));
  }

  /**
   * Case 36 ^ (1/2).
   */
  @Test
  public void shouldResolveSimpleFunction5() {
    Expression expr = new Power(
        new Constant(36),
        new Division(new Constant(1), new Constant(2))
    );
    final Double result = expr.evaluate(Map.of());
    assertThat(result, equalTo(6d));
  }

  /**
   * Case |136|.
   */
  @Test
  public void shouldResolveSimpleFunction6() {
    Expression expr = new Absolut(new Constant(136));
    final Double result = expr.evaluate(Map.of());
    assertThat(result, equalTo(136d));
  }

  /**
   * Case |-136|.
   */
  @Test
  public void shouldResolveSimpleFunction7() {
    Expression expr = new Absolut(new Constant(-136));
    final Double result = expr.evaluate(Map.of());
    assertThat(result, equalTo(136d));
  }

  /**
   * Case (5 - 5) * 8.
   */
  @Test
  public void shouldResolveSimpleFunction8() {
    Expression expr = new Multiply(
        new Substraction(new Constant(5), new Constant(5)),
        new Constant(8)
    );
    final Double result = expr.evaluate(Map.of());
    assertThat(result, equalTo(0d));
  }
}
