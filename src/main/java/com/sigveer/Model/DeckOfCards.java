package com.sigveer.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Represents a deck of cards.
 */
public class DeckOfCards {

  private List<PlayingCards> deck;
  private final char[] suits = {'♠', '♣', '♦', '♥'};


  /**
   * Constructor that creates a deck of cards.
   *
   * @LastEdited: 1.0
   * @Since: 1.0
   */
  public DeckOfCards() {
    this.deck = new ArrayList<>();
    for (char suit : suits) {
      for (int face = 1; face <= 13; face++) {
        deck.add(new PlayingCards(suit, face));
      }
    }
  }


  /**
   * Method that deals a hand of cards.
   *
   * @param numberOfCards The number of cards to deal.
   * @return A hand of cards.
   * @LastEdited: 1.0
   * @Since: 1.0
   */
  public HandOfCards dealHand(int numberOfCards) {
    if (numberOfCards < 1 || numberOfCards > 52) {
      throw new IllegalArgumentException("Number of cards must be between 1 and 52.");
    }
    Collections.shuffle(this.deck);
    List<PlayingCards> dealtCards = new ArrayList<>(this.deck.subList(0, numberOfCards));
    return new HandOfCards(dealtCards);
  }
}
