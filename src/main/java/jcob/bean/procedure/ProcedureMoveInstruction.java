package jcob.bean.procedure;

public class ProcedureMoveInstruction implements ProcedureInstruction
{
  private String fromValue;
  
  private String toValue;

  public ProcedureMoveInstruction(String fromValue, String toValue)
  {
    super();
    this.fromValue = fromValue;
    this.toValue = toValue;
  }

  public String getFromValue()
  {
    return fromValue;
  }

  public void setFromValue(String fromValue)
  {
    this.fromValue = fromValue;
  }

  public String getToValue()
  {
    return toValue;
  }

  public void setToValue(String toValue)
  {
    this.toValue = toValue;
  }
}
