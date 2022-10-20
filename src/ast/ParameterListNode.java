package ast;

import utils.*;
import ast.stmt.*;
import ast.expr.*;
import java.util.ArrayList;

public class ParameterListNode extends Node {
  public ArrayList<VarDefUnitNode> units = new ArrayList<VarDefUnitNode>();

  public ParameterListNode(Position pos) {
    super(pos);
  }
  public ParameterListNode(Position pos, Type type) {
    super(pos);
    units.add(new VarDefUnitNode(pos, new TypeNode(pos, type.typeName, type.dim), "in"));
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
