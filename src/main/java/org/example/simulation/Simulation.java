package org.example.simulation;

import org.example.deck.DeckFactory;

public interface Simulation {

    void simulate();

    static Simulation of(DeckFactory deckFactory) {
        return new SimulationImpl(deckFactory);
    }
}
