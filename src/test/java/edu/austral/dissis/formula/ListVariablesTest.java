package edu.austral.dissis.formula;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import java.util.List;

public class ListVariablesTest {

  /**
   * Case 1 + 6.
   */
  @Test
  public void shouldListVariablesFunction1() {
    Expression expr = new Sum(new Constant(1), new Constant(6));
    List<String> result = expr.getVariables().stream().toList();
    assertThat(result, empty());
  }

  /**
   * Case 12 / div.
   */
  @Test
  public void shouldListVariablesFunction2() {
    Expression expr = new Division(new Constant(12), new Variable("div"));
    List<String> result = expr.getVariables().stream().toList();
    assertThat(result, containsInAnyOrder("div"));
  }

  /**
   * Case (9 / x) * y.
   */
  @Test
  public void shouldListVariablesFunction3() {
    Expression expr = new Multiply(
        new Division(new Constant(9), new Variable("x")),
        new Variable("y")
    );
    List<String> result = expr.getVariables().stream().toList();
    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /**
   * Case (27 / a) ^ b.
   */
  @Test
  public void shouldListVariablesFunction4() {
    Expression expr = new Power(
        new Division(new Constant(27), new Variable("a")),
        new Variable("b")
    );
    List<String> result = expr.getVariables().stream().toList();
    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /**
   * Case z ^ (1/2).
   */
  @Test
  public void shouldListVariablesFunction5() {
    Expression expr = new Power(
        new Variable("z"),
        new Division(new Constant(1), new Constant(2))
    );
    List<String> result = expr.getVariables().stream().toList();
    assertThat(result, containsInAnyOrder("z"));
  }

  /**
   * Case |value| - 8.
   */
  @Test
  public void shouldListVariablesFunction6() {
    Expression expr = new Substraction(
        new Absolut(new Variable("value")),
        new Constant(8)
    );
    List<String> result = expr.getVariables().stream().toList();
    assertThat(result, containsInAnyOrder("value"));
  }

  /**
   * Case √value - 8.
   */
  @Test
  public void shouldListVariablesFunction7() {
    Expression expr = new Substraction(
        new Sqrt(new Variable("value")),
        new Constant(8)
    );
    List<String> result = expr.getVariables().stream().toList();
    assertThat(result, containsInAnyOrder("value"));
  }

  /**
   * Case (5 - i) * 8.
   */
  @Test
  public void shouldListVariablesFunction8() {
    Expression expr = new Multiply(
        new Substraction(new Constant(5), new Variable("i")),
        new Constant(8)
    );
    List<String> result = expr.getVariables().stream().toList();
    assertThat(result, containsInAnyOrder("i"));
  }
}
