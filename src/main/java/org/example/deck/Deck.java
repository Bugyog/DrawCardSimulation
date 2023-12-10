package org.example.deck;

import org.example.card.Card;
import org.example.card.CardType;

import java.util.List;

public interface Deck {

    List<Card> mulligan();
    Card draw();
    List<Card> search(int searchQuantity, int drawQuantity, List<CardType> searchList);
}
