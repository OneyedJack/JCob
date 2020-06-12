package jcob.parser;

public class PerformExpression extends Expression
{
  private String value;

  public PerformExpression(String lineCode)
  {
    String[] tokenList = lineCode.split("\\s+");
    if (tokenList.length > 1)
    {
      if (!tokenList[0].equals("PERFORM"))
      {
        return;
      }
      value = tokenList[1];
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
    sb.append("\t\t").append(value).append("();\n");
    return sb.toString();
  }
}
