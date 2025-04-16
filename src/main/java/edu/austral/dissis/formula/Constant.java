package edu.austral.dissis.formula;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public record Constant(double value) implements Expression {

  @Override
  public double evaluate(Map<String, Double> variableValues) {
    return value;
  }

  @Override
  public String print() {
    if (value == (long) value) return String.valueOf((long) value);
    return String.valueOf(value);
  }

  @Override
  public Set<String> getVariables() {
    return Collections
        .emptySet();
  }
}
