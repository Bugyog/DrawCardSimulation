package org.example.game;

import org.example.Configuration;
import org.example.deck.Deck;
import org.example.hand.Hand;

public interface Game {

    int play();
    static Game of(Configuration configuration) {
        return new GameImpl(configuration);
    }
}
