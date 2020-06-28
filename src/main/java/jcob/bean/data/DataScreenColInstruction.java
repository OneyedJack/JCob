package jcob.bean.data;

public class DataScreenColInstruction implements DataScreenInstruction
{
  private String value;

  public DataScreenColInstruction(String value)
  {
    super();
    this.value = value;
  }

  public String getValue()
  {
    return value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }
}
