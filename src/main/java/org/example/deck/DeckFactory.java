package org.example.deck;

import lombok.RequiredArgsConstructor;
import org.example.Configuration;
import org.example.card.Card;
import org.example.card.CardFactory;
import org.example.card.CardType;
import org.example.hand.Hand;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.example.card.CardType.*;

@RequiredArgsConstructor
public class DeckFactory {

    private final CardFactory cardFactory;
    private final Configuration configuration;
    private final Hand hand;

    public Deck create() {
        Deck deck = new DeckImpl(hand, configuration);
        List<Card> cards = createCards(deck);
        deck.add(cards);
        return deck;
    }

    private List<Card> createCards(Deck deck) {
        List<Card> weapons = createCards(WEAPON, configuration.getWeapons(), deck);
        List<Card> upgradedBackpacks = createCards(UPGRADED_BACKPACK, configuration.getUpgradedBacks(), deck);
        List<Card> prepareForTheWorsts = createCards(PREPARE_FOR_THE_WORST, configuration.getPreparedForTheWorsts(), deck);
        List<Card> backpacks = createCards(BACKPACK, configuration.getBackPacks(), deck);
        int otherQuantity = configuration.getDeckSize() - weapons.size() - upgradedBackpacks.size() - prepareForTheWorsts.size() - backpacks.size();
        List<Card> others = createCards(OTHER, otherQuantity, deck);

        return Stream.of(weapons, upgradedBackpacks, prepareForTheWorsts, backpacks, others)
                .flatMap(Collection::stream)
                .toList();
    }

    private List<Card> createCards(CardType type, int quantity, Deck deck) {
        return Stream.generate(() -> cardFactory.create(type, deck))
                .limit(quantity)
                .toList();
    }
}
