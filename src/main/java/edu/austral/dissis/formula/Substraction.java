package edu.austral.dissis.formula;

import java.util.Map;
import java.util.Set;

public record Substraction(Expression left, Expression right) implements Expression {
  @Override
  public double evaluate(Map<String, Double> variableValues) {
    return left.evaluate(variableValues) - right.evaluate(variableValues);
  }

  @Override
  public String print() {
    return BinaryUtils.print(left, right, "-");
  }

  @Override
  public Set<String> getVariables() {
    return BinaryUtils.combineVariables(left, right);
  }
}
