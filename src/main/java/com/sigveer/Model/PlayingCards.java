package com.sigveer.Model;


/**
 * {@code PlayingCards} represents a playing card.
 */
public record PlayingCards(char suit, int face) {

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
   * Method that returns the suit of the card.
   *
   * @return The suit of the card.
   * @LastEdited: 1.0
   * @Since: 1.0
   */
  @Override
  public char suit() {
    return suit;
  }

  /**
   * Method that returns the face value of the card.
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
   * Method that returns the value of the card.
   *
   * @return The value of the card.
   * @LastEdited: 1.0
   * @Since: 1.0
   */
  @Override
  public String toString() {
    return "" + suit + face;
  }
}
