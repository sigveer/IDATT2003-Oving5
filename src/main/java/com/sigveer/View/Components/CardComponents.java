package com.sigveer.View.Components;

import com.sigveer.Model.PlayingCards;
import com.sigveer.Utils.StyleUtils;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

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
    Rectangle cardBackground = new Rectangle(80, 20);
    cardBackground.setArcWidth(16);
    cardBackground.setArcHeight(16);
    cardBackground.setStyle("-fx-fill: white;");

    this.getChildren().add(cardBackground);
    this.setStyle(StyleUtils.CARD_STYLE);

    VBox mainContent = new VBox(10);
    mainContent.setAlignment(Pos.CENTER);

    faceLabel = new Label(card.faceAsString());
    faceLabel.setStyle(StyleUtils.FACE_STYLE);

    suitLabel = new Label(String.valueOf(card.suitSymbol()));
    suitLabel.setStyle(card.isRed() ? StyleUtils.RED_SUIT_STYLE : StyleUtils.BLACK_SUIT_STYLE);

    mainContent.getChildren().addAll(faceLabel, suitLabel);


    this.getChildren().addAll(mainContent);
  }
}