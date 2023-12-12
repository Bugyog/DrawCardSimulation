package org.example.deck;

public interface DeckConfiguration {

    int weapons();
    int backpacks();
    int preparedForTheWorsts();
    int upgradedBackpacks();
    int others();

    static DeckConfiguration of(int deckSize,
                                int weapons,
                                int backpacks,
                                int preparedForTheWorsts,
                                int upgradedBackpacks) {
        return new DeckConfigurationImpl(deckSize, weapons, backpacks, preparedForTheWorsts, upgradedBackpacks);
    }
}
