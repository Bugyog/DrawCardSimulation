package org.example.card;

import lombok.RequiredArgsConstructor;
import org.example.deck.Deck;
import org.example.hand.Hand;

import java.util.Map;
import java.util.function.BiFunction;

import static org.example.card.CardType.*;

@RequiredArgsConstructor
public class CardFactory {

    private final Hand hand;
    private final Map<CardType, BiFunction<Hand, Deck, Card>> factories = Map.of(
           WEAPON, (hand, deck) -> new Weapon(),
           UPGRADED_BACKPACK, UpgradedBackpack::new,
           PREPARE_FOR_THE_WORST, PrepareForTheWorst::new,
           BACKPACK, Backpack::new,
           OTHER, ((hand, deck) -> new Other())
    );

    public Card create(CardType cardType, Deck deck) {
        return factories.get(cardType).apply(hand, deck);
    }
}
