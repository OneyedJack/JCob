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

}
