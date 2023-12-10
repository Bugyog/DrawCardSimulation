package org.example;

import org.example.card.CardFactory;
import org.example.deck.DeckFactory;
import org.example.simulation.Simulation;

public class Main {
    public static void main(String[] args) {
        CardFactory cardFactory = new CardFactory();
        DeckFactory deckFactory = new DeckFactory(cardFactory);
        Simulation simulation = Simulation.of(deckFactory);
        simulation.simulate();
    }
}