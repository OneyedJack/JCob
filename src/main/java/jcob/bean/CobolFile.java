package jcob.bean;

import jcob.bean.data.DataDivision;
import jcob.bean.environment.EnvironmentDivision;
import jcob.bean.identification.IdentificationDivision;
import jcob.bean.procedure.ProcedureDivision;

public class CobolFile
{
  private IdentificationDivision identificationDivision;

  private EnvironmentDivision environmentDivision;

  private DataDivision dataDivision;

  private ProcedureDivision procedureDivision;

  public CobolFile(IdentificationDivision identificationDivision, EnvironmentDivision environmentDivision, DataDivision dataDivision, ProcedureDivision procedureDivision)
  {
    super();
    this.identificationDivision = identificationDivision;
    this.environmentDivision = environmentDivision;
    this.dataDivision = dataDivision;
    this.procedureDivision = procedureDivision;
  }

  public IdentificationDivision getIdentificationDivision()
  {
    return identificationDivision;
  }

  public void setIdentificationDivision(IdentificationDivision identificationDivision)
  {
    this.identificationDivision = identificationDivision;
  }

  public EnvironmentDivision getEnvironmentDivision()
  {
    return environmentDivision;
  }

  public void setEnvironmentDivision(EnvironmentDivision environmentDivision)
  {
    this.environmentDivision = environmentDivision;
  }

  public DataDivision getDataDivision()
  {
    return dataDivision;
  }

  public void setDataDivision(DataDivision dataDivision)
  {
    this.dataDivision = dataDivision;
  }

  public ProcedureDivision getProcedureDivision()
  {
    return procedureDivision;
  }

  public void setProcedureDivision(ProcedureDivision procedureDivision)
  {
    this.procedureDivision = procedureDivision;
  }
}
