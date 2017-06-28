package com.android.wellsandwhistles.deckofcards.deck;

import java.util.ArrayList;
/**
 * Created by Owner on 6/27/2017.
 */

public class Cards {

    // Our deck of cards.
    private ArrayList<Card> mCards;

    // The number of cards currently in a deck. This number is increased every time a card is added.
    private int mDeckSize = 0;

    // Number of cards per suit.
    private final int count = 13;

    public Cards(String[] suits) {
        mCards = new ArrayList<>();
        addSuits(suits);
    }

    private void addSuits(String[] suits) {
        for (String s : suits) {
            addSuit(s);
        }
    }

    private void addSuit(String suit) {
        for (int i = 1; i <= count; i++) {
            mCards.add(new Card(i, suit));
            mDeckSize++;
        }
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
}
