package com.sigveer.Model;

/**
 * {@code PlayingCards} represents a playing card.
 */
public record PlayingCards(Suit suit, int face) {

  /**
   * Constructor that creates playing cards.
   *
   * @param suit The suit of the card.
   * @param face The face value of the card.
   * @LastEdited: 1.0
   * @Since: 1.0
   */
  public PlayingCards {
    if (face < 1 || face > 13) {
      throw new IllegalArgumentException("Face value must be between 1 and 13.");
    }
  }

  /**
   * Constructor that creates playing cards using a char symbol.
   *
   * @param suitSymbol The suit symbol of the card.
   * @param face The face value of the card.
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  public PlayingCards(char suitSymbol, int face) {
    this(Suit.fromSymbol(suitSymbol), face);
  }

  /**
   * Gets the suit symbol of the card.
   *
   * @return The suit symbol of the card.
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  public char suitSymbol() {
    return suit.getSymbol();
  }

  /**
   * Gets the face value of the card.
   *
   * @return The face value of the card.
   * @LastEdited: 1.0
   * @Since: 1.0
   */
  @Override
  public int face() {
    return face;
  }

  /**
   * Gets the suit of the card.
   *
   * @return The suit of the card.
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  @Override
  public Suit suit() {
    return suit;
  }

  /**
   * Checks if the card's suit is red.
   *
   * @return True if the card's suit is red, false otherwise.
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  public boolean isRed() {
    return suit.isRed();
  }

  /**
   * Gets the face as a string.
   *
   * @return The face as a string (A, 2-10, J, Q, K).
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  public String faceAsString() {
    return switch (face) {
      case 1 -> "A";
      case 11 -> "J";
      case 12 -> "Q";
      case 13 -> "K";
      default -> String.valueOf(face);
    };
  }

  /**
   * Returns a string representation of the card.
   *
   * @return A string representation of the card.
   * @LastEdited: 1.1
   * @Since: 1.0
   */
  @Override
  public String toString() {
    return "" + suit.getSymbol() + face;
  }
}