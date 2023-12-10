package org.example.card;

import org.example.deck.Deck;
import org.example.hand.Hand;

public interface Card extends Comparable<Card> {

    boolean isWeapon();
    boolean isPlayable();
    CardType getType();
    void play(Hand hand, Deck deck);
}
