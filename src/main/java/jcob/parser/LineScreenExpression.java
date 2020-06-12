package jcob.parser;

public class LineScreenExpression extends ScreenExpression
{

  private String value;
  
  public LineScreenExpression(String value)
  {
    this.value = value;
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
    return "LINE " + value;
  }

}
