package org.example.deck;

import static org.example.Configuration.WEAKNESSES;

record DeckConfigurationImpl(int deckSize,
                             int weapons,
                             int backpacks,
                             int preparedForTheWorsts,
                             int upgradedBackpacks) implements DeckConfiguration {

    public int others() {
        return deckSize - weapons - backpacks - preparedForTheWorsts - upgradedBackpacks - WEAKNESSES;
    }
}
