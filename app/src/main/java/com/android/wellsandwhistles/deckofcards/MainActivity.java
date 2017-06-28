package com.android.wellsandwhistles.deckofcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.wellsandwhistles.deckofcards.deck.Cards;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private String[] mSuits = {"Spades", "Diamonds", "Clubs", "Hearts"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cards cards = new Cards(mSuits);
        Log.i(TAG, "Deck size: " + Integer.toString(cards.getDeckSize()));
        Log.i(TAG, "Cards in deck: " + cards.toString());
    }
}