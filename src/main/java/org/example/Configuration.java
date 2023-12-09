package org.example;

import lombok.Getter;

@Getter
public class Configuration {

    private final long iterations = 1_000_000;

    private final int deckSize = 33;
    private final int startHandSize = 5;
    private final int replaceQuantity = 3;
    private final int maxSearchingCardsOnStartHand = 0;

    private final int weapons = 1;
    private final int backPacks = 0;
    private final int preparedForTheWorsts = 0;
    private final int upgradedBacks = 0;

}
