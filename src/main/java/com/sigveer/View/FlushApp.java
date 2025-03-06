package com.sigveer.View;

import com.sigveer.Controller.GameController;
import com.sigveer.Utils.StyleUtils;
import com.sigveer.View.Components.HandPanel;
import com.sigveer.View.Components.StatusPanel;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * {@code FlushApp} represents the main application for the Flush game.
 */
public class FlushApp extends Application {
    private GameController gameController;
    private HandPanel handPanel;
    private StatusPanel statusPanel;
    private Label messageLabel;


    /**
     * Starts the application.
     *
     * @param primaryStage The primary stage.
     * @LastEdited: 1.1
     * @Since: 1.1
     */
    @Override
    public void start(Stage primaryStage) {
        gameController = new GameController();

        primaryStage.setTitle("FLUSHGAME!");
        primaryStage.setX(250);
        primaryStage.setY(100);
        primaryStage.setX(250);
        primaryStage.setY(100);

        VBox mainLayout = createMainLayout();

        Scene scene = new Scene(mainLayout, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
     * Creates the main layout for the application.
     *
     * @return The main layout.
     * @LastEdited: 1.1
     * @Since: 1.1
     */
    private VBox createMainLayout() {
        VBox mainLayout = new VBox(30);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(30));
        mainLayout.setStyle(StyleUtils.MAIN_LAYOUT_STYLE);

        Label title = createTitle();

        handPanel = new HandPanel();

        messageLabel = new Label("Velkommen til FLUSH Card Game!");
        messageLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: #ffffff; -fx-font-weight: bold;");
        messageLabel.setOpacity(0.8);

        HBox buttonBox = createButtonBox();

        statusPanel = new StatusPanel();

        Region topSpacer = new Region();
        VBox.setVgrow(topSpacer, Priority.ALWAYS);
        topSpacer.setMinHeight(10);
        topSpacer.setMaxHeight(30);

        Region bottomSpacer = new Region();
        VBox.setVgrow(bottomSpacer, Priority.ALWAYS);
        bottomSpacer.setMinHeight(10);
        bottomSpacer.setMaxHeight(30);

        mainLayout.getChildren().addAll(topSpacer, title, handPanel, messageLabel, buttonBox, statusPanel, bottomSpacer);

        return mainLayout;
    }


    /**
     * Creates the title label.
     *
     * @return The title label.
     * @LastEdited: 1.1
     * @Since: 1.1
     */
    private Label createTitle() {
        Label title = new Label("♦♠FLUSHGAME♥♣");
        title.setStyle(StyleUtils.TITLE_STYLE);
        return title;
    }


    /**
     * Creates the button box with deal and check buttons.
     *
     * @return The button box.
     * @LastEdited: 1.1
     * @Since: 1.1
     */
    private HBox createButtonBox() {
        HBox buttonBox = new HBox(20);
        buttonBox.setAlignment(Pos.CENTER);

        Button dealButton = new Button("Deal hand");
        StyleUtils.styleButton(dealButton);
        dealButton.setOnAction(e -> handleDealButtonAction());

        Button checkButton = new Button("\uD83D\uDD0D Check hand");
        StyleUtils.styleButton(checkButton);
        checkButton.setOnAction(e -> handleCheckButtonAction());

        buttonBox.getChildren().addAll(dealButton, checkButton);

        return buttonBox;
    }

    /**
     * This method is made by AI (Claude)
     * Updates the message with animation.
     *
     * @param message The new message
     * @LastEdited: 1.1
     * @Since: 1.1
     */
    private void updateMessage(String message) {
        FadeTransition fadeOut = new FadeTransition(Duration.millis(200), messageLabel);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        FadeTransition fadeIn = new FadeTransition(Duration.millis(200), messageLabel);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        fadeOut.setOnFinished(e -> {
            messageLabel.setText(message);
            fadeIn.play();
        });

        fadeOut.play();
    }


    /**
     * Handles the deal button action.
     *
     * @LastEdited: 1.1
     * @Since: 1.1
     */
    private void handleDealButtonAction() {
        gameController.dealHand(5);
        handPanel.updateHandDisplay(gameController.getCurrentHand());
        statusPanel.resetLabels();
        updateMessage("Ny hånd delt ut! Klikk 'Sjekk hånd' for å se resultatet.");
    }


    /**
     * Handles the check button action.
     * @LastEdited: 1.1
     * @Since: 1.1
     */
    private void handleCheckButtonAction() {
        if (gameController.getCurrentHand() != null) {
            statusPanel.updateSumLabel(gameController.calculateFaceSum());
            statusPanel.updateCardsLabel(gameController.getHeartsCards());
            statusPanel.updateQueenOfSpadesLabel(gameController.hasQueenOfSpades());
            statusPanel.updateFlushLabel(gameController.hasFlush());

            if (gameController.hasFlush()) {
                updateMessage("GRATULERER! Du har en FLUSH! 🎉");
            } else {
                updateMessage("Hånd er sjekket! Ingen FLUSH denne gangen. Prøv igjen!");
            }
        } else {
            updateMessage("Du må dele ut en hånd først!");
        }
    }


    /**
     * Launches the application.
     *
     * @param args The command line arguments.
     * @LastEdited: 1.1
     * @Since: 1.0
     */
    public static void main(String[] args) {
        launch(args);
    }
}