package org.example.deck;

import org.example.card.Card;
import org.example.card.CardFactory;
import org.example.card.CardType;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.example.Configuration.*;
import static org.example.card.CardType.*;

public class DeckFactory {

    private static final Map<CardType, Integer> COMPOSITION = Map.of(
            WEAPON, WEAPONS,
            UPGRADED_BACKPACK, UPGRADED_BACKPACKS,
            PREPARED_FOR_THE_WORST, PREPARED_FOR_THE_WORSTS,
            BACKPACK, BACKPACKS,
            OTHER, getOthers()
    );

    private final CardFactory cardFactory;
    private final List<Card> cards;
    private final List<Card> weaknesses;

    public DeckFactory(CardFactory cardFactory) {
        this.cardFactory = cardFactory;
        this.cards = createCards();
        this.weaknesses = createCards(OTHER, WEAKNESSES);
    }

    public Deck create() {
        return new DeckImpl(cards, weaknesses);
    }

    private List<Card> createCards() {
        return COMPOSITION.entrySet().stream()
                .map(it -> createCards(it.getKey(), it.getValue()))
                .flatMap(Collection::stream)
                .toList();
    }

    private List<Card> createCards(CardType type, int quantity) {
        return Stream.generate(() -> cardFactory.create(type))
                .limit(quantity)
                .toList();
    }
}
