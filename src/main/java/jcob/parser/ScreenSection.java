package jcob.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ScreenSection extends Section
{
  Map<String, List<ScreenInstruction>> screenMap = new HashMap<>();
  
  Stack<ScreenInstruction> screenTitleStack = new Stack<>();

  @Override
  protected void addLine(String lineCode)
  {
    ScreenInstruction screenInstruction = new ScreenInstruction(lineCode);
    if (screenInstruction.isTitleInstruction())
    {
      if (indentationExist(screenInstruction))
      {
        while ((screenTitleStack.pop()).getLevel().equals(screenInstruction.getLevel()));
      }
      if (screenTitleStack.size() > 0)
      {
        List<ScreenInstruction> screen = screenMap.get(screenTitleStack.lastElement().getTitle());
        screen.add(screenInstruction);
      }
      screenTitleStack.push(screenInstruction);
      screenMap.put(screenInstruction.getTitle(), new ArrayList<>());
    }
    else
    {
      List<ScreenInstruction> currentScreen = screenMap.get(screenTitleStack.lastElement().getTitle());
      currentScreen.add(screenInstruction);
    }
  }

  @Override
  public String toString()
  {
    StringBuffer sb = new StringBuffer("");
    for (String key : screenMap.keySet())
    {
      sb.append("\tprivate void ").append(key).append("()\n\t{\n");
      List<ScreenInstruction> screenInstructions = screenMap.get(key);
      screenInstructions.forEach((instruction) -> sb.append(instruction.toString()));
      sb.append("\t}\n\n");
    }
    return sb.toString();
  }

  private boolean indentationExist(ScreenInstruction st)
  {
    for (ScreenInstruction element : screenTitleStack)
    {
      if (element.getLevel().equals(st.getLevel()))
      {
        return true;
      }
    }
    return false;
  }
}
