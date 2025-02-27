package com.sigveer.View;

import com.sigveer.Model.DeckOfCards;
import com.sigveer.Model.HandOfCards;
import com.sigveer.Model.PlayingCards;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import static com.sigveer.Utils.JavaFX_GUI.styleButton;

public class FlushApp extends Application {

    private DeckOfCards deck;
    private HandOfCards currentHand;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("FLUSHGAME!");
        primaryStage.setX(250);
        primaryStage.setY(100);

        VBox mainLayout = new VBox(20);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setStyle("-fx-background-color: #f4f4f4;");

        Label title = new Label("FLUSH!");
        title.setStyle("-fx-font-size: 40px; -fx-text-fill: #000000; -fx-font-weight: bold;");

        VBox cardDisplayBox = new VBox(10);
        cardDisplayBox.setStyle("-fx-background-color: #8e8b8b; -fx-border-color: #000000; -fx-border-width: 2px;");
        cardDisplayBox.setPrefSize(400, 200);
        cardDisplayBox.setAlignment(Pos.CENTER);

        HBox handDisplay = new HBox(10);
        handDisplay.setAlignment(Pos.CENTER);
        Label placeholderLabel = new Label("Click 'Deal hand' to get a hand of cards");
        placeholderLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #ffffff;");
        cardDisplayBox.getChildren().addAll(placeholderLabel, handDisplay);

        HBox buttonBox = new HBox(20);
        buttonBox.setAlignment(Pos.CENTER);
        Button dealButton = new Button("Deal hand");
        styleButton(dealButton);
        Button checkButton = new Button("Check hand");
        styleButton(checkButton);
        buttonBox.getChildren().addAll(dealButton, checkButton);

        VBox statusBox = new VBox(10);
        statusBox.setAlignment(Pos.CENTER);
        Label sumLabel = new Label("Sum of the faces: ");
        sumLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #000000;");
        Label cardsLabel = new Label("Cards of hearts: ");
        cardsLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #000000;");
        Label queenOfSpadesLabel = new Label("Queen of spades: ");
        queenOfSpadesLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #000000;");
        Label flushLabel = new Label("Flush: ");
        flushLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #000000;");
        statusBox.getChildren().addAll(sumLabel, cardsLabel, queenOfSpadesLabel, flushLabel);

        mainLayout.getChildren().addAll(title, cardDisplayBox, buttonBox, statusBox);

        Scene scene = new Scene(mainLayout, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

        deck = new DeckOfCards();

        dealButton.setOnAction(e -> {
            currentHand = deck.dealHand(5);

            // Tøm tidligere kort og skjul placeholder
            handDisplay.getChildren().clear();
            placeholderLabel.setVisible(false);


            for (PlayingCards card : currentHand.hand()) {
                Label cardLabel = new Label(card.toString());
                cardLabel.setStyle("-fx-font-size: 36px;");

                switch (card.suit()) {
                    case '♥':
                    case '♦':
                        cardLabel.setStyle("-fx-font-size: 36px; -fx-text-fill: #ff0000;");
                        break;
                    case '♠':
                    case '♣':
                        cardLabel.setStyle("-fx-font-size: 36px; -fx-text-fill: #000000;");
                        break;
                }
                handDisplay.getChildren().add(cardLabel);
            }

            sumLabel.setText("Sum of the faces: ");
            cardsLabel.setText("Cards of hearts: ");
            queenOfSpadesLabel.setText("Queen of spades: ");
            flushLabel.setText("Flush: ");
        });

        checkButton.setOnAction(e -> {
            if (currentHand != null) {
                int sum = currentHand.hand().stream()
                    .mapToInt(PlayingCards::face)
                    .sum();
                sumLabel.setText("Sum of the faces: " + sum);

                String heartsCards = currentHand.hand().stream()
                    .filter(card -> card.suit() == '♥')
                    .map(PlayingCards::toString)
                    .collect(Collectors.joining(" "));
                cardsLabel.setText("Cards of hearts: " + (heartsCards.isEmpty() ? "None" : heartsCards));

                boolean hasQueenOfSpades = currentHand.hand().stream()
                    .anyMatch(card -> card.suit() == '♠' && card.face() == 12);
                queenOfSpadesLabel.setText("Queen of spades: " + (hasQueenOfSpades ? "Yes" : "No"));

                boolean isFlush = currentHand.checkFlush();
                flushLabel.setText("Flush: " + (isFlush ? "Yes" : "No"));
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}