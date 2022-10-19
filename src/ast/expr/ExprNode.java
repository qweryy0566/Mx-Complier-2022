package ast.expr;

import ast.*;
import utils.*;

public class ExprNode extends Node {
  public Type type;

  public ExprNode(Position pos) {
    super(pos);
  }

  public boolean isLeftValue() {
    return false;
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
};