package jcob;

import java.io.StringReader;

import java_cup.runtime.Symbol;

public class Main
{
  private static String program = ""
      + "IDENTIFICATION DIVISION.\r\n" + 
      "PROGRAM-ID. Manipulation."
      + "AUTHOR. auteur."
      + "DATA DIVISION."
      + "WORKING-STORAGE SECTION."
      + "77 a PIC 99."
      + "SCREEN SECTION.";
  
  public static void main(String[] args)
  {
    try {
      //System.out.println("Parsing [" + program + "]");
      CobolLexer s = new CobolLexer(new StringReader(program));
      CobolParser p = new CobolParser(s);
      //Object  result = p.debug_parse();
      Symbol result = p.parse();
      System.out.println(result.value);
      System.out.println("No errors.");
    } catch (Exception e) {
      e.printStackTrace(System.err);
      System.exit(1);
    }
  }
}
