package com.android.wellsandwhistles.deckofcards;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.wellsandwhistles.deckofcards.deck.Card;
import com.android.wellsandwhistles.deckofcards.deck.Cards;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    // The deck of cards
    private Cards mCards;

    // The card that has been dealt to the user
    private Card mYourCard;

    private TextView textDeckSize;
    private TextView textYourCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textDeckSize = (TextView) findViewById(R.id.text_deck_size);
        textYourCard = (TextView) findViewById(R.id.text_your_card);

        mCards = new Cards();

        updateUi();

        Button buttonPickCard = (Button) findViewById(R.id.button_pick_card);
        Button buttonDealDeck = (Button) findViewById(R.id.button_deal_deck);
        buttonPickCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // We do not want to deal a card if no cards are left.
                if (mCards.getDeckSize() > 0) {
                    updateUi();
                }
            }
        });

        buttonDealDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCards = new Cards();
                updateUi();
            }
        });
    }

    private void updateUi() {
        mYourCard = mCards.dealOneCard();

        textDeckSize.setText("Deck size: " + mCards.getDeckSize());
        textYourCard.setText("Your card is the " + mYourCard.getNumber() +
                " of " + mYourCard.getSuit());

        Log.i(TAG, "Cards in deck: " + mCards.toString());
    }

}