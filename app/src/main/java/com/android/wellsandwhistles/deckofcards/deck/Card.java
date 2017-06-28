package com.android.wellsandwhistles.deckofcards.deck;

/**
 * Created by Owner on 6/27/2017.
 */

public class Card {

    private int mNumber;
    private String mSuit;

    public Card(int number, String suit) {
        mNumber = number;
        mSuit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "mNumber=" + mNumber +
                ", mSuit='" + mSuit + '\'' +
                '}';
    }

    public int getNumber() {
        return mNumber;
    }

    public String getSuit() {
        return mSuit;
    }

}