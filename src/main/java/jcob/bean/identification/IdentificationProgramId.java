package jcob.bean.identification;

public class IdentificationProgramId implements IdentificationElement
{
  private String programId;

  public IdentificationProgramId(String programId)
  {
    super();
    this.programId = programId;
  }

  public String getProgramId()
  {
    return programId;
  }

  public void setProgramId(String programId)
  {
    this.programId = programId;
  }
  
  
}
