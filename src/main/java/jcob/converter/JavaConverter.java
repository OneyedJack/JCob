package jcob.converter;

import java.util.List;
import java.util.Map;

import jcob.bean.CobolFile;
import jcob.bean.data.DataElement;
import jcob.bean.data.DataEntry;
import jcob.bean.procedure.ProcedureAddInstruction;
import jcob.bean.procedure.ProcedureInstruction;
import jcob.bean.procedure.ProcedureMoveInstruction;

public class JavaConverter
{
  private CobolFile file;

  public JavaConverter(CobolFile file)
  {
    super();
    this.file = file;
  }
  
  public String convert()
  {
    StringBuffer sb = new StringBuffer();
    sb.append(generatePackage(file));
    sb.append(generateImport(file));
    sb.append(generateClassBody(file));
    return sb.toString();
  }


  private String generatePackage(CobolFile file)
  {
    return "";
  }

  private String generateImport(CobolFile file)
  {
    return "";
  }

  private String generateClassBody(CobolFile file)
  {
    StringBuffer sb = new StringBuffer();
    sb.append("public class ").append(formatCamelCase(file.getIdentificationDivision().getProgramId()));
    sb.append(" {\n");
    sb.append(generateWorkingStorage(file));
    sb.append(generateProcedure(file));
    sb.append("}");
    return sb.toString();
  }

  private Object generateWorkingStorage(CobolFile file2)
  {
    if (file == null || file.getDataDivision() == null || file.getDataDivision().getWorkingStorageSection() == null)
    {
      return "";
    }
    StringBuffer sb = new StringBuffer();
    for (DataEntry de : file.getDataDivision().getWorkingStorageSection().getDataEntrys())
    {
      if (de instanceof DataElement)
      {
        DataElement dataElement = (DataElement) de;
        sb.append("\tprivate ").append(getType(dataElement.getType())).append(" ").append(formatLowerCamelCase(dataElement.getName())).append(";\n");
      }
    }
    sb.append("\n");
    return sb.toString();
  }

  private String generateProcedure(CobolFile file)
  {
    if (file == null || file.getProcedureDivision() == null)
    {
      return "";
    }
    Map<String, List<ProcedureInstruction>> procedureMap = file.getProcedureDivision().getProcedureMap();
    StringBuffer sb = new StringBuffer();
    for (String key : procedureMap.keySet())
    {
      sb.append("\tpublic ").append(formatLowerCamelCase(key)).append("()\n\t{\n");
      List<ProcedureInstruction> procedure = procedureMap.get(key);
      procedure.forEach((instruction) -> sb.append("\t\t").append(generateProcedureInstruction(instruction)).append("\n"));
      sb.append("\t}\n\n");
    }
    return sb.toString();
  }

  private String generateProcedureInstruction(ProcedureInstruction instruction)
  {
    if (instruction == null)
    {
      return "";
    }
    StringBuffer sb = new StringBuffer();
    if (instruction instanceof ProcedureAddInstruction)
    {
      ProcedureAddInstruction addInstruction = (ProcedureAddInstruction) instruction;
      sb.append(addInstruction.getToValue()).append(" = ").append(addInstruction.getToValue()).append(" + ").append(addInstruction.getFromValue()).append(";");
    }
    else if (instruction instanceof ProcedureMoveInstruction)
    {
      ProcedureMoveInstruction moveInstruction = (ProcedureMoveInstruction) instruction;
      sb.append(moveInstruction.getToValue()).append(" = ").append(moveInstruction.getFromValue()).append(";");
    }
    return sb.toString();
  }
  
  private String formatLowerCamelCase(String name)
  {
    if (!name.contains("-"))
    {
      return name.toLowerCase();
    }
    String[] procedureNames = name.split("-");
    StringBuffer result = new StringBuffer(procedureNames[0].toLowerCase());
    for (int i = 1; i < procedureNames.length; i++)
    {
      if (procedureNames[i].length() > 0)
      {
        result.append(procedureNames[i].substring(0, 1).toUpperCase());
      }
      if (procedureNames[i].length() > 1)
      {
        result.append(procedureNames[i].substring(1).toLowerCase());
      }
    }
    return result.toString();
  }

  private String formatCamelCase(String name)
  {
    String[] names = name.split("-");
    StringBuffer result = new StringBuffer();
    for (int i = 0; i < names.length; i++)
    {
      if (names[i].length() > 0)
      {
        result.append(names[i].substring(0, 1).toUpperCase());
      }
      if (names[i].length() > 1)
      {
        result.append(names[i].substring(1).toLowerCase());
      }
    }
    return result.toString();
  }
  
  private String getType(String type)
  {
    type = type.toLowerCase();
    if (type.startsWith("9") || type.startsWith("s"))
    {
      if (type.contains("v"))
      {
        return "Double";
      }
      else
      {
        return "Integer";
      }
    }
    else if (type.startsWith("a") || type.startsWith("x"))
    {
      return "String";
    }
    return "Object";
  }

}
