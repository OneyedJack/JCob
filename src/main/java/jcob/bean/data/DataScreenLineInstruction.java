package jcob.bean.data;

public class DataScreenLineInstruction implements DataScreenInstruction
{
  private String value;

  public DataScreenLineInstruction(String value)
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
