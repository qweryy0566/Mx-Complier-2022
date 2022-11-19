package IR.inst;

import utils.*;
import ast.*;
import ast.stmt.*;
import ast.expr.*;
import IR.*;

public class IRBranchInst extends IRTerminalInst {
  public IREntity cond;
  public IRBasicBlock thenBlock;
  public IRBasicBlock elseBlock;

  public IRBranchInst(IREntity cond, IRBasicBlock thenBlock, IRBasicBlock elseBlock) {
    super();
    this.cond = cond;
    this.thenBlock = thenBlock;
    this.elseBlock = elseBlock;
  }
  public String toString() {
    return "";
  }
}