package jcob.bean.data;

import java.util.List;

public class WorkingStorageSection
{
  List<DataEntry> DataEntrys;

  public WorkingStorageSection(List<DataEntry> dataEntrys)
  {
    super();
    DataEntrys = dataEntrys;
  }

  public List<DataEntry> getDataEntrys()
  {
    return DataEntrys;
  }

  public void setDataEntrys(List<DataEntry> dataEntrys)
  {
    DataEntrys = dataEntrys;
  }

}
