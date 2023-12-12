package org.example;

import org.example.card.CardFactory;
import org.example.deck.DeckConfiguration;
import org.example.deck.DeckFactory;
import org.example.simulation.Simulation;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<DeckConfiguration> configurations = List.of(
                //add configuration here
        );
        configurations.forEach(Main::simulate);
    }

    private static void simulate(DeckConfiguration configuration) {
        System.out.println("=====================================");
        System.out.println(configuration);
        System.out.println();

        CardFactory cardFactory = new CardFactory();
        DeckFactory deckFactory = new DeckFactory(configuration, cardFactory);
        Simulation simulation = Simulation.of(deckFactory);
        simulation.simulate();
    }
}