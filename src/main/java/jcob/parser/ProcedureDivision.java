package jcob.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcedureDivision extends Division
{
  Map<String, List<Expression>> procedureMap = new HashMap<>();
  
  List<Expression> currentProcedure = null;
  
  String mainProcedure = null;
  
  protected void addLine(String lineCode)
  {
    String[] tokenList = lineCode.split("\\s+");
    if (tokenList.length > 0)
    {
      switch (tokenList[0])
      {
      case "MOVE":
        addProcedureExpression(new MoveExpression(lineCode));
        break;
      case "ADD":
        addProcedureExpression(new AddExpression(lineCode));
        break;
      case "DISPLAY":
        addProcedureExpression(new DisplayExpression(lineCode));
        break;
      case "PERFORM":
        addProcedureExpression(new PerformExpression(lineCode));
        break;
      case "GOBACK":
        addProcedureExpression(new GoBackExpression(lineCode));
        break;
      default:
        if (tokenList.length == 1)
        {
          currentProcedure = new ArrayList<>();
          procedureMap.put(tokenList[0], currentProcedure);
          if (mainProcedure == null)
          {
            mainProcedure = tokenList[0];
          }
        }
        break;
      }
    }
    else
    {

    }
  }
  
  private void addProcedureExpression(Expression expression)
  {
    if (currentProcedure == null)
    {
      currentProcedure = new ArrayList<>();
      mainProcedure = "main";
      procedureMap.put(mainProcedure, currentProcedure);
    }
    currentProcedure.add(expression);
  }

  @Override
  public String toString()
  {
    StringBuffer sb = new StringBuffer("");
    for (String key : procedureMap.keySet())
    {
      if (key.equals(mainProcedure))
      {
        sb.append("\tpublic ");
      }
      else
      {
        sb.append("\tprivate ");
      }
      sb.append(key).append("()\n\t{\n");
      List<Expression> procedure = procedureMap.get(key);
      procedure.forEach((expression) -> sb.append(expression.toString()));
      sb.append("\t}\n");
    }
    return sb.toString();
  }
}
