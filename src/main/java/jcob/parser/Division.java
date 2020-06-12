package jcob.parser;

public abstract class Division extends Expression
{
  protected Section currentSection = null;

  @Override
  public int interpret()
  {
    // TODO Auto-generated method stub
    return 0;
  }

  protected void addLine(String lineCode)
  {

  }

  protected static boolean isSection(String lineCode)
  {
    return lineCode.endsWith("SECTION");
  }

  protected static boolean isLabel(String lineCode)
  {
    String[] tokenList = lineCode.split("\\s+");
    return tokenList.length == 1 && !tokenList[0].equals("GOBACK");
  }
}
