package com.sigveer.Model;

import java.util.List;
import java.util.stream.Collectors;


/**
 * {@code HandOfCards} represents a hand of cards.
 */
public record HandOfCards(List<PlayingCards> hand) {

  /**
   * Constructor that creates a hand of cards.
   *
   * @param hand The hand of cards.
   * @LastEdited: 1.1
   * @Since: 1.0
   */
  public HandOfCards {
    hand = List.copyOf(hand);
  }


  /**
   * Method that checks if the hand contains a flush.
   *
   * @return True if the hand contains a flush, false otherwise.
   * @LastEdited: 1.1
   * @Since: 1.0
   */
  public boolean checkFlush() {
    return hand.stream()
        .collect(Collectors.groupingBy(PlayingCards::suit))
        .values().stream()
        .anyMatch(card -> card.size() >= 5);
  }


  /**
   * Method that checks if the hand contains a specific card.
   *
   * @param suit The suit of the card.
   * @param face The face of the card.
   * @return True if the hand contains the card, false otherwise.
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  public boolean containsCard(Suit suit, int face) {
    return hand.stream()
        .anyMatch(card -> card.suit() == suit && card.face() == face);
  }


  /**
   * Method that calculates the sum of the faces of the cards in the hand.
   *
   * @return The sum of the faces of the cards in the hand.
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  public int sumOfFaces() {
    return hand.stream()
        .mapToInt(PlayingCards::face)
        .sum();
  }


  /**
   * Method that returns the cards of a specific suit in the hand.
   *
   * @param suit The suit of the cards.
   * @return The cards of a specific suit in the hand.
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  public List<PlayingCards> getCardsBySuit(Suit suit) {
    return hand.stream()
        .filter(card -> card.suit() == suit)
        .collect(Collectors.toList());
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
