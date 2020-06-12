package jcob.parser;

public class GoBackExpression extends Expression
{

  public GoBackExpression(String lineCode)
  {
    String[] tokenList = lineCode.split("\\s+");
    if (tokenList.length > 0)
    {
      if (!tokenList[0].equals("GOBACK"))
      {
        return;
      }
    }
  }

  @Override
  public int interpret()
  {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  protected void addLine(String lineCode)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public String toString()
  {
    StringBuffer sb = new StringBuffer("");
    sb.append("\t\t").append("return;\n");
    return sb.toString();
  }
}
