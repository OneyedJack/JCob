package jcob.bean.data;

public class DataDivision
{
  private FileSection fileSection;

  private WorkingStorageSection workingStorageSection;

  private LocalStorageSection localStorageSection;

  private LinkageSection linkageSection;

  private ScreenSection screenSection;

  public DataDivision(FileSection fileSection, WorkingStorageSection workingStorageSection, LocalStorageSection localStorageSection, LinkageSection linkageSection, ScreenSection screenSection)
  {
    super();
    this.fileSection = fileSection;
    this.workingStorageSection = workingStorageSection;
    this.localStorageSection = localStorageSection;
    this.linkageSection = linkageSection;
    this.screenSection = screenSection;
  }

  public FileSection getFileSection()
  {
    return fileSection;
  }

  public void setFileSection(FileSection fileSection)
  {
    this.fileSection = fileSection;
  }

  public WorkingStorageSection getWorkingStorageSection()
  {
    return workingStorageSection;
  }

  public void setWorkingStorageSection(WorkingStorageSection workingStorageSection)
  {
    this.workingStorageSection = workingStorageSection;
  }

  public LocalStorageSection getLocalStorageSection()
  {
    return localStorageSection;
  }

  public void setLocalStorageSection(LocalStorageSection localStorageSection)
  {
    this.localStorageSection = localStorageSection;
  }

  public LinkageSection getLinkageSection()
  {
    return linkageSection;
  }

  public void setLinkageSection(LinkageSection linkageSection)
  {
    this.linkageSection = linkageSection;
  }

  public ScreenSection getScreenSection()
  {
    return screenSection;
  }

  public void setScreenSection(ScreenSection screenSection)
  {
    this.screenSection = screenSection;
  }
  
  
}
