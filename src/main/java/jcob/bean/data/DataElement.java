package jcob.bean.data;

public class DataElement implements DataEntry
{
  private String level;
  
  private String name;
  
  private String type;

  public DataElement(String level, String name, String type)
  {
    super();
    this.level = level;
    this.name = name;
    this.type = type;
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

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }
  
  
}
