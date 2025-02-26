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
}
