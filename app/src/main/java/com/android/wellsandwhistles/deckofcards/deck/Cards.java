package com.android.wellsandwhistles.deckofcards.deck;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Created by Owner on 6/27/2017.
 */

public class Cards {

    // Our deck of cards.
    private final ArrayList<Card> mCards;

    // The number of cards currently in a deck. This number is increased every time a card is added.
    private int mDeckSize = 0;

    private final String[] mNumbers = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Jack", "Queen", "King"};
    private final String[] mSuits = {"Spades", "Diamonds", "Clubs", "Hearts"};

    public Cards() {
        mCards = new ArrayList<>();
        createDeck();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Card card : mCards) {
            sb.append(card.toString());
            sb.append(", ");
        }

        return sb.toString();
    }

    public int getDeckSize() {
        return mDeckSize;
    }

    // Returns the top card of the deck then deletes it so we do not draw it again
    public Card dealOneCard() {
        Card yourCard = mCards.get(0);
        mCards.remove(0);
        mDeckSize--;
        return yourCard;
    }

    // Creates and shuffles our deck
    private void createDeck() {

        // For each suit in mSuits
        for (String mSuit : mSuits) {

            // For each number in mNumbers
            for (String mNumber : mNumbers) {
                mCards.add(new Card(mNumber, mSuit));
                mDeckSize++;
            }
        }

        shuffle();
    }

    // Included as a separate function as per project guidelines
    private void shuffle() {
        Collections.shuffle(mCards);
    }
}
