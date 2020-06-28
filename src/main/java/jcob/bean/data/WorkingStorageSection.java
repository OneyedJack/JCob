package jcob.bean.data;

import java.util.List;

public class WorkingStorageSection
{
  List<DataEntry> dataEntrys;

  public WorkingStorageSection(List<DataEntry> dataEntrys)
  {
    super();
    this.dataEntrys = dataEntrys;
  }

  public List<DataEntry> getDataEntrys()
  {
    return dataEntrys;
  }

  public void setDataEntrys(List<DataEntry> dataEntrys)
  {
    this.dataEntrys = dataEntrys;
  }

}
