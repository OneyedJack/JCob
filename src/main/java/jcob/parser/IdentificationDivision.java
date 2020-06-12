package jcob.parser;

public class IdentificationDivision extends Division
{
  public boolean identification = false;
  
  public String name;

  @Override
  protected void addLine(String lineCode)
  {
    if (identification)
    {
      name = lineCode;
      identification = false;
    }
    switch (lineCode)
    {
    case "PROGRAM-ID":
      identification = true;
      break;
    default:
      break;
    }
  }
  
  @Override
  public String toString()
  {
    return "public class " + name;
  }
}
