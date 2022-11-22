package IR;

import IR.inst.*;
import java.util.LinkedList;
import java.util.ArrayList;

public class IRBasicBlock {
  public String name;
  public LinkedList<IRInst> insts = new LinkedList<IRInst>();
  public IRTerminalInst terminalInst = null;
  public IRFunction parentFunction = null;
  public ArrayList<IRBasicBlock> pres = new ArrayList<IRBasicBlock>(), succs = new ArrayList<IRBasicBlock>();
  public boolean isFinished = false;

  public static int blockCnt = 0;

  public IRBasicBlock(IRFunction function, String name) {
    this.parentFunction = function;
    this.name = name + String.valueOf(blockCnt++);
  }
  public IRBasicBlock(IRFunction function, String name, IRBasicBlock toBlock) {
    this.parentFunction = function;
    this.name = name + String.valueOf(blockCnt++);
    this.terminalInst = new IRJumpInst(this, toBlock);
  }
  
  public void addInst(IRInst inst) {
    if (isFinished) return;
    if (inst instanceof IRAllocaInst)
      parentFunction.allocaInsts.add((IRAllocaInst) inst);
    else if (inst instanceof IRTerminalInst)
      terminalInst = (IRTerminalInst) inst;
    else
      insts.add(inst);
  }
  public String toString() {
    return "";
  }
}