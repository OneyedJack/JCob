package jcob.bean.identification;

import java.util.List;

public class IdentificationDivision
{
  List<IdentificationElement> identificationElements;

  public IdentificationDivision(List<IdentificationElement> identificationElements)
  {
    super();
    this.identificationElements = identificationElements;
  }

  public List<IdentificationElement> getIdentificationElements()
  {
    return identificationElements;
  }

  public void setIdentificationElements(List<IdentificationElement> identificationElements)
  {
    this.identificationElements = identificationElements;
  }
  
  public String getProgramId()
  {
    IdentificationElement ie = identificationElements.stream().filter(e -> e instanceof IdentificationProgramId).findFirst().orElse(null);
    if (ie != null)
    {
      return ((IdentificationProgramId)ie).getProgramId();
    }
    return "Program";
  }
}
