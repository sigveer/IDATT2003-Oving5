package com.sigveer.Model;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


/**
 * {@code DeckOfCardsTest} is a test class for the {@code DeckOfCards} class.
 */
class DeckOfCardsTest {


  /**
   * {@code deckInitialization} tests the {@code DeckOfCards} class constructor.
   */
  @Test
  void deckInitialization() {
    DeckOfCards deckOfCards = new DeckOfCards();
    HandOfCards hand = deckOfCards.dealHand(52);
    List<PlayingCards> cards = hand.getHand();
    assertEquals(52, cards.size(), "There should be 52 cards in the deck.");

    Set<PlayingCards> uniqueCards = new HashSet<>(cards);
    assertEquals(52, uniqueCards.size(), "All cards should be unique.");

    long countHearts = cards.stream().filter(card -> card.getSuit() == '♥').count();
    long countDiamonds = cards.stream().filter(card -> card.getSuit() == '♦').count();
    long countSpades = cards.stream().filter(card -> card.getSuit() == '♠').count();
    long countClubs = cards.stream().filter(card -> card.getSuit() == '♣').count();

    assertEquals(13, countHearts, "There should be 13 hearts in the deck.");
    assertEquals(13, countDiamonds, "There should be 13 diamonds in the deck.");
    assertEquals(13, countSpades, "There should be 13 spades in the deck.");
    assertEquals(13, countClubs, "There should be 13 clubs in the deck.");
  }


  /**
   * {@code dealHandValid} tests the {@code dealHand} method in the {@code DeckOfCards} class with a valid number of cards.
   */
  @Test
  void dealHandValid() {
    DeckOfCards deckOfCards = new DeckOfCards();
    int numberOfCards = 5;
    HandOfCards hand = deckOfCards.dealHand(numberOfCards);
    assertEquals(numberOfCards, hand.getHand().size(), "The hand should contain 5 cards.");
  }


  /**
   * {@code dealHandInvalidTooFewCards} tests the {@code dealHand} method in the {@code DeckOfCards} class with too few cards.
   */
  @Test
  void dealHandInvalidTooFewCards() {
    DeckOfCards deckOfCards = new DeckOfCards();
    int numberOfCards = 0;
    assertThrows(IllegalArgumentException.class, () -> deckOfCards.dealHand(numberOfCards));
  }


  /**
   * {@code dealHandInvalidTooManyCards} tests the {@code dealHand} method in the {@code DeckOfCards} class with too many cards.
   */
  @Test
  void dealHandInvalidTooManyCards() {
    DeckOfCards deckOfCards = new DeckOfCards();
    int numberOfCards = 53;
    assertThrows(IllegalArgumentException.class, () -> deckOfCards.dealHand(numberOfCards));
  }

}