package IR.entity;

import utils.*;
import IR.type.*;

public class IRBoolConst extends IRConst {
  public boolean val;

  public IRBoolConst(boolean val) {
    super(irBoolType);
    this.val = val;
  }
}