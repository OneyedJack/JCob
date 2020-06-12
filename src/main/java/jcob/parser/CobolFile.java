package jcob.parser;

public class CobolFile extends Expression
{
  private Division currentDivision = null;
  
  private IdentificationDivision identificationDivision;

  private DataDivision dataDivision;

  private ProcedureDivision procedureDivision;

  @Override
  public int interpret()
  {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  protected void addLine(String lineCode)
  {
    if (isDivision(lineCode))
    {
      String[] tokenList = lineCode.split("\\s+");
      if (tokenList.length > 0)
      {
        switch (tokenList[0])
        {
        case "IDENTIFICATION":
          identificationDivision = new IdentificationDivision();
          currentDivision = identificationDivision;
          break;
        case "DATA":
          dataDivision = new DataDivision();
          currentDivision = dataDivision;
          break;
        case "PROCEDURE":
          procedureDivision = new ProcedureDivision();
          currentDivision = procedureDivision;
          break;
        default:
          break;
        }
      }
    }
    else if (currentDivision != null)
    {
      currentDivision.addLine(lineCode);
    }
    else
    {

    }
  }

  @Override
  public String toString()
  {
    StringBuffer sb = new StringBuffer("");
    sb.append(identificationDivision.toString());
    sb.append(" {\n");
    if (dataDivision != null)
    {
      sb.append(dataDivision.toString());
    }
    if (procedureDivision != null)
    {
      sb.append(procedureDivision.toString());
    }
    sb.append(" }\n");
    return sb.toString();
  }

  private static boolean isDivision(String s)
  {
    return s.contains("DIVISION");
  }
}
