package com.sigveer.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {

  private List<PlayingCards> deck;
  private final char[] suits = {'♠', '♣', '♦', '♥'};



  public DeckOfCards(List<PlayingCards> deck) {
    deck = new ArrayList<>();
    for (char suit : suits) {
      for (int face = 1; face <= 13; face++) {
        deck.add(new PlayingCards(suit, face));
      }
    }
  }



  public HandOfCards dealHand(int numberOfCards) {
    if (numberOfCards < 1 || numberOfCards > 52) {
      throw new IllegalArgumentException("Number of cards must be between 1 and 52.");
    }
    Collections.shuffle(deck);
    List<PlayingCards> dealtCards = new ArrayList<>(deck.subList(0, numberOfCards));
    return new HandOfCards(dealtCards);
  }
}
