package org.example.card;

import org.example.deck.Deck;
import org.example.hand.Hand;

import java.util.List;

import static org.example.card.CardType.PREPARE_FOR_THE_WORST;
import static org.example.card.CardType.WEAPON;

class PrepareForTheWorst extends PlayableCard {

    private static final int SEARCH_QUANTITY = 9;
    private static final int DRAW_QUANTITY = 1;
    private static final List<CardType> SEARCH_LIST = List.of(WEAPON);

    PrepareForTheWorst(Hand hand, Deck deck) {
        super(hand, deck, SEARCH_QUANTITY, DRAW_QUANTITY, SEARCH_LIST);
    }

    @Override
    public CardType getType() {
        return PREPARE_FOR_THE_WORST;
    }
}
