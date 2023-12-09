package org.example.card;

import lombok.RequiredArgsConstructor;
import org.example.deck.Deck;
import org.example.hand.Hand;

import java.util.List;

@RequiredArgsConstructor
abstract class PlayableCard extends AbstractCard {

    private final Hand hand;
    private final Deck deck;
    private final int searchQuantity;
    private final int drawQuantity;
    private final List<CardType> searchList;

    @Override
    public boolean isPlayable() {
        return true;
    }

    @Override
    public void play() {
        hand.remove(this);
        List<Card> foundCards = deck.search(searchQuantity, drawQuantity, searchList);
        hand.add(foundCards);
    }
}
