package com.sigveer.Utils;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * {@code StyleUtils} provides utility methods for styling JavaFX components.
 */
public class StyleUtils {

  public static final String CARD_STYLE = "-fx-background-color: #ffffff; -fx-border-color: #000000; -fx-border-width: 2px;";
  public static final String RED_SUIT_STYLE = "-fx-font-size: 30px; -fx-text-fill: #ff0000;";
  public static final String BLACK_SUIT_STYLE = "-fx-font-size: 30px; -fx-text-fill: #000000;";
  public static final String FACE_STYLE = "-fx-font-size: 20px; -fx-text-fill: #000000;";

  public static final String CARD_DISPLAY_BOX_STYLE = "-fx-background-color: #8e8b8b; -fx-border-color: #000000; -fx-border-width: 2px;";

  public static final String MAIN_LAYOUT_STYLE = "-fx-background-color: #f4f4f4;";

  public static final String TITLE_STYLE = "-fx-font-size: 40px; -fx-text-fill: #000000; -fx-font-weight: bold;";

  public static final String STATUS_LABEL_STYLE = "-fx-font-size: 16px; -fx-text-fill: #000000;";

  public static final String PLACEHOLDER_LABEL_STYLE = "-fx-font-size: 16px; -fx-text-fill: #ffffff;";

  private static final String BUTTON_NORMAL_STYLE =
      "-fx-background-color: linear-gradient(to bottom, #4a6cd4, #283a60); " +
          "-fx-text-fill: white; " +
          "-fx-font-size: 16px; " +
          "-fx-padding: 10px 20px; " +
          "-fx-border-radius: 5px; " +
          "-fx-background-radius: 5px; " +
          "-fx-border-color: #1f2a44; " +
          "-fx-border-width: 2px; " +
          "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 8, 0, 2, 2);";

  private static final String BUTTON_HOVER_STYLE =
      "-fx-background-color: linear-gradient(to bottom, #5c7ee8, #2e4370); " +
          "-fx-text-fill: white; " +
          "-fx-font-size: 16px; " +
          "-fx-padding: 10px 20px; " +
          "-fx-border-radius: 5px; " +
          "-fx-background-radius: 5px; " +
          "-fx-border-color: #1f2a44; " +
          "-fx-border-width: 2px; " +
          "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 10, 0, 3, 3);";

  private static final String BUTTON_PRESSED_STYLE =
      "-fx-background-color: linear-gradient(to top, #283a60, #3a5590); " +
          "-fx-text-fill: white; " +
          "-fx-font-size: 16px; " +
          "-fx-padding: 12px 20px 8px 20px; " +
          "-fx-border-radius: 5px; " +
          "-fx-background-radius: 5px; " +
          "-fx-border-color: #1f2a44; " +
          "-fx-border-width: 2px; " +
          "-fx-effect: innershadow(gaussian, rgba(0,0,0,0.7), 5, 0, 0, 0);";

  /**
   * Applies styling to a button.
   *
   * @param button The button to style.
   * @LastEdited: 1.1
   * @Since: 1.0
   */
  public static void styleButton(Button button) {
    button.setStyle(BUTTON_NORMAL_STYLE);

    button.setOnMouseEntered(e -> button.setStyle(BUTTON_HOVER_STYLE));
    button.setOnMouseExited(e -> button.setStyle(BUTTON_NORMAL_STYLE));
    button.setOnMousePressed(e -> button.setStyle(BUTTON_PRESSED_STYLE));
    button.setOnMouseReleased(e -> button.setStyle(BUTTON_HOVER_STYLE));
  }

  /**
   * Applies styling to a status label.
   *
   * @param label The label to style.
   * @LastEdited: 1.1
   * @Since: 1.1
   */
  public static void styleStatusLabel(Label label) {
    label.setStyle(STATUS_LABEL_STYLE);
  }
}