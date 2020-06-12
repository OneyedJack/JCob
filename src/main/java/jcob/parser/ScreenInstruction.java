package jcob.parser;

import java.util.ArrayList;

public class ScreenInstruction extends Expression
{
  private ArrayList<ScreenExpression> expressions = new ArrayList<>();

  private String title;
  
  private String level;
  
  public ScreenInstruction(String lineCode)
  {
    String[] tokenList = lineCode.split("\\s+");
    if (tokenList.length > 0)
    {
      level = tokenList[0];
      for (int i = 1; i < tokenList.length; i++)
      {
        switch (tokenList[i])
        {
        case "LINE":
          expressions.add(new LineScreenExpression(tokenList[++i]));
          break;
        case "COL":
        case "COLUMN":
          expressions.add(new ColumnScreenExpression(tokenList[++i]));
          break;
        case "VALUE":
          expressions.add(new ValueScreenExpression(tokenList[++i]));
          break;
        case "FROM":
          expressions.add(new FromScreenExpression(tokenList[++i]));
          break;
        case "PIC":
          ++i;
          //expressions.add(new ValueScreenExpression(tokenList[++i]));
          break;
        default:
          title = tokenList[i];
          break;
        }          
      }
    }
  }

  @Override
  public int interpret()
  {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  protected void addLine(String lineCode)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public String toString()
  {
    StringBuffer sb = new StringBuffer("");
    sb.append("\t\t");
    if (isTitleInstruction())
    {
      sb.append(title).append("();");
    }
    else
    {
      for (ScreenExpression se : expressions)
      {
        if (se instanceof ValueScreenExpression)
        {
          sb.append("System.out.print(\"").append(((ValueScreenExpression) se).toString()).append("\");");
        }
        else if (se instanceof FromScreenExpression)
        {
          sb.append("System.out.print(").append(((FromScreenExpression) se).toString()).append(");");
        }
      }
    }
    sb.append("\n");
    return sb.toString();
  }
  
  public String getTitle()
  {
    return title;
  }

  public String getLevel()
  {
    return level;
  }
  
  public boolean isTitleInstruction()
  {
    return title != null && !"".equals(title);
  }
}
