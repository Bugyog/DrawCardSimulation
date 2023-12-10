package org.example.card;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static java.lang.Integer.MAX_VALUE;

@Getter
@RequiredArgsConstructor
public enum CardType {

    WEAPON(0), UPGRADED_BACKPACK(1), PREPARED_FOR_THE_WORST(2), BACKPACK(3), OTHER(MAX_VALUE);

    private final int priority;
}
