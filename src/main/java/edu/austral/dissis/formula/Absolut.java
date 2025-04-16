package edu.austral.dissis.formula;

import java.util.Map;
import java.util.Set;

public record Absolut(Expression value) implements Expression {
  @Override
  public double evaluate(Map<String, Double> variableValues) {
    return Math.abs(value.evaluate(variableValues));
  }

  @Override
  public String print() {
    return "|" + value.print() + "|";
  }

  @Override
  public Set<String> getVariables() {
    return value.getVariables();
  }
}
