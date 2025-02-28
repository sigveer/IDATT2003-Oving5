package com.sigveer.Model;


/**
 * {@code Suit} represents a playing card suit.
 */
public enum Suit {
  SPADES('♠', false),
  CLUBS('♣', false),
  HEARTS('♥', true),
  DIAMONDS('♦', true);

  private final char symbol;
  private final boolean isRed;

  /**
   * Constructor that creates a suit.
   * @param symbol The symbol of the suit.
   * @param isRed True if the suit is red, false otherwise.
   */
  Suit(char symbol, boolean isRed) {
    this.symbol = symbol;
    this.isRed = isRed;
  }


  /**
   * Gets the symbol of the suit.
   *
   * @return The symbol of the suit.
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  public char getSymbol() {
    return symbol;
  }


  /**
   * Checks if the suit is red.
   *
   * @return True if the suit is red, false otherwise.
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  public boolean isRed() {
    return isRed;
  }


  /**
   * Gets the suit from a symbol.
   *
   * @param symbol The symbol of the suit.
   * @return The suit.
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  public static Suit fromSymbol(char symbol) {
    for (Suit suit : values()) {
      if (suit.getSymbol() == symbol) {
        return suit;
      }
    }
    throw new IllegalArgumentException("Invalid suit symbol: " + symbol);
  }
}
