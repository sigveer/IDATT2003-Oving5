package com.sigveer.Utils;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * {@code StyleUtils} provides utility methods for styling JavaFX components.
 */
public class StyleUtils {

  public static final String CARD_STYLE = "-fx-background-color: #ffffff; " +
      "-fx-border-color: #333333; " +
      "-fx-border-width: 2px; " +
      "-fx-border-radius: 8px; " +
      "-fx-background-radius: 8px; " +
      "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 5, 0, 1, 2);";

  public static final String CARD_DISPLAY_BOX_STYLE = "-fx-background-color: #457b9d; " +
      "-fx-border-color: #1d3557; " +
      "-fx-border-width: 3px; " +
      "-fx-border-radius: 10px; " +
      "-fx-background-radius: 10px; " +
      "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.4), 10, 0, 2, 3);";

  public static final String RED_SUIT_STYLE = "-fx-font-size: 36px; -fx-text-fill: #e63946; -fx-font-weight: bold;";
  public static final String BLACK_SUIT_STYLE = "-fx-font-size: 36px; -fx-text-fill: #1d3557; -fx-font-weight: bold;";
  public static final String FACE_STYLE = "-fx-font-size: 24px; -fx-text-fill: #333333; -fx-font-weight: bold;";

  public static final String MAIN_LAYOUT_STYLE = "-fx-background-color: #236788;";

  public static final String TITLE_STYLE = "-fx-font-size: 48px; " +
      "-fx-text-fill: White; " +
      "-fx-font-weight: bold; " +
      "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 4, 0, 1, 2);";

  public static final String STATUS_PANEL_STYLE = "-fx-background-color: #457b9d; " +
      "-fx-border-color: #1d3557; " +
      "-fx-border-width: 3px; " +
      "-fx-border-radius: 10px; " +
      "-fx-background-radius: 10px; " +
      "-fx-padding: 15px; " +
      "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.4), 10, 0, 2, 3);";

  public static final String STATUS_LABEL_STYLE = "-fx-font-size: 18px; " +
      "-fx-text-fill: White; " +
      "-fx-font-weight: bold; " +
      "-fx-padding: 5px;";

  public static final String PLACEHOLDER_LABEL_STYLE = "-fx-font-size: 18px; " +
      "-fx-text-fill: White; " +
      "-fx-font-weight: bold; " +
      "-fx-font-style: italic;";

  private static final String BUTTON_NORMAL_STYLE =
      "-fx-background-color: linear-gradient(to bottom, #377fa5, #075a61); " +
          "-fx-text-fill: white; " +
          "-fx-font-weight: bold; " +
          "-fx-font-size: 20px; " +
          "-fx-padding: 15px 25px; " +
          "-fx-border-radius: 7,5px; " +
          "-fx-background-radius: 7,5px; " +
          "-fx-border-color: #2d2f33; " +
          "-fx-border-width: 3px; " +
          "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 8, 0, 2, 2);";

  private static final String BUTTON_HOVER_STYLE =
      "-fx-background-color: linear-gradient(to bottom, #377fa5, #075a61); " +
          "-fx-text-fill: white; " +
          "-fx-font-weight: bold; " +
          "-fx-font-size: 20px; " +
          "-fx-padding: 15px 25px; " +
          "-fx-border-radius: 7,5px; " +
          "-fx-background-radius: 7,5px; " +
          "-fx-border-color: #2d2f33; " +
          "-fx-border-width: 3px; " +
          "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 10, 0, 3, 3);";

  private static final String BUTTON_PRESSED_STYLE =
      "-fx-background-color: linear-gradient(to top, #377fa5, #075a61); " +
          "-fx-text-fill: white; " +
          "-fx-font-weight: bold; " +
          "-fx-font-size: 20px; " +
          "-fx-padding: 15px 25px 12px 25px; " +
          "-fx-border-radius: 7,5px; " +
          "-fx-background-radius: 7,5px; " +
          "-fx-border-color: #2d2f33; " +
          "-fx-border-width: 3px; " +
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