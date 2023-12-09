package org.example.card;

public interface Card extends Comparable<Card> {

    boolean isWeapon();
    boolean isPlayable();
    CardType getType();
    void play();
}
