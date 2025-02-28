package com.sigveer.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;


/**
 * {@code HandOfCardsTest} is a test class for the {@code HandOfCards} class.
 */
class HandOfCardsTest {


  /**
   * Tests the {@code getHand} method in the {@code HandOfCards} class.
   */
  @Test
  void getHand() {
    List<PlayingCards> hand = List.of(
        new PlayingCards('♥', 2),
        new PlayingCards('♦', 5),
        new PlayingCards('♠', 8)
    );
    HandOfCards handOfCards = new HandOfCards(hand);
    assertEquals(hand, handOfCards.hand());
  }


  /**
   * Tests if there is a flush in the hand in the {@code HandOfCards} class and {@code checkFlush}
   * method.
   */
  @Test
  void checkFlushPositive() {
    List<PlayingCards> hand = List.of(
        new PlayingCards('♥', 2),
        new PlayingCards('♥', 5),
        new PlayingCards('♥', 8),
        new PlayingCards('♥', 11),
        new PlayingCards('♥', 12)
    );
    HandOfCards handOfCards = new HandOfCards(hand);
    assertTrue(handOfCards.checkFlush());
  }


  /**
   * Tests if there is no flush in the hand in the {@code HandOfCards} class and {@code checkFlush}
   * method.
   */
  @Test
  void checkFlushFalse() {
    List<PlayingCards> hand = List.of(
        new PlayingCards('♥', 2),
        new PlayingCards('♦', 5),
        new PlayingCards('♠', 8),
        new PlayingCards('♣', 11),
        new PlayingCards('♦', 12)
    );
    HandOfCards handOfCards = new HandOfCards(hand);
    assertFalse(handOfCards.checkFlush());
  }


  @Test
  void testToString() {
    List<PlayingCards> hand = List.of(
        new PlayingCards('♥', 2),
        new PlayingCards('♦', 5),
        new PlayingCards('♠', 8)
    );
    HandOfCards handOfCards = new HandOfCards(hand);
    assertEquals("♥2 ♦5 ♠8", handOfCards.toString());
  }

  @Test
  void findFlush() {
    Random random = new Random();
    boolean foundFlush = false;
    int attempts = 0;

    while (!foundFlush) {
      attempts++;
      List<PlayingCards> hand = new ArrayList<>();
      for (int i = 0; i < 5; i++) {
        char suit = switch (random.nextInt(4)) {
          case 0 -> '♥';
          case 1 -> '♦';
          case 2 -> '♠';
          case 3 -> '♣';
          default -> throw new IllegalStateException("Unexpected value: " + random.nextInt(4));
        };
        int rank = random.nextInt(13) + 1;
        hand.add(new PlayingCards(suit, rank));
      }
      HandOfCards handOfCards = new HandOfCards(hand);
      foundFlush = handOfCards.checkFlush();
      if (foundFlush) {
        long suitCount = hand.stream()
            .collect(Collectors.groupingBy(PlayingCards::suit, Collectors.counting()))
            .values().stream().filter(count -> count == 5).count();
        assertTrue(suitCount == 1, "The hand should contain exactly 5 cards of the same suit.");
        System.out.println("Flush found after " + attempts + " attempts.");
      }
    }
  }
}
