/**
 * The code defines a public class called "Card" in the package "com.example.memorygame".
 * The class has two private instance variables: "suit" and "faceName".
 * The class has a constructor that takes in a suit and faceName as parameters and sets them using the corresponding setter methods.
 * The class has getter and setter methods for the suit and faceName variables.
 * The class has a method called "getValidSuits" that returns a list of valid suits.
 * The class has a method called "getValidFaceNames" that returns a list of valid face names.
 * The class has a toString method that returns a string representation of the card.
 * The class has a getValue method that returns the numerical value of the card.
 * The class has a method called "getImage" that returns an image that represents the card.
 * The class has a method called "getBackOfCardImage" that returns an image of the back of the card.
 */



package com.example.memorygame;

import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;

public class Card {
    private String suit;
    private String faceName;

    public Card(String suit, String faceName) {
        setSuit(suit);
        setFaceName(faceName);
    }

    public String getSuit() {
        return suit;
    }

    public static List<String> getValidSuits()
    {
        return Arrays.asList("hearts","diamonds","clubs","spades");
    }

    /**
     * valid suits are "hearts","diamonds","clubs","spades"
     */
    public void setSuit(String suit) {
        suit = suit.toLowerCase();
        if (getValidSuits().contains(suit))
            this.suit = suit;
        else
            throw new IllegalArgumentException(suit + " invalid, must be one of "+getValidSuits());
    }

    public String getFaceName() {
        return faceName;
    }

    public static List<String> getValidFaceNames()
    {
        return Arrays.asList("2","3","4","5","6","7","8","9","10","jack","queen","king","ace");
    }


    public void setFaceName(String faceName) {
        faceName = faceName.toLowerCase();
        if (getValidFaceNames().contains(faceName))
            this.faceName = faceName;
        else
            throw new IllegalArgumentException(faceName + " is invalid, must be one of "+getFaceName());
    }

    public String toString()
    {
        return faceName + " of " + suit;
    }



    public int getValue()
    {
        return getValidFaceNames().indexOf(faceName) + 2;
    }

    /**
     * This method will return an Image that represents the Card
     */
    public Image getImage()
    {
        String pathName = "images/"+faceName+"_of_"+suit+".png";
        return new Image(Card.class.getResourceAsStream(pathName));
    }

    public Image getBackOfCardImage()
    {
        return new Image(Card.class.getResourceAsStream("images/back_of_card.png"));
    }
}