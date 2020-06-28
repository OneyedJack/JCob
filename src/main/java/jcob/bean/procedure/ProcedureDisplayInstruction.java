package jcob.bean.procedure;

public class ProcedureDisplayInstruction implements ProcedureInstruction
{
  private String mnemonicName;

  public ProcedureDisplayInstruction(String mnemonicName)
  {
    super();
    this.mnemonicName = mnemonicName;
  }

  String getMnemonicName()
  {
    return mnemonicName;
  }

  void setMnemonicName(String mnemonicName)
  {
    this.mnemonicName = mnemonicName;
  }
}
