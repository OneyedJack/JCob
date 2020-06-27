package jcob.bean.identification;

public class IdentificationAuthor implements IdentificationElement
{
  private String author;

  public IdentificationAuthor(String author)
  {
    super();
    this.author = author;
  }

  public String getAuthor()
  {
    return author;
  }

  public void setAuthor(String author)
  {
    this.author = author;
  }
  
  
}
