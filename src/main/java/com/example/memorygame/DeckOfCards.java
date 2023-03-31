/**
 *The code defines a public class called "DeckOfCards".
 * The class has a private instance variable called "deck" that is an ArrayList of Card objects.
 * The class has a constructor that initializes the "deck" variable as an empty ArrayList and then populates it with all possible combinations of suits and face names using the "Card" class's "getValidSuits" and "getValidFaceNames" methods.
 * The class has a method called "shuffle" that shuffles the cards in the "deck" variable using the "Collections.shuffle" method.
 * The class has a method called "dealTopCard" that removes and returns the top card from the "deck" variable, or returns null if the deck is empty.
 * The class has a method called "getNumOfCards" that returns the number of cards left in the "deck" variable.
 */

package com.example.memorygame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    private ArrayList<Card> deck;

    public DeckOfCards() {
        this.deck = new ArrayList<>();
        List<String> suits = Card.getValidSuits();
        List<String> faceNames = Card.getValidFaceNames();

        for (String suit : suits)
        {
            for (String faceName : faceNames)
            {
                deck.add(new Card(suit,faceName));
            }
        }
    }

    /**
     * This method will shuffle the card objects
     */
    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    /**
     * This method will return the top card from the deck.
     * If the deck is empty, it will return null
     */
    public Card dealTopCard()
    {
        if (deck.size()>0)
            return deck.remove(0);
        else
            return null;
    }

    /**
     * This returns the number of cards left in the deck
     */
    public int getNumOfCards()
    {
        return deck.size();
    }
}