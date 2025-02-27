package com.sigveer.Model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * {@code HandOfCards} represents a hand of cards.
 */
public record HandOfCards(List<PlayingCards> hand) {

  /**
   * Constructor that creates a hand of cards.
   *
   * @param hand The hand of cards.
   * @LastEdited: 1.0
   * @Since: 1.0
   */
  public HandOfCards {
  }


  /**
   * Method that returns the hand of cards.
   *
   * @return The hand of cards.
   * @LastEdited: 1.0
   * @Since: 1.0
   */
  @Override
  public List<PlayingCards> hand() {
    return hand;
  }


  /**
   * Method that checks if the hand contains a flush.
   *
   * @return True if the hand contains a flush, false otherwise.
   * @LastEdited: 1.0
   * @Since: 1.0
   */
  public boolean checkFlush() {
    Map<Character, Long> suitCounts = hand.stream()
        .collect(Collectors.groupingBy(PlayingCards::suit, Collectors.counting()));
    return suitCounts.values().stream().anyMatch(count -> count >= 5);
  }


  /**
   * Method that checks if the hand contains a straight.
   *
   * @return True if the hand contains a straight, false otherwise.
   * @LastEdited: 1.0
   * @Since: 1.0
   */
  @Override
  public String toString() {
    return hand.stream()
        .map(PlayingCards::toString)
        .collect(Collectors.joining(" "));
  }
}
