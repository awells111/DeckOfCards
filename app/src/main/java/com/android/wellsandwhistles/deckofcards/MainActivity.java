package com.android.wellsandwhistles.deckofcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.wellsandwhistles.deckofcards.deck.Card;
import com.android.wellsandwhistles.deckofcards.deck.Cards;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private String[] mSuits = {"Spades", "Diamonds", "Clubs", "Hearts"};

    // Our deck
    private Cards mCards;

    // The card that has been dealt to the user
    private Card yourCard;

    private TextView textDeckSize;
    private TextView textYourCard;

    private Button buttonPickCard;
    private Button buttonDealDeck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textDeckSize = (TextView) findViewById(R.id.text_deck_size);
        textYourCard = (TextView) findViewById(R.id.text_your_card);

        mCards = new Cards(mSuits);

        updateUi();

        buttonPickCard = (Button) findViewById(R.id.button_pick_card);
        buttonDealDeck = (Button) findViewById(R.id.button_deal_deck);
        buttonPickCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUi();
            }
        });

        buttonDealDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCards = new Cards(mSuits);
                updateUi();
            }
        });
    }

    //todo handle config changes
    private void updateUi() {
        yourCard = mCards.dealOneCard();
        textDeckSize.setText("Deck size: " + Integer.toString(mCards.getDeckSize()));
        textYourCard.setText("Your card is the " + Integer.toString(yourCard.getNumber()) +
                " of " + yourCard.getSuit());

        Log.i(TAG, "Cards in deck: " + mCards.toString());
    }

}