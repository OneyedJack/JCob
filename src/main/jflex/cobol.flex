package jcob;

import java_cup.runtime.Symbol;

/** Lexer of a very minimal version of the Java programming language. */
/**
IDENTIFICATION DIVISION.
PROGRAM-ID. Manipulation.

DATA DIVISION.
WORKING-STORAGE SECTION.
77 a PIC 99.

SCREEN SECTION.

1 pla-res.
    2 LINE a COL 10 VALUE 'Valeur de a :'.
    2 PIC 99 FROM a.

PROCEDURE DIVISION.

MOVE 5 TO a.
DISPLAY pla-res.
ADD 2 TO a.
DISPLAY pla-res.

STOP RUN.
**/


%%

%public
%class CobolLexer
%unicode
%caseless
%cup
%line
%column
%throws UnknownCharacterException

%{
  StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }
%}


LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

Comment = "\*" {InputCharacter}* {LineTerminator}?

Identifier = [a-zA-Z] [a-zA-Z\-]*

DecIntegerLiteral = 0 | [1-9][0-9]*
Numeric = [0-9]*


%state STRING

%%


/* keywords */
<YYINITIAL> "division"           { return symbol(sym.DIVISION); }
<YYINITIAL> "section"            { return symbol(sym.SECTION); }
/* Identification */
<YYINITIAL> "identification"     { return symbol(sym.IDENTIFICATION); }
<YYINITIAL> "id"                 { return symbol(sym.ID); }
<YYINITIAL> "program-id"         { return symbol(sym.PROGRAMID); }
<YYINITIAL> "author"             { return symbol(sym.AUTHOR); }
<YYINITIAL> "installation"       { return symbol(sym.INSTALLATION); }
<YYINITIAL> "security"           { return symbol(sym.SECURITY); }
/* Environment */
<YYINITIAL> "environment"        { return symbol(sym.ENVIRONMENT); }
<YYINITIAL> "configuration"      { return symbol(sym.CONFIGURATION); }
<YYINITIAL> "input-output"       { return symbol(sym.INPUTOUTPUT); }
/* Data */
<YYINITIAL> "data"               { return symbol(sym.DATA); }
<YYINITIAL> "file"               { return symbol(sym.FILE); }
<YYINITIAL> "working-storage"    { return symbol(sym.WORKINGSTORAGE); }
<YYINITIAL> "local-storage"      { return symbol(sym.LOCALSTORAGE); }
<YYINITIAL> "linkage"            { return symbol(sym.LINKAGE); }
<YYINITIAL> "screen"             { return symbol(sym.SCREEN); }
/* Procedure */
<YYINITIAL> "procedure"          { return symbol(sym.PROCEDURE); }
<YYINITIAL> "pic"                { return symbol(sym.PIC); }
<YYINITIAL> "line"               { return symbol(sym.LINE); }
<YYINITIAL> "col"                { return symbol(sym.COL); }
<YYINITIAL> "value"              { return symbol(sym.VALUE); }
<YYINITIAL> "from"               { return symbol(sym.FROM); }
<YYINITIAL> "move"               { return symbol(sym.MOVE); }
<YYINITIAL> "display"            { return symbol(sym.DISPLAY); }
<YYINITIAL> "add"                { return symbol(sym.ADD); }
<YYINITIAL> "to"                 { return symbol(sym.TO); }
<YYINITIAL> "stop"               { return symbol(sym.STOP); }
<YYINITIAL> "run"                { return symbol(sym.RUN); }
<YYINITIAL> "end"                { return symbol(sym.END); }
<YYINITIAL> "program"            { return symbol(sym.PROGRAM); }
<YYINITIAL> "("                  { return symbol(sym.LPAREN); }
<YYINITIAL> ")"                  { return symbol(sym.RPAREN); }


<YYINITIAL> {
  /* identifiers */
  {Identifier}                   { return symbol(sym.IDENTIFIER, yytext()); }

  /* literals */
  {DecIntegerLiteral}            { return symbol(sym.INTEGER_LITERAL, Integer.valueOf(yytext())); }
  {Numeric}                      { return symbol(sym.NUMERIC, yytext()); }
  \"                             { string.setLength(0); yybegin(STRING); }
  \'                             { string.setLength(0); yybegin(STRING); }

  /* operators */
  "."                            { return symbol(sym.DOT); }

  /* comments */
  {Comment}                      { /* ignore */ }

  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }
}


<STRING> {
  \"                             { yybegin(YYINITIAL);
                                   return symbol(sym.STRING_LITERAL, string.toString()); }
  \'                             { yybegin(YYINITIAL);
                                   return symbol(sym.STRING_LITERAL, string.toString()); }
  [^\n\r\"\\]+                   { string.append( yytext() ); }
  \\t                            { string.append('\t'); }
  \\n                            { string.append('\n'); }

  \\r                            { string.append('\r'); }
  \\\"                           { string.append('\"'); }
  \\                             { string.append('\\'); }
}


/* error fallback */
[^]                              { throw new UnknownCharacterException(yytext()); }
