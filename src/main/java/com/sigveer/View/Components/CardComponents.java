package com.sigveer.View.Components;

import com.sigveer.Model.PlayingCards;
import com.sigveer.Utils.StyleUtils;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * {@code CardComponent} represents a UI component for displaying a playing card.
 */
public class CardComponents extends VBox {
  private final Label faceLabel;
  private final Label suitLabel;


  /**
   * Constructor that creates a new card component.
   *
   * @param card The card to display.
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  public CardComponents(PlayingCards card) {
    super(5);

    this.setAlignment(Pos.CENTER);
    this.setPrefSize(60, 90);
    this.setStyle(StyleUtils.CARD_STYLE);

    faceLabel = new Label(card.faceAsString());
    faceLabel.setStyle(StyleUtils.FACE_STYLE);

    suitLabel = new Label(String.valueOf(card.suitSymbol()));
    if (card.isRed()) {
      suitLabel.setStyle(StyleUtils.RED_SUIT_STYLE);
    } else {
      suitLabel.setStyle(StyleUtils.BLACK_SUIT_STYLE);
    }

    this.getChildren().addAll(faceLabel, suitLabel);
  }
}