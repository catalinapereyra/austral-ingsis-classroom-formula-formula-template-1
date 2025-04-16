package edu.austral.dissis.formula;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public record Variable(String name) implements Expression {

  @Override
  public double evaluate(Map<String, Double> variableValues) {
    if (!variableValues.containsKey(name)) {
      throw new RuntimeException("No se encontro el valor para la variable: " + name);
    }
    return variableValues.get(name);
  }

  @Override
  public String print() {
    return name;
  }

  @Override
  public Set<String> getVariables() {
    return Collections.singleton(name);
  }
}
