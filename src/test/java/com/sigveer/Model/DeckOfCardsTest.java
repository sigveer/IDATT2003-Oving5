package com.sigveer.Model;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 * {@code DeckOfCardsTest} is a test class for the {@code DeckOfCards} class.
 * Tests verify proper deck initialization and hand dealing functionality.
 */
class DeckOfCardsTest {
  private DeckOfCards deckOfCards;

  /**
   * Sets up a fresh deck of cards before each test.
   */
  @BeforeEach
  void setUp() {
    deckOfCards = new DeckOfCards();
  }

  /**
   * Tests that a new deck is initialized with 52 unique cards,
   * containing the correct distribution of suits and faces.
   */
  @Test
  void deckInitialization() {
    HandOfCards hand = deckOfCards.dealHand(52);
    List<PlayingCards> cards = hand.hand();

    assertEquals(52, cards.size(), "There should be 52 cards in the deck.");

    Set<PlayingCards> uniqueCards = new HashSet<>(cards);
    assertEquals(52, uniqueCards.size(), "All cards should be unique.");

    long countHearts = cards.stream().filter(card -> card.suit() == Suit.HEARTS).count();
    long countDiamonds = cards.stream().filter(card -> card.suit() == Suit.DIAMONDS).count();
    long countSpades = cards.stream().filter(card -> card.suit() == Suit.SPADES).count();
    long countClubs = cards.stream().filter(card -> card.suit() == Suit.CLUBS).count();

    assertEquals(13, countHearts, "There should be 13 hearts in the deck.");
    assertEquals(13, countDiamonds, "There should be 13 diamonds in the deck.");
    assertEquals(13, countSpades, "There should be 13 spades in the deck.");
    assertEquals(13, countClubs, "There should be 13 clubs in the deck.");

    for (Suit suit : Suit.values()) {
      for (int face = 1; face <= 13; face++) {
        final int currentFace = face;
        assertTrue(cards.stream().anyMatch(card ->
                card.suit() == suit && card.face() == currentFace),
            "Deck should contain " + suit.getSymbol() + face);
      }
    }
  }

  /**
   * Tests dealing a valid hand with a specific number of cards.
   */
  @Test
  void dealHandValid() {
    int numberOfCards = 5;
    HandOfCards hand = deckOfCards.dealHand(numberOfCards);
    assertEquals(numberOfCards, hand.hand().size(), "The hand should contain 5 cards.");
  }

  /**
   * Tests that dealing a hand with zero or negative cards throws an exception.
   */
  @Test
  void dealHandInvalidTooFewCards() {
    assertThrows(IllegalArgumentException.class, () -> deckOfCards.dealHand(0),
        "Dealing 0 cards should throw IllegalArgumentException");
    assertThrows(IllegalArgumentException.class, () -> deckOfCards.dealHand(-5),
        "Dealing negative cards should throw IllegalArgumentException");
  }

  /**
   * Tests that dealing a hand with more than 52 cards throws an exception.
   */
  @Test
  void dealHandInvalidTooManyCards() {
    assertThrows(IllegalArgumentException.class, () -> deckOfCards.dealHand(53),
        "Dealing more than 52 cards should throw IllegalArgumentException");
    assertThrows(IllegalArgumentException.class, () -> deckOfCards.dealHand(100),
        "Dealing 100 cards should throw IllegalArgumentException");
  }

  /**
   * Tests that shuffling works by dealing all cards and checking the order is not always the same.
   * Note: There is a tiny chance this test could fail if shuffling happens to produce the same order twice.
   */
  @Test
  void deckShuffling() {
    HandOfCards firstHand = deckOfCards.dealHand(52);

    deckOfCards = new DeckOfCards();
    HandOfCards secondHand = deckOfCards.dealHand(52);

    boolean someCardsDifferent = false;
    for (int i = 0; i < 52; i++) {
      if (!firstHand.hand().get(i).toString().equals(secondHand.hand().get(i).toString())) {
        someCardsDifferent = true;
        break;
      }
    }
    assertTrue(someCardsDifferent, "Cards should be in different order after shuffling");
  }
}