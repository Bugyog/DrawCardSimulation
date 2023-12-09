package org.example.card;

abstract class AbstractCard implements Card {

    @Override
    public boolean isWeapon() {
        return false;
    }

    @Override
    public boolean isPlayable() {
        return false;
    }

    @Override
    public void play() {

    }

    @Override
    public int compareTo(Card card) {
        int firstPriority = getType().getPriority();
        int secondPriority = card.getType().getPriority();
        return Integer.compare(firstPriority, secondPriority);
    }

    @Override
    public String toString() {
        return getType().toString();
    }
}
