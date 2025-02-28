package com.sigveer.View.Components;

import com.sigveer.Model.HandOfCards;
import com.sigveer.Model.PlayingCards;
import com.sigveer.Utils.StyleUtils;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * {@code HandPanel} represents a UI component for displaying a hand of cards.
 */
public class HandPanel extends VBox {
  private final HBox handDisplay;
  private final Label placeholderLabel;

  /**
   * Constructor that creates a new hand panel.
   */
  public HandPanel() {
    super(10);

    this.setStyle(StyleUtils.CARD_DISPLAY_BOX_STYLE);
    this.setPrefSize(400, 150);
    this.setMaxWidth(400);
    this.setMaxHeight(150);
    this.setAlignment(Pos.CENTER);

    handDisplay = new HBox(10);
    handDisplay.setAlignment(Pos.CENTER);

    placeholderLabel = new Label("Click 'Deal hand' to get a hand of cards");
    placeholderLabel.setStyle(StyleUtils.PLACEHOLDER_LABEL_STYLE);

    this.getChildren().addAll(placeholderLabel, handDisplay);
  }

  /**
   * Updates the hand display with a new hand of cards.
   *
   * @param hand The hand of cards to display.
   */
  public void updateHandDisplay(HandOfCards hand) {
    handDisplay.getChildren().clear();
    placeholderLabel.setVisible(false);

    for (PlayingCards card : hand.hand()) {
      CardComponents cardComponents = new CardComponents(card);
      handDisplay.getChildren().add(cardComponents);
    }
  }
}