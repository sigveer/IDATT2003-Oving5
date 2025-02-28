package com.sigveer.Model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * {@code PlayingCardsTest} is a test class for the {@code PlayingCards} class.
 */
public class PlayingCardsTest {

  private PlayingCards aceOfSpades;
  private PlayingCards queenOfHearts;

  /**
   * Sets up two playing cards before each test.
   */
  @BeforeEach
  public void setUp() {
    aceOfSpades = new PlayingCards(Suit.SPADES, 1);
    queenOfHearts = new PlayingCards(Suit.HEARTS, 12);
  }

  /**
   * Tests the constructor with suit and face.
   */
  @Test
  public void testConstructorWithSuitAndFace() {
    assertEquals(Suit.SPADES, aceOfSpades.suit());
    assertEquals(1, aceOfSpades.face());
    assertEquals(Suit.HEARTS, queenOfHearts.suit());
    assertEquals(12, queenOfHearts.face());
  }


  /**
   * Tests the constructor with invalid face values.
   */
  @Test
  public void testConstructorWithInvalidFace() {
    Exception exceptionBelow = assertThrows(IllegalArgumentException.class, () -> {
      new PlayingCards(Suit.SPADES, 0);
    });
    assertEquals("Face value must be between 1 and 13.", exceptionBelow.getMessage());

    Exception exceptionAbove = assertThrows(IllegalArgumentException.class, () -> {
      new PlayingCards(Suit.SPADES, 14);
    });
    assertEquals("Face value must be between 1 and 13.", exceptionAbove.getMessage());
  }

  /**
   * Tests the constructor with suit symbol.
   */
  @Test
  public void testConstructorWithSuitSymbol() {
    PlayingCards card = new PlayingCards('♠', 5);
    assertEquals(Suit.SPADES, card.suit());
    assertEquals(5, card.face());
  }


  /**
   * Tests the suit symbol method.
   */
  @Test
  public void testSuitSymbol() {
    assertEquals('♠', aceOfSpades.suitSymbol());
    assertEquals('♥', queenOfHearts.suitSymbol());
  }


  /**
   * Tests the isRed method.
   */
  @Test
  public void testIsRed() {
    assertFalse(aceOfSpades.isRed());
    assertTrue(queenOfHearts.isRed());
  }


  /**
   * Tests the face as string method.
   */
  @Test
  public void testFaceAsString() {
    assertEquals("A", aceOfSpades.faceAsString());
    assertEquals("Q", queenOfHearts.faceAsString());
    PlayingCards fiveOfClubs = new PlayingCards(Suit.CLUBS, 5);
    assertEquals("5", fiveOfClubs.faceAsString());
    PlayingCards jackOfDiamonds = new PlayingCards(Suit.DIAMONDS, 11);
    assertEquals("J", jackOfDiamonds.faceAsString());
    PlayingCards kingOfSpades = new PlayingCards(Suit.SPADES, 13);
    assertEquals("K", kingOfSpades.faceAsString());
  }


  /**
   * Tests the to string method.
   */
  @Test
  public void testToString() {
    assertEquals("♠1", aceOfSpades.toString());
    assertEquals("♥12", queenOfHearts.toString());
  }
}