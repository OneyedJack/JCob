package jcob.parser;

public class FromScreenExpression extends ScreenExpression
{

  private String value;
  
  public FromScreenExpression(String value)
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
    return value;
  }

}