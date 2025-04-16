package edu.austral.dissis.formula;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

  /**
   * Case 1 + 6.
   */
  @Test
  public void shouldPrintFunction1() {
    Expression expr = new Sum(new Constant(1), new Constant(6));
    final String expected = "1 + 6";
    final String result = expr.print();
    assertThat(result, equalTo(expected));
  }

  /**
   * Case 12 / 2.
   */
  @Test
  public void shouldPrintFunction2() {
    Expression expr = new Division(new Constant(12), new Constant(2));
    final String expected = "12 / 2";
    final String result = expr.print();
    assertThat(result, equalTo(expected));
  }

  /**
   * Case (9 / 2) * 3.
   */
  @Test
  public void shouldPrintFunction3() {
    Expression expr = new Multiply(
        new Division(new Constant(9), new Constant(2)),
        new Constant(3)
    );
    final String expected = "(9 / 2) * 3";
    final String result = expr.print();
    assertThat(result, equalTo(expected));
  }

  /**
   * Case (27 / 6) ^ 2.
   */
  @Test
  public void shouldPrintFunction4() {
    Expression expr = new Power(
        new Division(new Constant(27), new Constant(6)),
        new Constant(2)
    );
    final String expected = "(27 / 6) ^ 2";
    final String result = expr.print();
    assertThat(result, equalTo(expected));
  }

  /**
   * Case |value| - 8.
   */
  @Test
  public void shouldPrintFunction6() {
    Expression expr = new Substraction(
        new Absolut(new Variable("value")),
        new Constant(8)
    );
    final String expected = "|value| - 8";
    final String result = expr.print();
    assertThat(result, equalTo(expected));
  }

  /**
   * Case √value - 8.
   */
  @Test
  public void shouldPrintFunction7() {
    Expression expr = new Substraction(
        new Sqrt(new Variable("value")),
        new Constant(8)
    );
    final String expected = "√(value) - 8";
    final String result = expr.print();
    assertThat(result, equalTo(expected));
  }

  /**
   * Case (5 - i) * 8.
   */
  @Test
  public void shouldPrintFunction8() {
    Expression expr = new Multiply(
        new Substraction(new Constant(5), new Variable("i")),
        new Constant(8)
    );
    final String expected = "(5 - i) * 8";
    final String result = expr.print();
    assertThat(result, equalTo(expected));
  }
}
