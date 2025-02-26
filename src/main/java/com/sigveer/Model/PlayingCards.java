package com.sigveer.Model;

public class PlayingCards {

  private final char suit;
  private final int face;

  public PlayingCards(char suit, int face) {
    if (face < 1 || face > 13) {
      throw new IllegalArgumentException("Face value must be between 1 and 13.");
    }
    this.suit = suit;
    this.face = face;
  }
}
