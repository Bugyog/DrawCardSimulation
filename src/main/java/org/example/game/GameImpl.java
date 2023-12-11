package org.example.game;

import org.example.card.Card;
import org.example.deck.Deck;
import org.example.deck.DeckFactory;
import org.example.hand.Hand;

import java.util.List;

class GameImpl implements Game {

    private int round = 0;
    private final Hand hand;
    private final Deck deck;

    GameImpl(DeckFactory deckFactory) {
        this.hand = Hand.createInstance();
        this.deck = deckFactory.create();
        mulligan();
    }

    private void mulligan() {
        List<Card> cards = deck.mulligan();
        hand.add(cards);
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
            hand.play(deck);
        } else {
            draw();
        }

        draw();
    }

    private void draw() {
        Card card = deck.draw();
        if (card != null) {
            hand.add(card);
        }
    }
}
