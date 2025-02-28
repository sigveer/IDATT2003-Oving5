package com.sigveer.Controller;

import com.sigveer.Model.DeckOfCards;
import com.sigveer.Model.HandOfCards;
import com.sigveer.Model.PlayingCards;
import com.sigveer.Model.Suit;
import java.util.List;
import java.util.stream.Collectors;


/**
 * {@code GameController} represents the controller for the card game.
 */
public class GameController {
  private final DeckOfCards deck;
  private HandOfCards currentHand;


  /**
   * Constructor that creates a new game controller.
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  public GameController() {
    this.deck = new DeckOfCards();
    this.currentHand = null;
  }


  /**
   * Method that deals a hand of cards.
   *
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  public void dealHand(int numberOfCards) {
    currentHand = deck.dealHand(numberOfCards);
  }


  /**
   * Method that returns the current hand of cards.
   *
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  public HandOfCards getCurrentHand() {
    return currentHand;
  }


  /**
   * Method that returns the number of cards in the current hand.
   *
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  public int calculateFaceSum() {
    if (currentHand == null) {
      return 0;
    }
    return currentHand.sumOfFaces();
  }


  /**
   * Method that returns the hearts cards in the current hand.
   *
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  public String getHeartsCards() {
    if (currentHand == null) {
      return "";
    }
    List<PlayingCards> heartsCards = currentHand.getCardsBySuit(Suit.HEARTS);
    if (heartsCards.isEmpty()) {
      return "";
    }
    return heartsCards.stream()
        .map(PlayingCards::toString)
        .collect(Collectors.joining(", "));
  }


  /**
   * Method that returns whether the current hand has the queen of spades.
   *
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  public boolean hasQueenOfSpades() {
    if (currentHand == null) {
      return false;
    }
    return currentHand.containsCard(Suit.SPADES, 12);
  }


  /**
   * Method that returns whether the current hand has a flush.
   *
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  public boolean hasFlush() {
    if (currentHand == null) {
      return false;
    }
    return currentHand.checkFlush();
  }

}
