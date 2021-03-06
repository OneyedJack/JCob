package jcob.bean.data;

public class DataScreenValueInstruction implements DataScreenInstruction
{
  private String value;

  public DataScreenValueInstruction(String value)
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
