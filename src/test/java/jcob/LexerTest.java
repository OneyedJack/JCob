package jcob;

import static com.google.common.truth.Truth.assertThat;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.junit.After;
import org.junit.Test;

/**
 * Test for the generated {@link CobolLexer}.
 *
 * <p>The lexer is probably already correct thanks to the regression tests. This test class is
 * mostly here to show how the lexer behaves.
 */
public class LexerTest {

  private CobolLexer lexer;

  @After
  public void resetLexer() {
    lexer = null;
  }

  @Test
  public void scan_tokenIdentifier() throws Exception {
    scan("helloWorld");
    assertThat(nextToken()).isEqualTo(sym.IDENTIFIER);
  }

  @Test
  public void scan() throws Exception {
    scan("IDENTIFICATION DIVISION.");
    assertThat(nextToken()).isEqualTo(sym.IDENTIFICATION);
    assertThat(nextToken()).isEqualTo(sym.DIVISION);
    assertThat(nextToken()).isEqualTo(sym.DOT);
    assertThat(nextToken()).isEqualTo(sym.EOF);
  }

  /*@SuppressWarnings("TryFailThrowable")
  @Test
  public void scanIllegalChar() throws Exception {
    scan("\"");
    try {
      nextToken();
      fail("Character `;` is not declared in the minijava.flex");
    } catch (UnknownCharacterException expected) {
    }
  }*/

  private void scan(String input) {
    Reader in = new StringReader(input);
    lexer = new CobolLexer(in);
  }

  private int nextToken() throws IOException, UnknownCharacterException {
    return lexer.next_token().sym;
  }
}
