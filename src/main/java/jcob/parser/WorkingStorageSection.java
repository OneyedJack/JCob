package jcob.parser;

import java.util.ArrayList;

public class WorkingStorageSection extends Section
{

  ArrayList<Variable> variables = new ArrayList<>();
  
  @Override
  protected void addLine(String lineCode)
  {
    if (isVariable(lineCode)) {
      variables.add(new Variable(lineCode));
    } else {
      
    }

  }
  
  private static boolean isVariable(String s) {
    String[] tokenList = s.split("\\s+");
    return tokenList.length > 2 && tokenList[2].equals("PIC");
  }
  
  @Override
  public String toString()
  {
    StringBuffer sb = new StringBuffer("");
    variables.forEach((variable) -> sb.append("\tprivate ").append(variable.toString()).append(";\n"));
    return sb.toString();
  }
}
