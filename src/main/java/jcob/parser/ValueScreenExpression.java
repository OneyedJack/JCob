package jcob.parser;

public class ValueScreenExpression extends ScreenExpression
{

  private String value;
  
  public ValueScreenExpression(String value)
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