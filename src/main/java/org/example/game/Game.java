package org.example.game;

import org.example.deck.DeckFactory;

public interface Game {

    int play();
    static Game of(DeckFactory deckFactory) {
        return new GameImpl(deckFactory);
    }
}
