package jcob.bean.data;

public class DataScreenPicInstruction implements DataScreenInstruction
{
  private String type;

  public DataScreenPicInstruction(String type)
  {
    super();
    this.type = type;
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }
}

