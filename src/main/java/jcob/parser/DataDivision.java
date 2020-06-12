package jcob.parser;

public class DataDivision extends Division
{
  private WorkingStorageSection workingStorageSection;

  private ScreenSection screenSection;

  protected void addLine(String lineCode)
  {
    if (isSection(lineCode))
    {
      String[] tokenList = lineCode.split("\\s+");
      if (tokenList.length > 0)
      {
        switch (tokenList[0])
        {
        case "WORKING-STORAGE":
          workingStorageSection = new WorkingStorageSection();
          currentSection = workingStorageSection;
          break;
        case "SCREEN":
          screenSection = new ScreenSection();
          currentSection = screenSection;
          break;
        default:
          break;
        }
      }
    }
    else if (currentSection != null)
    {
      currentSection.addLine(lineCode);
    }
    else
    {

    }
  }
  
  @Override
  public String toString()
  {
    StringBuffer sb = new StringBuffer("");
    if (workingStorageSection != null)
    {
      sb.append(workingStorageSection.toString());
      sb.append("\n");
    }
    if (screenSection != null)
    {
      sb.append(screenSection.toString());
    }
    return sb.toString();
  }
}
