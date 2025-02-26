package com.sigveer.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
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
    assertEquals(hand, handOfCards.getHand());
  }


  /**
   * Tests if there is a flush in the hand in the {@code HandOfCards} class and {@code checkFlush} method.
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
   * Tests if there is no flush in the hand in the {@code HandOfCards} class and {@code checkFlush} method.
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
    assertEquals("♥2, ♦5, ♠8", handOfCards.toString());
  }
}