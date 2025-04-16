package edu.austral.dissis.formula;

import java.util.HashSet;
import java.util.Set;

public class BinaryUtils {
  public static Set<String> combineVariables(Expression left, Expression right) {
    Set<String> vars = new HashSet<>(left.getVariables());
    vars.addAll(right.getVariables());
    return vars;
  }

  public static String print(Expression left, Expression right, String op) {
    String leftStr = left.print();
    String rightStr = right.print();

    boolean leftNeedsParens = left instanceof Sum || left instanceof Substraction || left instanceof Division;
    boolean rightNeedsParens = right instanceof Sum || right instanceof Substraction;

    if (op.equals("*")) {
      if (leftNeedsParens) leftStr = "(" + leftStr + ")";
      if (rightNeedsParens) rightStr = "(" + rightStr + ")";
    } else if (op.equals("^")) {
      if (!(left instanceof Constant || left instanceof Variable || left instanceof Sqrt || left instanceof Absolut))
        leftStr = "(" + leftStr + ")";
      if (!(right instanceof Constant || right instanceof Variable))
        rightStr = "(" + rightStr + ")";
    } else if (op.equals("/")) {
      if (!(left instanceof Constant || left instanceof Variable)) leftStr = "(" + leftStr + ")";
      if (!(right instanceof Constant || right instanceof Variable)) rightStr = "(" + rightStr + ")";
    } else if (op.equals("-")) {
      if (leftNeedsParens) leftStr = "(" + leftStr + ")";
      if (rightNeedsParens) rightStr = "(" + rightStr + ")";
    }

    return leftStr + " " + op + " " + rightStr;
  }

}
