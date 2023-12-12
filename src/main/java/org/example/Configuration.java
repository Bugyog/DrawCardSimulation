package org.example;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Configuration {

    public static final long ITERATIONS = 100_000_000;

    public static final int START_HAND_SIZE = 5;
    public static final int REPLACE_QUANTITY = 3;
    public static final int MAX_SEARCHING_CARDS_ON_START_HAND = 2;
    public static final int WEAKNESSES = 2;
}
