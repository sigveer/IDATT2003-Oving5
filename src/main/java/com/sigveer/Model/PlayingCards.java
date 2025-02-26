package com.sigveer.Model;


/**
 * Represents playing cards.
 */
public class PlayingCards {

  private final char suit;
  private final int face;


  /**
   * Constructor that creates playing cards.
   *
   * @param suit The suit of the card.
   * @param face The face value of the card.
   * @LastEdited: 1.0
   * @Since: 1.0
   */
  public PlayingCards(char suit, int face) {
    if (face < 1 || face > 13) {
      throw new IllegalArgumentException("Face value must be between 1 and 13.");
    }
    this.suit = suit;
    this.face = face;
  }


  /**
   * Method that returns the suit of the card.
   *
   * @return The suit of the card.
   * @LastEdited: 1.0
   * @Since: 1.0
   */
  public char getSuit() {
    return suit;
  }

  /**
   * Method that returns the face value of the card.
   *
   * @return The face value of the card.
   * @LastEdited: 1.0
   * @Since: 1.0
   */
  public int getFace() {
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
