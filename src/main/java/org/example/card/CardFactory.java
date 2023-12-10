package org.example.card;

import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.function.Supplier;

import static org.example.card.CardType.*;

@RequiredArgsConstructor
public class CardFactory {

    private final Map<CardType, Supplier<Card>> factories = Map.of(
            WEAPON, Weapon::new,
            UPGRADED_BACKPACK, UpgradedBackpack::new,
            PREPARED_FOR_THE_WORST, PrepareForTheWorst::new,
            BACKPACK, Backpack::new,
            OTHER, Other::new
    );

    public Card create(CardType cardType) {
        return factories.get(cardType).get();
    }
}
