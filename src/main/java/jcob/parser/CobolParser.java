/*
 * The MIT License
 * Copyright © 2014-2019 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package jcob.parser;

public class CobolParser {

  static String program = "      IDENTIFICATION DIVISION.\r\n" + 
                          "      PROGRAM-ID. Manipulation.\r\n" + 
                          "\r\n" + 
                          "      DATA DIVISION.\r\n" + 
                          "      WORKING-STORAGE SECTION.\r\n" + 
                          "      77 a PIC 99.\r\n" + 
                          "\r\n" + 
                          "      SCREEN SECTION.\r\n" + 
                          "\r\n" + 
                          "      1 pla-res.\r\n" + 
                          "          2 LINE a COL 10 VALUE 'Valeurdea:'.\r\n" + 
                          "          2 PIC 99 FROM a.\r\n" + 
                          "\r\n" + 
                          "      PROCEDURE DIVISION.\r\n" + 
                          "\r\n" + 
                          "      MOVE 5 TO a.\r\n" + 
                          "      DISPLAY pla-res.\r\n" + 
                          "      ADD 2 TO a.\r\n" + 
                          "      DISPLAY pla-res.\r\n" + 
                          "\r\n" + 
                          "      STOP RUN.";
  static String program2 = "       IDENTIFICATION DIVISION.\r\n" + 
      "       PROGRAM-ID. CISP.\r\n" + 
      "       ENVIRONMENT DIVISION.\r\n" + 
      "       INPUT-OUTPUT SECTION.\r\n" + 
      "       FILE-CONTROL.\r\n" + 
      "       SELECT TESTS-FILE ASSIGN TO \"..\\test\\tests-lists.txt\"\r\n" + 
      "          ORGANIZATION IS LINE SEQUENTIAL.\r\n" + 
      "       DATA DIVISION.\r\n" + 
      "       FILE SECTION.\r\n" + 
      "       FD TESTS-FILE.\r\n" + 
      "       01 LISP-TEST-FILE-NAME PIC X(100).\r\n" + 
      "       WORKING-STORAGE SECTION.\r\n" + 
      "       01 WS-CMD-LINE.\r\n" + 
      "           02 WS-CMD-LINE-VAL PIC X(100).\r\n" + 
      "           02 WS-CMD-LINE-NUM-AGRS PIC 9(4).\r\n" + 
      "           01 WS-LOG-OPERATION-FLAG PIC X(5).\r\n" + 
      "           01 WS-LOG-RECORD.\r\n" + 
      "               02 WS-LOG-RECORD-FUNCTION-NAME PIC X(40).\r\n" + 
      "               02 WS-LOG-RECORD-MESSAGE PIC X(100).\r\n" + 
      "       01 WS-LISP-FILE-NAME PIC X(100).\r\n" + 
      "       78 WS-SYMBOL-LENGTH VALUE 100.\r\n" + 
      "       01 WS-LISP-SYMBOLS.\r\n" + 
      "           02 WS-SYMBOL-TABLE-SIZE PIC 9(4).\r\n" + 
      "           02 WS-SYMBOL PIC X(50) OCCURS WS-SYMBOL-LENGTH TIMES.\r\n" + 
      "           02 WS-SYMBOL-LEN PIC 9(2) OCCURS WS-SYMBOL-LENGTH TIMES.\r\n" + 
      "       PROCEDURE DIVISION.\r\n" + 
      "       MAIN-PROCEDURE.\r\n" + 
      "           PERFORM INIT-LOGGER-PROCEDURE.\r\n" + 
      "           PERFORM READ-CMD-LINE-PROCEDURE.\r\n" + 
      "           PERFORM TOKENIZE-LISP-PROCEDURE.\r\n" + 
      "           PERFORM EVALUTE-LISP-PROCEDURE.\r\n" + 
      "           PERFORM CLOSE-LOGGER-PROCEDURE.\r\n" + 
      "           GOBACK.\r\n" + 
      "       READ-CMD-LINE-PROCEDURE.\r\n" + 
      "           ACCEPT WS-CMD-LINE-NUM-AGRS FROM ARGUMENT-NUMBER.\r\n" + 
      "           ACCEPT WS-CMD-LINE-VAL FROM ARGUMENT-VALUE.\r\n" + 
      "           MOVE WS-CMD-LINE-VAL TO WS-LISP-FILE-NAME.\r\n" + 
      "           MOVE \"ADD\" TO WS-LOG-OPERATION-FLAG.\r\n" + 
      "           MOVE \"CISP:READ-CMD-LINE-PROCEDURE\"\r\n" + 
      "           TO WS-LOG-RECORD-FUNCTION-NAME.\r\n" + 
      "           MOVE \"Reading commandline argument\" TO WS-LOG-RECORD-MESSAGE.\r\n" + 
      "           CALL 'LOGGER' USING WS-LOG-OPERATION-FLAG, WS-LOG-RECORD.\r\n" + 
      "       TOKENIZE-LISP-PROCEDURE.\r\n" + 
      "            MOVE \"ADD\" TO WS-LOG-OPERATION-FLAG.\r\n" + 
      "            MOVE \"TOKENIZER\" TO WS-LOG-RECORD-FUNCTION-NAME.\r\n" + 
      "            MOVE \"Starting Tokenizer\" TO WS-LOG-RECORD-MESSAGE.\r\n" + 
      "            CALL 'LOGGER' USING WS-LOG-OPERATION-FLAG, WS-LOG-RECORD.\r\n" + 
      "            CALL \"TOKENIZER\" USING WS-LISP-FILE-NAME,\r\n" + 
      "                 WS-SYMBOL-LENGTH, WS-LISP-SYMBOLS.\r\n" + 
      "       EVALUTE-LISP-PROCEDURE.\r\n" + 
      "            MOVE \"ADD\" TO WS-LOG-OPERATION-FLAG.\r\n" + 
      "            MOVE \"LISP\" TO WS-LOG-RECORD-FUNCTION-NAME.\r\n" + 
      "            MOVE \"Starting Lisp Evalutation\" TO WS-LOG-RECORD-MESSAGE.\r\n" + 
      "            CALL 'LOGGER' USING WS-LOG-OPERATION-FLAG, WS-LOG-RECORD.\r\n" + 
      "            CALL \"LISP\" USING WS-LISP-SYMBOLS.\r\n" + 
      "       INIT-LOGGER-PROCEDURE.\r\n" + 
      "            MOVE \"OPEN\" TO WS-LOG-OPERATION-FLAG.\r\n" + 
      "            CALL 'LOGGER' USING WS-LOG-OPERATION-FLAG, WS-LOG-RECORD.\r\n" + 
      "       CLOSE-LOGGER-PROCEDURE.\r\n" + 
      "            MOVE \"CLOSE\" TO WS-LOG-OPERATION-FLAG.\r\n" + 
      "            CALL 'LOGGER' USING WS-LOG-OPERATION-FLAG, WS-LOG-RECORD.\r\n" + 
      "       END PROGRAM CISP.";
  static String program3 = "       IDENTIFICATION DIVISION.\r\n" + 
      "       PROGRAM-ID. LOGGER.\r\n" + 
      "       ENVIRONMENT DIVISION.\r\n" + 
      "       INPUT-OUTPUT SECTION.\r\n" + 
      "       FILE-CONTROL.\r\n" + 
      "       SELECT OPTIONAL LOG-FILE ASSIGN TO DYNAMIC WS-LOG-FILE-NAME\r\n" + 
      "               ORGANISATION IS LINE SEQUENTIAL.\r\n" + 
      "       DATA DIVISION.\r\n" + 
      "       FILE SECTION.\r\n" + 
      "       FD LOG-FILE.\r\n" + 
      "           01 LOG-RECORD.\r\n" + 
      "               02 LOG-RECORD-ID PIC 9(10).\r\n" + 
      "               02 LOG-RECORD-FUNCTION-NAME PIC X(40).\r\n" + 
      "               02 LOG-RECORD-MESSAGE PIC X(100).\r\n" + 
      "       WORKING-STORAGE SECTION.\r\n" + 
      "           01 WS-LOG-FILE-NAME PIC X(20).\r\n" + 
      "       LINKAGE SECTION.\r\n" + 
      "           01 LS-LOG-OPERATION-FLAG PIC X(5).\r\n" + 
      "           01 LS-LOG-RECORD.\r\n" + 
      "               02 LS-LOG-RECORD-FUNCTION-NAME PIC X(40).\r\n" + 
      "               02 LS-LOG-RECORD-MESSAGE PIC X(100).\r\n" + 
      "       PROCEDURE DIVISION USING LS-LOG-OPERATION-FLAG, LS-LOG-RECORD.\r\n" + 
      "       MAIN-PROCEDURE.\r\n" + 
      "           EVALUATE LS-LOG-OPERATION-FLAG\r\n" + 
      "           WHEN \"OPEN\"\r\n" + 
      "               PERFORM LOG-INIT-PROCEDURE\r\n" + 
      "           WHEN \"CLOSE\"\r\n" + 
      "               PERFORM LOG-CLOSE-PROCEDURE\r\n" + 
      "           WHEN \"ADD\"\r\n" + 
      "               PERFORM LOG-WRITE-TO-PROCEDURE\r\n" + 
      "           WHEN OTHER\r\n" + 
      "               PERFORM LOG-FLAG-ERROR-PROCEDURE.\r\n" + 
      "           GOBACK.\r\n" + 
      "       LOG-INIT-PROCEDURE.\r\n" + 
      "           MOVE '..\\logs\\log.data' TO WS-LOG-FILE-NAME.\r\n" + 
      "           OPEN OUTPUT LOG-FILE.\r\n" + 
      "           MOVE 1 TO LOG-RECORD-ID.\r\n" + 
      "           MOVE \"LOG-INIT-PROCEDURE\" TO LOG-RECORD-FUNCTION-NAME.\r\n" + 
      "           MOVE \"Starting Program!\" TO LOG-RECORD-MESSAGE.\r\n" + 
      "           WRITE LOG-RECORD.\r\n" + 
      "       LOG-WRITE-TO-PROCEDURE.\r\n" + 
      "           ADD 1 TO LOG-RECORD-ID.\r\n" + 
      "           MOVE LS-LOG-RECORD-FUNCTION-NAME TO LOG-RECORD-FUNCTION-NAME.\r\n" + 
      "           MOVE LS-LOG-RECORD-MESSAGE TO LOG-RECORD-MESSAGE.\r\n" + 
      "           WRITE LOG-RECORD.\r\n" + 
      "       LOG-FLAG-ERROR-PROCEDURE.\r\n" + 
      "           DISPLAY \"READ FLAG ERROR\".\r\n" + 
      "       LOG-CLOSE-PROCEDURE.\r\n" + 
      "           ADD 1 TO LOG-RECORD-ID.\r\n" + 
      "           MOVE \"LOGGER:LOG-CLOSE-PROCEDURE\"\r\n" + 
      "             TO LOG-RECORD-FUNCTION-NAME.\r\n" + 
      "           MOVE \"Closed logging file\" TO LOG-RECORD-MESSAGE.\r\n" + 
      "           WRITE LOG-RECORD.\r\n" + 
      "           CLOSE LOG-FILE.\r\n" + 
      "       END PROGRAM LOGGER.";
  
  public static void main(String[] args) 
  {
    CobolFile cobolFile = new CobolFile();
    //Stack<Expression> stack = new Stack<Expression>();
    
    //String[] lineCodeList = program.split("\\.");
    //String[] lineCodeList = program2.split("\\.");
    String[] lineCodeList = program3.split("\\.");
    for (String lineCode : lineCodeList) {
      lineCode = lineCode.trim();
      cobolFile.addLine(lineCode);
    }
    System.out.println(cobolFile.toString());
  }
}
