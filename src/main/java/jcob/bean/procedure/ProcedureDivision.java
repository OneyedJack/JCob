package jcob.bean.procedure;

import java.util.List;

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
}
