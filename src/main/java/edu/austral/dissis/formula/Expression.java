package edu.austral.dissis.formula;

import java.util.Map;
import java.util.Set;


public sealed interface Expression
    permits Constant, Variable, Sum, Multiply, Substraction, Division, Power, Absolut, Sqrt {

  double evaluate(Map<String, Double> variableValues);


  String print();


  Set<String> getVariables();
}

