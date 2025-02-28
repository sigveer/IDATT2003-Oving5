package com.sigveer.Model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * {@code HandOfCardsTest} is a test class for the {@code HandOfCards} class.
 * Tests verify functionality for handling card collections and game-specific checks.
 */
class HandOfCardsTest {


  /**
   * Tests the {@code hand} method returns the correct list of cards.
   */
  @Test
  void getHand() {
    List<PlayingCards> cards = List.of(
        new PlayingCards(Suit.HEARTS, 2),
        new PlayingCards(Suit.DIAMONDS, 5),
        new PlayingCards(Suit.SPADES, 8),
        new PlayingCards(Suit.CLUBS, 10),
        new PlayingCards(Suit.HEARTS, 12)
    );
    HandOfCards handOfCards = new HandOfCards(cards);

    List<PlayingCards> returnedHand = handOfCards.hand();
    assertEquals(5, returnedHand.size(), "Hand should contain 5 cards");
    assertEquals(cards, returnedHand, "Returned hand should match the input cards");
  }


  /**
   * Tests the {@code checkFlush} method correctly identifies a flush (5+ cards of same suit).
   */
  @Test
  void checkFlushPositive() {
    List<PlayingCards> hand = List.of(
        new PlayingCards(Suit.HEARTS, 2),
        new PlayingCards(Suit.HEARTS, 5),
        new PlayingCards(Suit.HEARTS, 8),
        new PlayingCards(Suit.HEARTS, 11),
        new PlayingCards(Suit.HEARTS, 12)
    );
    HandOfCards handOfCards = new HandOfCards(hand);
    assertTrue(handOfCards.checkFlush(), "5 cards of the same suit should be a flush");
  }

  /**
   * Tests the {@code checkFlush} method correctly identifies hands without a flush.
   */
  @Test
  void checkFlushNegative() {
    List<PlayingCards> mixedHand = List.of(
        new PlayingCards(Suit.HEARTS, 2),
        new PlayingCards(Suit.DIAMONDS, 5),
        new PlayingCards(Suit.SPADES, 8),
        new PlayingCards(Suit.CLUBS, 11),
        new PlayingCards(Suit.DIAMONDS, 12)
    );
    HandOfCards mixedHandOfCards = new HandOfCards(mixedHand);
    assertFalse(mixedHandOfCards.checkFlush(), "Mixed suits should not be a flush");
  }

  /**
   * Tests the {@code containsCard} method correctly identifies when a specific card is present.
   */
  @Test
  void containsCardPositive() {
    List<PlayingCards> hand = List.of(
        new PlayingCards(Suit.HEARTS, 2),
        new PlayingCards(Suit.DIAMONDS, 5),
        new PlayingCards(Suit.SPADES, 12) // Queen of Spades
    );
    HandOfCards handOfCards = new HandOfCards(hand);

    assertTrue(handOfCards.containsCard(Suit.SPADES, 12),
        "Hand should contain Queen of Spades");
    assertTrue(handOfCards.containsCard(Suit.HEARTS, 2),
        "Hand should contain 2 of Hearts");
  }

  /**
   * Tests the {@code containsCard} method correctly identifies when a specific card is not present.
   */
  @Test
  void containsCardNegative() {
    List<PlayingCards> hand = List.of(
        new PlayingCards(Suit.HEARTS, 2),
        new PlayingCards(Suit.DIAMONDS, 5),
        new PlayingCards(Suit.SPADES, 8)
    );
    HandOfCards handOfCards = new HandOfCards(hand);

    assertFalse(handOfCards.containsCard(Suit.SPADES, 12),
        "Hand should not contain Queen of Spades");
    assertFalse(handOfCards.containsCard(Suit.CLUBS, 1),
        "Hand should not contain Ace of Clubs");
  }

  /**
   * Tests the {@code sumOfFaces} method correctly calculates the sum of all card faces.
   */
  @Test
  void sumOfFaces() {
    List<PlayingCards> hand = List.of(
        new PlayingCards(Suit.HEARTS, 2),
        new PlayingCards(Suit.DIAMONDS, 5),
        new PlayingCards(Suit.SPADES, 8),
        new PlayingCards(Suit.CLUBS, 10),
        new PlayingCards(Suit.HEARTS, 12) // Queen = 12
    );
    HandOfCards handOfCards = new HandOfCards(hand);

    int expectedSum = 2 + 5 + 8 + 10 + 12;
    assertEquals(expectedSum, handOfCards.sumOfFaces(),
        "Sum of faces should be " + expectedSum);
  }

  /**
   * Tests the {@code getCardsBySuit} method correctly returns all cards of a specified suit.
   */
  @Test
  void getCardsBySuit() {
    List<PlayingCards> hand = List.of(
        new PlayingCards(Suit.HEARTS, 2),
        new PlayingCards(Suit.HEARTS, 7),
        new PlayingCards(Suit.DIAMONDS, 5),
        new PlayingCards(Suit.SPADES, 8),
        new PlayingCards(Suit.CLUBS, 10)
    );
    HandOfCards handOfCards = new HandOfCards(hand);

    List<PlayingCards> heartsCards = handOfCards.getCardsBySuit(Suit.HEARTS);
    assertEquals(2, heartsCards.size(), "Should find 2 hearts");
    assertTrue(heartsCards.stream().allMatch(card -> card.suit() == Suit.HEARTS),
        "All returned cards should be hearts");

    List<PlayingCards> diamondsCards = handOfCards.getCardsBySuit(Suit.DIAMONDS);
    assertEquals(1, diamondsCards.size(), "Should find 1 diamond");
    assertEquals(Suit.DIAMONDS, diamondsCards.getFirst().suit(), "Card should be a diamond");

    List<PlayingCards> nonexistentSuit = handOfCards.getCardsBySuit(null);
    assertTrue(nonexistentSuit.isEmpty(), "Should return empty list for null suit");
  }

  /**
   * Tests the {@code toString} method formats the hand correctly.
   */
  @Test
  void testToString() {
    List<PlayingCards> hand = List.of(
        new PlayingCards(Suit.HEARTS, 2),
        new PlayingCards(Suit.DIAMONDS, 5),
        new PlayingCards(Suit.SPADES, 8)
    );
    HandOfCards handOfCards = new HandOfCards(hand);

    String expected = "♥2 ♦5 ♠8";
    assertEquals(expected, handOfCards.toString(),
        "Hand string representation should be correct");
  }
}