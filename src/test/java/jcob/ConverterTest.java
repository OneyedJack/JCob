package jcob;

import static org.junit.Assert.assertTrue;

import java.io.Reader;
import java.io.StringReader;

import org.junit.After;
import org.junit.Test;

import jcob.bean.CobolFile;
import jcob.converter.JavaConverter;

public class ConverterTest
{
  private CobolLexer lexer;
  private CobolParser parser;
  private JavaConverter converter;
  private CobolFile cobolFile;
  private String javaConvertion;

  @After
  public void reset() {
    lexer = null;
    parser = null;
    converter = null;
    cobolFile = null;
    javaConvertion = null;
  }

  @Test
  public void convert_IdentificationDivisionProgramId() throws Exception {
    String program = "IDENTIFICATION DIVISION."
        + "PROGRAM-ID. Manipulation.";
    scan(program);
    parse();
    convert();
    assertTrue("public class Manipulation {\n}".equals(javaConvertion));
  }
  
  @Test
  public void convert_ProcedureDivisionRecords() throws Exception {
    String program = "IDENTIFICATION DIVISION."
        + "PROGRAM-ID. Manipulation."
        + ""
        + "DATA DIVISION."
        + "WORKING-STORAGE SECTION."
        + "77 a PIC 99."
        + "PROCEDURE DIVISION."
        + "MAIN-PROCEDURE."
        + "MOVE 5 TO a."
        + ""
        + "SECOND-PROCEDURE."
        + "MOVE 5 TO a."
        + "";
    scan(program);
    parse();
    convert();
    //assertTrue("public class Manipulation {\n}".equals(javaConvertion));
  }

  private void scan(String input) {
    Reader in = new StringReader(input);
    lexer = new CobolLexer(in);
  }
  
  private void parse() {
    parser = new CobolParser(lexer);
    try
    {
      cobolFile = (CobolFile)parser.parse().value;
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  private void convert() {
    converter = new JavaConverter(cobolFile);
    javaConvertion = converter.convert();
    System.out.println(javaConvertion);
  }
}
