package org.example.hand;

import org.example.card.Card;

import java.util.List;

public interface Hand {

    void add(List<Card> cards);
    void add(Card card);
    void remove(Card card);
    void play();
    boolean containsPlayable();
    boolean containsWeapon();

    static Hand createInstance() {
        return new HandImpl();
    }
}
