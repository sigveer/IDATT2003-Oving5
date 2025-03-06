package com.sigveer.View.Components;

import com.sigveer.Model.HandOfCards;
import com.sigveer.Model.PlayingCards;
import com.sigveer.Utils.StyleUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

/**
 * {@code HandPanel} represents a UI component for displaying a hand of cards.
 */
public class HandPanel extends VBox {
  private final HBox handDisplay;
  private final Label placeholderLabel;

  /**
   * Constructor that creates a new hand panel.
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  public HandPanel() {
    super(15);

    this.setStyle(StyleUtils.CARD_DISPLAY_BOX_STYLE);
    this.setPrefSize(900, 400);
    this.setMaxWidth(900);
    this.setMaxHeight(300);
    this.setAlignment(Pos.CENTER);

    handDisplay = new HBox(15);
    handDisplay.setAlignment(Pos.CENTER);

    placeholderLabel = new Label("Click 'Deal hand' to get a hand of cards");
    placeholderLabel.setStyle(StyleUtils.PLACEHOLDER_LABEL_STYLE);

    this.getChildren().addAll(placeholderLabel, handDisplay);
  }

  /**
   * Made with help of AI (ChatGPT)
   * Updates the hand display with a new hand of cards.
   *
   * @param hand The hand of cards to display.
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  public void updateHandDisplay(HandOfCards hand) {
    handDisplay.getChildren().clear();
    placeholderLabel.setVisible(false);

    int delay = 0;
    for (PlayingCards card : hand.hand()) {
      CardComponents cardComponent = new CardComponents(card);

      cardComponent.setScaleX(0.1);
      cardComponent.setScaleY(0.1);
      cardComponent.setOpacity(0);
      cardComponent.setTranslateY(50);

      handDisplay.getChildren().add(cardComponent);

      ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(300), cardComponent);
      scaleTransition.setToX(1.0);
      scaleTransition.setToY(1.0);

      FadeTransition fadeTransition = new FadeTransition(Duration.millis(300), cardComponent);
      fadeTransition.setToValue(1.0);

      TranslateTransition translateTransition = new TranslateTransition(Duration.millis(300), cardComponent);
      translateTransition.setToY(0);

      SequentialTransition sequentialTransition = new SequentialTransition(cardComponent);
      sequentialTransition.getChildren().addAll(scaleTransition, fadeTransition, translateTransition);
      sequentialTransition.setDelay(Duration.millis(delay));
      sequentialTransition.play();

      delay += 150;
    }
  }
}