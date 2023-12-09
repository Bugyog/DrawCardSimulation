package org.example.card;

import org.example.deck.Deck;
import org.example.hand.Hand;

import java.util.List;

import static org.example.card.CardType.*;

class Backpack extends PlayableCard {

    private static final int SEARCH_QUANTITY = 6;
    private static final int DRAW_QUANTITY = 3;
    private static final List<CardType> SEARCH_LIST = List.of(WEAPON, BACKPACK, UPGRADED_BACKPACK);

    Backpack(Hand hand, Deck deck) {
        super(hand, deck, SEARCH_QUANTITY, DRAW_QUANTITY, SEARCH_LIST);
    }

    @Override
    public CardType getType() {
        return BACKPACK;
    }
}
