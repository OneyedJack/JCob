package jcob.bean.procedure;

public class ProcedureRecord implements ProcedureEntry
{
  private String name;

  public ProcedureRecord(String name)
  {
    super();
    this.name = name;
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
