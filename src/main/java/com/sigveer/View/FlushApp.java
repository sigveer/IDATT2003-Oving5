package com.sigveer.View;

import com.sigveer.Controller.GameController;
import com.sigveer.Utils.StyleUtils;
import com.sigveer.View.Components.HandPanel;
import com.sigveer.View.Components.StatusPanel;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * {@code FlushApp} represents the main application for the Flush game.
 */
public class FlushApp extends Application {
    private GameController gameController;
    private HandPanel handPanel;
    private StatusPanel statusPanel;


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

        VBox mainLayout = createMainLayout();

        Scene scene = new Scene(mainLayout, 700, 500);
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
        VBox mainLayout = new VBox(20);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setStyle(StyleUtils.MAIN_LAYOUT_STYLE);

        Label title = createTitle();

        handPanel = new HandPanel();

        HBox buttonBox = createButtonBox();

        statusPanel = new StatusPanel();

        mainLayout.getChildren().addAll(title, handPanel, buttonBox, statusPanel);

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
        Label title = new Label("FLUSH!");
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

        Button checkButton = new Button("Check hand");
        StyleUtils.styleButton(checkButton);
        checkButton.setOnAction(e -> handleCheckButtonAction());

        buttonBox.getChildren().addAll(dealButton, checkButton);

        return buttonBox;
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