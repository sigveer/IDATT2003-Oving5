package com.sigveer.View.Components;

import com.sigveer.Utils.StyleUtils;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * {@code StatusPanel} represents a UI component for displaying game status information.
 */
public class StatusPanel extends VBox {
  private final Label sumLabel;
  private final Label cardsLabel;
  private final Label queenOfSpadesLabel;
  private final Label flushLabel;

  /**
   * Constructor that creates a new status panel.
   * @LastEdited: 1.1
   * @Since: 1.0
   */
  public StatusPanel() {
    super(15);

    this.setAlignment(Pos.CENTER_LEFT);
    this.setStyle(StyleUtils.STATUS_PANEL_STYLE);
    this.setPrefSize(900, 400);
    this.setMaxWidth(900);
    this.setMaxHeight(300);


    sumLabel = new Label("Sum of the faces: ");
    StyleUtils.styleStatusLabel(sumLabel);

    cardsLabel = new Label("Cards of hearts: ");
    StyleUtils.styleStatusLabel(cardsLabel);

    queenOfSpadesLabel = new Label("Queen of spades: ");
    StyleUtils.styleStatusLabel(queenOfSpadesLabel);

    flushLabel = new Label("Flush: ");
    StyleUtils.styleStatusLabel(flushLabel);

    this.getChildren().addAll(sumLabel, cardsLabel, queenOfSpadesLabel, flushLabel);
  }

  /**
   * Updates the sum of faces label.
   *
   * @param sum The sum of faces.
   * @LastEdited: 1.1
   * @Since: 1.0
   */
  public void updateSumLabel(int sum) {
    sumLabel.setText("Sum of the faces: " + sum);
  }

  /**
   * Updates the hearts cards label.
   *
   * @param cards The hearts cards string.
   * @LastEdited: 1.1
   * @Since: 1.0
   */
  public void updateCardsLabel(String cards) {
    cardsLabel.setText("Cards of hearts: " + (cards.isEmpty() ? "None" : cards));
  }

  /**
   * Updates the queen of spades label.
   *
   * @param hasQueenOfSpades Whether the hand has the queen of spades.
   * @LastEdited: 1.1
   * @Since: 1.0
   */
  public void updateQueenOfSpadesLabel(boolean hasQueenOfSpades) {
    queenOfSpadesLabel.setText("Queen of spades: " + (hasQueenOfSpades ? "Yes" : "No"));
  }

  /**
   * Updates the flush label.
   *
   * @param hasFlush Whether the hand has a flush.
   * @LastEdited: 1.1
   * @Since: 1.0
   */
  public void updateFlushLabel(boolean hasFlush) {
    flushLabel.setText("Flush: " + (hasFlush ? "Yes" : "No"));
  }

  /**
   * Resets all status labels to their initial state.
   * @LastEdited: 1.1
   * @Since: 1.0
   */
  public void resetLabels() {
    sumLabel.setText("Sum of the faces: ");
    cardsLabel.setText("Cards of hearts: ");
    queenOfSpadesLabel.setText("Queen of spades: ");
    flushLabel.setText("Flush: ");
  }
}