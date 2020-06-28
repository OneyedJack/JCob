package jcob;

import static org.junit.Assert.assertTrue;

import java.io.Reader;
import java.io.StringReader;

import org.junit.After;
import org.junit.Test;

import jcob.bean.CobolFile;
import jcob.bean.data.DataElement;
import jcob.bean.data.DataEntry;
import jcob.bean.data.DataRecord;
import jcob.bean.data.DataScreenEntry;
import jcob.bean.data.DataScreenInstruction;
import jcob.bean.data.DataScreenLineInstruction;
import jcob.bean.identification.IdentificationAuthor;
import jcob.bean.identification.IdentificationElement;
import jcob.bean.identification.IdentificationProgramId;

/**
 * Test for the generated {@link CobolParser}.
 */
public class ParserTest {

  private CobolLexer lexer;
  private CobolParser parser;
  private CobolFile cobolFile;

  @After
  public void resetLexer() {
    lexer = null;
    parser = null;
    cobolFile = null;
  }

  @Test
  public void parse_IdentificationDivition() throws Exception {
    scan("IDENTIFICATION DIVISION.");
    parse();
    assertTrue(cobolFile != null);
    assertTrue(cobolFile.getIdentificationDivision() != null);
  }
  
  @Test
  public void parse_IdentificationDivitionProgramId() throws Exception {
    String program = "IDENTIFICATION DIVISION."
        + "PROGRAM-ID. Manipulation.";
    scan(program);
    parse();
    assertTrue(cobolFile != null);
    assertTrue(cobolFile.getIdentificationDivision() != null && cobolFile.getIdentificationDivision().getIdentificationElements() != null && cobolFile.getIdentificationDivision().getIdentificationElements().size() == 1);
    IdentificationElement ie = cobolFile.getIdentificationDivision().getIdentificationElements().get(0);
    assertTrue(ie instanceof IdentificationProgramId);
    IdentificationProgramId ipi = (IdentificationProgramId)ie;
    assertTrue("Manipulation".equals(ipi.getProgramId()));
  }

  @Test
  public void parse_IdentificationDivitionAuthor() throws Exception {
    String program = "IDENTIFICATION DIVISION."
        + "AUTHOR. Xavier.";
    scan(program);
    parse();
    assertTrue(cobolFile != null);
    assertTrue(cobolFile.getIdentificationDivision() != null && cobolFile.getIdentificationDivision().getIdentificationElements() != null && cobolFile.getIdentificationDivision().getIdentificationElements().size() == 1);
    IdentificationElement ie = cobolFile.getIdentificationDivision().getIdentificationElements().get(0);
    assertTrue(ie instanceof IdentificationAuthor);
    IdentificationAuthor ia = (IdentificationAuthor)ie;
    assertTrue("Xavier".equals(ia.getAuthor()));
  }

  @Test
  public void parse_IdentificationDivitionProgramIdAuthor() throws Exception {
    String program = "IDENTIFICATION DIVISION."
        + "PROGRAM-ID. Manipulation."
        + "AUTHOR. Xavier.";
    scan(program);
    parse();
    assertTrue(cobolFile != null);
    assertTrue(cobolFile.getIdentificationDivision() != null && cobolFile.getIdentificationDivision().getIdentificationElements() != null && cobolFile.getIdentificationDivision().getIdentificationElements().size() == 2);
    IdentificationElement ie1 = cobolFile.getIdentificationDivision().getIdentificationElements().get(0);
    assertTrue(ie1 instanceof IdentificationProgramId);
    IdentificationProgramId ipi = (IdentificationProgramId)ie1;
    assertTrue("Manipulation".equals(ipi.getProgramId()));
    IdentificationElement ie2 = cobolFile.getIdentificationDivision().getIdentificationElements().get(1);
    assertTrue(ie2 instanceof IdentificationAuthor);
    IdentificationAuthor ia = (IdentificationAuthor)ie2;
    assertTrue("Xavier".equals(ia.getAuthor()));
  }

  @Test
  public void parse_DataDivition() throws Exception {
    String program = "DATA DIVISION.";
    scan(program);
    parse();
    assertTrue(cobolFile != null);
    assertTrue(cobolFile.getDataDivision() != null);
  }

  @Test
  public void parse_DataDivitionScreenSection() throws Exception {
    String program = "DATA DIVISION."
        + "SCREEN SECTION.";
    scan(program);
    parse();
    assertTrue(cobolFile != null);
    assertTrue(cobolFile.getDataDivision() != null && cobolFile.getDataDivision().getScreenSection() != null);
  }

  @Test
  public void parse_DataDivitionScreenSection2() throws Exception {
    String program = "DATA DIVISION."
        + "SCREEN SECTION."
        + "1 pla-res.";
    scan(program);
    parse();
    assertTrue(cobolFile != null);
    assertTrue(cobolFile.getDataDivision() != null && cobolFile.getDataDivision().getScreenSection() != null && cobolFile.getDataDivision().getScreenSection().getDataEntrys().size() == 1);
    DataEntry de = cobolFile.getDataDivision().getScreenSection().getDataEntrys().get(0);
    assertTrue(de instanceof DataRecord);
    DataRecord dre = (DataRecord)de;
    assertTrue("1".equals(dre.getLevel()) && "pla-res".equals(dre.getName()));
  }

  @Test
  public void parse_DataDivitionScreenSectionLineInst() throws Exception {
    String program = "DATA DIVISION."
        + "SCREEN SECTION."
        + "1 pla-res."
        + "2 LINE a.";
    scan(program);
    parse();
    assertTrue(cobolFile != null);
    assertTrue(cobolFile.getDataDivision() != null && cobolFile.getDataDivision().getScreenSection() != null && cobolFile.getDataDivision().getScreenSection().getDataEntrys().size() == 2);
    DataEntry de1 = cobolFile.getDataDivision().getScreenSection().getDataEntrys().get(0);
    assertTrue(de1 instanceof DataRecord);
    DataRecord dre = (DataRecord)de1;
    assertTrue("1".equals(dre.getLevel()) && "pla-res".equals(dre.getName()));
    DataEntry de2 = cobolFile.getDataDivision().getScreenSection().getDataEntrys().get(1);
    assertTrue(de2 instanceof DataScreenEntry);
    DataScreenEntry dse = (DataScreenEntry)de2;
    assertTrue("2".equals(dse.getLevel()) && dse.getDataScreenElements().size() == 1);
    DataScreenInstruction dsi = dse.getDataScreenElements().get(0);
    assertTrue(dsi instanceof DataScreenLineInstruction);
    DataScreenLineInstruction dsli = (DataScreenLineInstruction)dsi;
    assertTrue("a".equals(dsli.getValue()));
  }

  @Test
  public void parse_Program() throws Exception {
    String program = "IDENTIFICATION DIVISION." + 
        "PROGRAM-ID. Manipulation." + 
        "" + 
        "DATA DIVISION." + 
        "WORKING-STORAGE SECTION." + 
        "77 a PIC 99." + 
        "" + 
        "SCREEN SECTION." + 
        "" + 
        "1 pla-res." + 
        "    2 LINE a COL 10." + 
        "    2 PIC 99 FROM a VALUE \"Valeur de a :\"." + 
        "" + 
        "PROCEDURE DIVISION." + 
        "" + 
        "MOVE 5 TO a." + 
        "DISPLAY pla-res." + 
        "ADD 2 TO a." + 
        "DISPLAY pla-res." + 
        "" + 
        "STOP RUN.";
    scan(program);
    parse();
    assertTrue(cobolFile != null);
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
}
