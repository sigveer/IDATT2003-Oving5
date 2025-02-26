package com.sigveer.Model;

import java.util.List;


/**
 * Represents a hand of cards.
 */
public class HandOfCards {

  private final List<PlayingCards> hand;


  /**
   * Constructor that creates a hand of cards.
   *
   * @param hand The hand of cards.
   * @LastEdited: 1.0
   * @Since: 1.0
   */
  public HandOfCards(List<PlayingCards> hand) {
    this.hand = hand;
  }

}
