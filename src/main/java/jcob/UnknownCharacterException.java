package jcob;

class UnknownCharacterException extends Exception {
  UnknownCharacterException(String unknownInput) {
    super("Unknown character « " + unknownInput + " »");
  }
}
