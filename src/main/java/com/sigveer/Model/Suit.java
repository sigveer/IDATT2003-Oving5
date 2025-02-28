package com.sigveer.Model;

public enum Suit {
  SPADES('♠', false),
  CLUBS('♣', false),
  HEARTS('♥', true),
  DIAMONDS('♦', true);

  private final char symbol;
  private final boolean isRed;

  Suit(char symbol, boolean isRed) {
    this.symbol = symbol;
    this.isRed = isRed;
  }

  public char getSymbol() {
    return symbol;
  }

  public boolean isRed() {
    return isRed;
  }
}
