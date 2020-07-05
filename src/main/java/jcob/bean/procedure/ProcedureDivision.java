package jcob.bean.procedure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProcedureDivision
{
  List<ProcedureEntry> procedureEntrys;

  public ProcedureDivision()
  {
    super();
  }

  public ProcedureDivision(List<ProcedureEntry> procedureEntrys)
  {
    super();
    this.procedureEntrys = procedureEntrys;
  }

  public List<ProcedureEntry> getProcedureEntrys()
  {
    return procedureEntrys;
  }

  public void setProcedureEntrys(List<ProcedureEntry> procedureEntrys)
  {
    this.procedureEntrys = procedureEntrys;
  }
  
  public Map<String, List<ProcedureInstruction>> getProcedureMap()
  {
    List<ProcedureInstruction> currentInstructionList = null;
    Map<String, List<ProcedureInstruction>> result = new HashMap<>();
    for (ProcedureEntry pe : procedureEntrys)
    {
      if (pe instanceof ProcedureRecord)
      {
        currentInstructionList = new LinkedList<>();
        result.put(((ProcedureRecord) pe).getName(), currentInstructionList);
      }
      else if (pe instanceof ProcedureInstruction)
      {
        if (currentInstructionList == null)
        {
          currentInstructionList = new LinkedList<>();
          result.put("main", currentInstructionList);
        }
        currentInstructionList.add((ProcedureInstruction) pe);
      }
    }
    return result;
  }
}
