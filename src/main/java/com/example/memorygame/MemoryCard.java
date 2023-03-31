/**
 * The code defines a public class called "MemoryCard" that extends the "Card" class.
 * The class has a private instance variable called "matched" that is initially set to false.
 * The class has a constructor that takes in a suit and faceName as parameters and sets them using the corresponding setter methods, and also sets the "matched" variable to false.
 * The class has a getter method called "isMatched" that returns the value of the "matched" variable.
 * The class has a setter method called "setMatched" that takes in a boolean value and sets the "matched" variable to that value.
 * The class has a method called "isSameCard" that takes in another MemoryCard object as a parameter and returns true if the two cards have the same suit and faceName.
 */

package com.example.memorygame;

public class MemoryCard extends Card{
    private boolean matched;

    public MemoryCard(String suit, String faceName) {
        super(suit, faceName);
        this.matched = false;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    /**
     * This method returns true if the 2 MemoryCard objects
     * have the same suit and faceName
     */
    public boolean isSameCard(MemoryCard otherCard)
    {
        return (this.getSuit().equals(otherCard.getSuit()) &&
                (this.getFaceName().equals(otherCard.getFaceName())));
    }
}