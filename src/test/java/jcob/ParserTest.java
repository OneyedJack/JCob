package jcob;

import static org.junit.Assert.assertTrue;

import java.io.Reader;
import java.io.StringReader;

import org.junit.After;
import org.junit.Test;

import jcob.bean.CobolFile;
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
        + "AUTHOR. Xavier."
        + "";
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
        + "AUTHOR. Xavier."
        + "";
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
