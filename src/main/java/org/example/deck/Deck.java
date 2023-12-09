package org.example.deck;

import org.example.card.Card;
import org.example.card.CardType;
import org.example.hand.Hand;

import java.util.List;

public interface Deck {

    void add(List<Card> cards);
    void mulligan(Hand hand);
    void draw();
    List<Card> search(int searchQuantity, int drawQuantity, List<CardType> searchList);
}
