package edu.austral.dissis.formula;

import java.util.Map;
import java.util.Set;

public record Division(Expression left, Expression right) implements Expression {
  @Override
  public double evaluate(Map<String, Double> variableValues) {
    if (right.evaluate(variableValues) == 0) {
      throw new IllegalStateException("No se puede dividir por cero");
    }
    return left.evaluate(variableValues) / right.evaluate(variableValues);
  }

  @Override
  public String print() {
    return BinaryUtils.print(left, right, "/");
  }

  @Override
  public Set<String> getVariables() {
    return BinaryUtils.combineVariables(left, right);
  }
}
