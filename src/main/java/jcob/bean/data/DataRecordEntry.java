package jcob.bean.data;

public class DataRecordEntry implements DataEntry
{
  private String level;
  
  private String name;

  public DataRecordEntry(String level, String name)
  {
    super();
    this.level = level;
    this.name = name;
  }

  public String getLevel()
  {
    return level;
  }

  public void setLevel(String level)
  {
    this.level = level;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }
  
  
}
