package IR;

import IR.entity.*;
import IR.type.*;
import utils.BuiltinElements;

import java.util.ArrayList;
import java.util.HashMap;

public class IRProgram implements BuiltinElements {
  public ArrayList<IRFunction> funcList = new ArrayList<IRFunction>();
  public ArrayList<IRGlobalVar> globalVarList = new ArrayList<IRGlobalVar>();
  public ArrayList<IRStructType> structTypeList = new ArrayList<IRStructType>();

  public HashMap<String, IRStringConst> stringConst = new HashMap<>();

  public IRFunction initFunc = new IRFunction("__global_var_init", irVoidType);
  public IRBasicBlock initEntry = new IRBasicBlock(initFunc, "entry");

  public IRProgram() {
    initFunc.appendBlock(initEntry);
  }

  public IRStringConst addStringConst(String str) {
    if (!stringConst.containsKey(str))
      stringConst.put(str, new IRStringConst(str));
    return stringConst.get(str);
  }

  @Override
  public String toString() {
    String ret = "";
    for (IRStructType structType : structTypeList) {
      ret += structType + " = type {";
      for (int i = 0; i < structType.memberType.size(); ++i) {
        ret += structType.memberType.get(i);
        if (i != structType.memberType.size() - 1) ret += ", ";
      }
      ret += "}\n";
    }
    ret += "\n";
    for (IRStringConst str : stringConst.values())
      ret += "@str." + String.valueOf(str.id) + " = private unnamed_addr constant [" + String.valueOf(str.val.length() + 1) + " x i8] c\"" + str.val + "\\00\"\n";
    ret += "\n";
    for (IRGlobalVar globalVar : globalVarList)
      ret += globalVar + " = global " + ((IRPtrType) globalVar.type).pointToType() + " " + globalVar.initVal + "\n";
    ret += "\n";
    if (initFunc != null)
      ret += initFunc + "\n";
    for (IRFunction func : funcList)
      ret += func + "\n";
    return ret;
  }
}