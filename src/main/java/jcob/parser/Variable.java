package jcob.parser;

public class Variable extends Expression
{
  private int indentation;
  private String name;
  private Type type;

  public Variable(String lineCode)
  {
    if (lineCode == null)
    {
      return;
    }
    String[] tokenList = lineCode.split("\\s+");
    if (tokenList.length > 0)
    {
      indentation = Integer.parseInt(tokenList[0]);
    }
    if (tokenList.length > 1)
    {
      name = tokenList[1];
    }
    String[] picTokenList = lineCode.split("PIC");
    if (picTokenList.length > 1)
    {
      type = new Type(picTokenList[1]);
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
    sb.append(type).append(" ").append(name);
    return sb.toString();
  }

}
