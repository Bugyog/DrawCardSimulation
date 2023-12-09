package org.example.game;

import org.example.Configuration;
import org.example.card.CardFactory;
import org.example.deck.Deck;
import org.example.deck.DeckFactory;
import org.example.hand.Hand;

class GameImpl implements Game {

    private int round = 0;
    private final Hand hand;
    private final Deck deck;

    GameImpl(Configuration configuration) {
        this.hand = Hand.createInstance();
        CardFactory cardFactory = new CardFactory(hand);
        DeckFactory deckFactory = new DeckFactory(cardFactory, configuration, hand);
        this.deck = deckFactory.create();
        deck.mulligan(hand);
    }

    @Override
    public int play() {
        while (!hand.containsWeapon()) {
            playRound();
        }

        return round;
    }

    private void playRound() {
        round++;

        if(hand.containsPlayable()) {
            hand.play();
        } else {
            deck.draw();
        }

        deck.draw();
    }
}
