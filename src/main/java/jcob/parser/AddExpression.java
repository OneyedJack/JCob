package jcob.parser;

public class AddExpression extends Expression
{
  private String dest;
  
  private String value;
  
  public AddExpression(String lineCode)
  {
    String[] tokenList = lineCode.split("\\s+");
    if (tokenList.length > 3)
    {
      if (!tokenList[0].equals("ADD") || !tokenList[2].equals("TO"))
      {
        return;
      }
      value = tokenList[1];
      dest = tokenList[3];
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
    sb.append("\t\t").append(dest).append(" = ").append(dest).append(" + ").append(value).append(";\n");
    return sb.toString();
  }

}
