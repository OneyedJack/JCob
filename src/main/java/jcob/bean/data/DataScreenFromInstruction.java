package jcob.bean.data;

public class DataScreenFromInstruction implements DataScreenInstruction
{
  private String value;

  public DataScreenFromInstruction(String value)
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
