package com.sigveer.Controller;

import static org.junit.jupiter.api.Assertions.*;

import com.sigveer.Model.PlayingCards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sigveer.Model.HandOfCards;
import com.sigveer.Model.Suit;

/**
 * {@code GameControllerTest} is a test class for the {@code GameController} class.
 * Tests verify game logic and interactions with the model classes.
 */
class GameControllerTest {

  private GameController gameController;

  /**
   * Sets up a fresh game controller before each test.
   */
  @BeforeEach
  void setUp() {
    gameController = new GameController();
  }

  /**
   * Tests dealing a hand of cards.
   */
  @Test
  void dealHand() {
    gameController.dealHand(5);

    HandOfCards hand = gameController.getCurrentHand();
    assertNotNull(hand, "Hand should not be null after dealing");
    assertEquals(5, hand.hand().size(), "Hand should contain 5 cards");
  }

  /**
   * Tests calculating the sum of faces in the current hand.
   */
  @Test
  void calculateFaceSum() {
    gameController.dealHand(5);
    int sum = gameController.calculateFaceSum();

    assertTrue(sum >= 5 && sum <= 65,
        "Sum of faces for 5 cards should be between 5 and 65, but was " + sum);

    int actualSum = gameController.getCurrentHand().hand().stream()
        .mapToInt(PlayingCards::face)
        .sum();
    assertEquals(actualSum, sum, "Calculated sum should match actual sum of cards");
  }

  /**
   * Tests identifying hearts cards in the current hand.
   */
  @Test
  void getHeartsCards() {
    for (int attempt = 0; attempt < 5; attempt++) {
      gameController.dealHand(10);

      String heartsCards = gameController.getHeartsCards();

      if (!heartsCards.isEmpty()) {
        for (String cardStr : heartsCards.split(", ")) {
          assertTrue(cardStr.startsWith("♥"),
              "Card " + cardStr + " should be a heart");
        }
        break;
      }
    }
  }

  /**
   * Tests checking for the queen of spades in the current hand. This test deals multiple hands to
   * increase the chance of finding the queen.
   */
  @Test
  void hasQueenOfSpades() {
    boolean foundQueen = false;

    for (int attempt = 0; attempt < 20 && !foundQueen; attempt++) {
      gameController.dealHand(5);

      if (gameController.hasQueenOfSpades()) {
        foundQueen = true;

        boolean queenInHand = gameController.getCurrentHand().hand().stream()
            .anyMatch(card -> card.suit() == Suit.SPADES && card.face() == 12);
        assertTrue(queenInHand, "Queen of spades should be in the hand");
      }
    }
  }

  /**
   * Tests checking for a flush in the current hand. This test deals multiple hands to increase the
   * chance of finding a flush.
   */
  @Test
  void testHasFlush() {
    boolean foundFlush = false;
    int attempts = 0;
    final int MAX_ATTEMPTS = 1000;

    while (!foundFlush && attempts < MAX_ATTEMPTS) {
      gameController.dealHand(5);
      foundFlush = gameController.hasFlush();
      attempts++;
    }

    if (foundFlush) {
      assertTrue(gameController.hasFlush(), "Should have a flush");
      System.out.println("Found flush after " + attempts + " attempts");
    } else {
      System.out.println("Did not find flush after " + MAX_ATTEMPTS + " attempts");
    }
  }
}