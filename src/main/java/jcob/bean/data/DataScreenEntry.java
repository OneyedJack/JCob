package jcob.bean.data;

import java.util.List;

public class DataScreenEntry implements DataEntry
{
  private String level;
  
  private List<DataScreenInstruction> dataScreenElements;

  public DataScreenEntry(String level, List<DataScreenInstruction> dataScreenElements)
  {
    super();
    this.level = level;
    this.dataScreenElements = dataScreenElements;
  }

  public String getLevel()
  {
    return level;
  }

  public void setLevel(String level)
  {
    this.level = level;
  }

  public List<DataScreenInstruction> getDataScreenElements()
  {
    return dataScreenElements;
  }

  public void setDataScreenElements(List<DataScreenInstruction> dataScreenElements)
  {
    this.dataScreenElements = dataScreenElements;
  }
}
