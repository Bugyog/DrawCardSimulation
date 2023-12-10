package org.example;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Configuration {

    public static final long ITERATIONS = 1_000_000;

    public static final int DECK_SIZE = 33;
    public static final int START_HAND_SIZE = 5;
    public static final int REPLACE_QUANTITY = 3;
    public static final int MAX_SEARCHING_CARDS_ON_START_HAND = 0;

    public static final int WEAPONS = 2;
    public static final int BACKPACKS = 0;
    public static final int PREPARED_FOR_THE_WORSTS = 0;
    public static final int UPGRADED_BACKPACKS = 0;
    public static final int WEAKNESSES = 2;

    public static int getOthers() {
        return DECK_SIZE - WEAPONS - BACKPACKS - PREPARED_FOR_THE_WORSTS - UPGRADED_BACKPACKS - WEAKNESSES;
    }
}
