package org.example.deck;

import org.example.Configuration;
import org.example.card.Card;
import org.example.card.CardType;
import org.example.hand.Hand;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

class DeckImpl implements Deck {

    private final LinkedList<Card> deck = new LinkedList<>();
    private final Hand hand;
    private final int startHandSize;
    private final int replaceQuantity;
    private final int maxSearchingCardsOnStartHand;

    DeckImpl(Hand hand, Configuration configuration) {
        this.hand = hand;
        this.startHandSize = configuration.getStartHandSize();
        this.replaceQuantity = configuration.getReplaceQuantity();
        this.maxSearchingCardsOnStartHand = configuration.getMaxSearchingCardsOnStartHand();
    }

    @Override
    public void add(List<Card> cards) {
        deck.addAll(cards);
        Collections.shuffle(deck);
    }

    @Override
    public void mulligan(Hand hand) {
        List<Card> cards = mulligan();
        //System.out.println("Hand: " + cards);
        hand.add(cards);
    }

    private List<Card> mulligan() {
        List<Card> startCards = draw(startHandSize);
        List<Card> cardsToReplace = getCardsToReplace(startCards);
        List<Card> additionalCards = draw(cardsToReplace.size());
        add(cardsToReplace);
        //System.out.println("Start cards: " + startCards);
        //System.out.println("Card to replace: " + cardsToReplace);
        //System.out.println("Additional cards: " + additionalCards);

        return Stream.of(startCards, additionalCards)
                .flatMap(Collection::stream)
                .filter(not(cardsToReplace::contains))
                .toList();
    }

    private List<Card> draw(int quantity) {
        return Stream.generate(deck::poll)
                .limit(quantity)
                .toList();
    }

    private List<Card> getCardsToReplace(List<Card> cards) {
        List<Card> cardsToRemain = getCardsToRemain(cards);
        return cards.stream()
                .filter(not(Card::isWeapon))
                .filter(not(cardsToRemain::contains))
                .limit(replaceQuantity)
                .toList();
    }

    private List<Card> getCardsToRemain(List<Card> cards) {
        return cards.stream()
                .filter(Card::isPlayable)
                .sorted()
                .limit(maxSearchingCardsOnStartHand)
                .toList();
    }

    @Override
    public void draw() {
        hand.add(deck.poll());
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
                .filter(it -> searchList.contains(it.getType()))
                .limit(searchQuantity)
                .sorted()
                .limit(drawQuantity)
                .toList();
    }
}
