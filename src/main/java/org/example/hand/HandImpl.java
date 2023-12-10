package org.example.hand;

import org.example.card.Card;
import org.example.deck.Deck;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

class HandImpl implements Hand {

    public final List<Card> hand = new LinkedList<>();

    @Override
    public void add(List<Card> cards) {
        hand.addAll(cards);
        Collections.sort(hand);
    }

    @Override
    public void add(Card card) {
        hand.add(card);
        Collections.sort(hand);
    }

    @Override
    public void remove(Card card) {
        hand.remove(card);
    }

    @Override
    public void play(Deck deck) {
        removeUnplayable();
        hand.stream().findFirst().ifPresent(it -> it.play(this, deck));
    }

    @Override
    public boolean containsPlayable() {
        return hand.stream().anyMatch(Card::isPlayable);
    }

    @Override
    public boolean containsWeapon() {
        return hand.stream().anyMatch(Card::isWeapon);
    }

    private void removeUnplayable() {
        hand.removeIf(Predicate.not(Card::isPlayable));
    }
}
