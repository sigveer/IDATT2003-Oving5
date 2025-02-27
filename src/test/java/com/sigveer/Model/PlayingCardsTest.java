package com.sigveer.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/**
 * {@code PlayingCardsTest} is a test class for the {@code PlayingCards} class.
 */
class PlayingCardsTest {


  /**
   * Tests a valid card in the {@code PlayingCards} class including {@code toString}.
   */
  @Test
  public void ValidCard() {
    PlayingCards card = new PlayingCards('♥', 8);
    assertEquals('♥', card.suit());
    assertEquals(8, card.face());
    assertEquals("♥8", card.toString());
  }


  /**
   * Tests an invalid card in the {@code PlayingCards} class.
   */
  @Test
  public void InvalidCard() {
    assertThrows(IllegalArgumentException.class, () -> new PlayingCards('♥', 0));
    assertThrows(IllegalArgumentException.class, () -> new PlayingCards('♥', 14));
  }
}