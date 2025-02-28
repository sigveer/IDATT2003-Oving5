package com.sigveer.Controller;

import com.sigveer.Model.DeckOfCards;
import com.sigveer.Model.HandOfCards;

public class GameController {
  private final DeckOfCards deck;
  private HandOfCards currentHand;

  public GameController() {
    this.deck = new DeckOfCards();
    this.currentHand = null;
  }

  public HandOfCards dealHand(int numberOfCards) {
    currentHand = deck.dealHand(numberOfCards);
    return currentHand;
  }

}
