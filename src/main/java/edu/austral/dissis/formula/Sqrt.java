package edu.austral.dissis.formula;

import java.util.Map;
import java.util.Set;

public record Sqrt(Expression value) implements Expression {
  @Override
  public double evaluate(Map<String, Double> variableValues) {
    return Math.sqrt(value.evaluate(variableValues));
  }

  @Override
  public String print() {
    return "√(" + value.print() + ")";
  }

  @Override
  public Set<String> getVariables() {
    return value.getVariables();
  }
}
