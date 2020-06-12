package jcob.parser;

public class Type extends Expression
{
  // TODO
  private String type;

  public Type(String lineCode)
  {
    if (lineCode == null)
    {
      return;
    }
    lineCode = lineCode.trim().toLowerCase();
    if (lineCode.startsWith("9") || lineCode.startsWith("s"))
    {
      if (lineCode.contains("v"))
      {
        type = "Double";
      }
      else
      {
        type = "Integer";
      }
    }
    else if (lineCode.startsWith("a") || lineCode.startsWith("x"))
    {
      type = "String";
    }
    else
    {
      type = "Object";
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
    return type;
  }

}
