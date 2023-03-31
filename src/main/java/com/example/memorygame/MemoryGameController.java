/**
 *Initialize a deck of cards.
 * Shuffle the deck of cards.
 * Deal the top card from the deck and create two MemoryCard objects with the same suit and face name.
 * Add the two MemoryCard objects to the list of cards in the game.
 * Repeat steps 3-4 until all cards have been dealt and added to the list.
 * Shuffle the list of cards in the game.
 * Flip all cards over to show the back of the card.
 * Initialize the ImageViews for each card on the game board.
 * Set the image for each ImageView to be the back of a card.
 * Add a click listener to each ImageView that calls the flipCard() method.
 * When a card is flipped, check if it is the first or second card flipped.
 * If it is the first card, set the firstCard variable to the MemoryCard object associated with the ImageView.
 * If it is the second card, set the secondCard variable to the MemoryCard object associated with the ImageView.
 * Check if the two MemoryCard objects match.
 * If they match, increment the number of matches and set the matched variable for both MemoryCard objects to true.
 * If they don't match, flip both cards back over to show the back of the card.
 * Update the labels for the number of correct guesses and total guesses made.
 * Repeat steps 11-17 until all pairs have been matched.
 * End the game.
 */
package com.example.memorygame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class MemoryGameController implements Initializable {

    @FXML
    private Label correctGuessesLabel;

    @FXML
    private Label guessLabel;

    @FXML
    private FlowPane imagesFlowPane;

    private ArrayList<MemoryCard> cardsInGame;

    private MemoryCard firstCard, secondCard;
    private int numOfGuess;
    private int numOfMatches;

    @FXML
    void playAgain() {
        firstCard=null;
        secondCard =null;

        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        cardsInGame = new ArrayList<>();

        for (int i =0; i<imagesFlowPane.getChildren().size()/2; i++)
        {
            Card cardDealt = deck.dealTopCard();
            cardsInGame.add(new MemoryCard(cardDealt.getSuit(),cardDealt.getFaceName()));
            cardsInGame.add(new MemoryCard(cardDealt.getSuit(),cardDealt.getFaceName()));
        }
        Collections.shuffle(cardsInGame);
        flipAllCards();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeImageView();
        playAgain();
    }

    /**
     * This will add a number to each ImageView and set the image to be the back of a Card
     */
    private void initializeImageView()
    {
        for (int i=0; i<imagesFlowPane.getChildren().size();i++)
        {
            //"cast" the Node to be of type ImageView
            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);
            imageView.setImage(new Image(Card.class.getResourceAsStream("images/back_of_card.png")));
            imageView.setUserData(i);

            //register a click listener
            imageView.setOnMouseClicked(event -> {
                flipCard((int) imageView.getUserData());
            });
        }
    }

    /**
     * This will show the back of all cards that are not matched
     */
    private void flipAllCards()
    {
        for (int i=0; i<cardsInGame.size();i++)
        {
            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);
            MemoryCard card = cardsInGame.get(i);

            if (card.isMatched())
                imageView.setImage(card.getImage());
            else
                imageView.setImage(card.getBackOfCardImage());
        }
    }

    private void flipCard(int indexOfCard)
    {
        if (firstCard==null && secondCard==null)
            flipAllCards();

        ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(indexOfCard);

        if (firstCard==null)
        {
            firstCard = cardsInGame.get(indexOfCard);
            imageView.setImage(firstCard.getImage());
        }
        else if (secondCard==null)
        {
            numOfGuess++;
            secondCard = cardsInGame.get(indexOfCard);
            imageView.setImage(secondCard.getImage());
            checkForMatch();
            updateLabels();
        }
    }

    private void updateLabels()
    {
        correctGuessesLabel.setText(Integer.toString(numOfMatches));
        guessLabel.setText(Integer.toString(numOfGuess));
    }

    private void checkForMatch()
    {
        if (firstCard.isSameCard(secondCard))
        {
            numOfMatches++;
            firstCard.setMatched(true);
            secondCard.setMatched(true);
        }
        firstCard=null;
        secondCard=null;
    }}