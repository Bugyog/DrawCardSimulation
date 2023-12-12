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



    private final CardFactory cardFactory;
    private final List<Card> cards;
    private final List<Card> weaknesses;
    private final Map<CardType, Integer> composition;

    public DeckFactory(DeckConfiguration configuration, CardFactory cardFactory) {
        this.cardFactory = cardFactory;
        this.weaknesses = createCards(OTHER, WEAKNESSES);
        this.composition = Map.of(
                WEAPON, configuration.weapons(),
                UPGRADED_BACKPACK, configuration.upgradedBackpacks(),
                PREPARED_FOR_THE_WORST, configuration.preparedForTheWorsts(),
                BACKPACK, configuration.backpacks(),
                OTHER, configuration.others()
        );
        this.cards = createCards();
    }

    public Deck create() {
        return new DeckImpl(cards, weaknesses);
    }

    private List<Card> createCards() {
        return composition.entrySet().stream()
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
