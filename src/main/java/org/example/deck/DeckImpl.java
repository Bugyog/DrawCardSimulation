package org.example.deck;

import org.example.card.Card;
import org.example.card.CardType;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;
import static org.example.Configuration.*;

class DeckImpl implements Deck {

    private final LinkedList<Card> deck = new LinkedList<>();
    private final List<Card> weaknesses;

    DeckImpl(List<Card> cards, List<Card> weaknesses) {
        this.weaknesses = weaknesses;
        deck.addAll(cards);
        Collections.shuffle(deck);
    }

    @Override
    public List<Card> mulligan() {
        List<Card> startCards = draw(START_HAND_SIZE);
        List<Card> cardsToReplace = getCardsToReplace(startCards);
        List<Card> additionalCards = draw(cardsToReplace.size());
        deck.addAll(cardsToReplace);
        deck.addAll(weaknesses);
        Collections.shuffle(deck);

        return Stream.of(startCards, additionalCards)
                .flatMap(Collection::stream)
                .filter(not(cardsToReplace::contains))
                .toList();
    }

    private List<Card> draw(int quantity) {
        return Stream.generate(this::draw)
                .limit(quantity)
                .toList();
    }

    private List<Card> getCardsToReplace(List<Card> cards) {
        List<Card> cardsToRemain = getCardsToRemain(cards);
        return cards.stream()
                .filter(not(Card::isWeapon))
                .filter(not(cardsToRemain::contains))
                .limit(REPLACE_QUANTITY)
                .toList();
    }

    private List<Card> getCardsToRemain(List<Card> cards) {
        return cards.stream()
                .filter(Card::isPlayable)
                .sorted()
                .limit(MAX_SEARCHING_CARDS_ON_START_HAND)
                .toList();
    }

    @Override
    public Card draw() {
        return deck.poll();
    }

    @Override
    public List<Card> search(int searchQuantity, int drawQuantity, List<CardType> searchList) {
        List<Card> foundCards = find(searchQuantity, drawQuantity, searchList);
        deck.removeAll(foundCards);
        Collections.shuffle(deck);
        return foundCards;
    }

    private List<Card> find(int searchQuantity, int drawQuantity, List<CardType> searchList) {
        return deck.stream()
                .limit(searchQuantity)
                .filter(it -> searchList.contains(it.getType()))
                .sorted()
                .limit(drawQuantity)
                .toList();
    }
}
