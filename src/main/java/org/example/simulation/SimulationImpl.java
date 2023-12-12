package org.example.simulation;

import lombok.RequiredArgsConstructor;
import org.example.deck.DeckFactory;
import org.example.game.Game;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.LongStream;

import static java.math.RoundingMode.HALF_UP;
import static org.example.Configuration.ITERATIONS;

@RequiredArgsConstructor
class SimulationImpl implements Simulation {

    private static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);
    private final Map<Integer, Long> results = new TreeMap<>();
    private final DeckFactory deckFactory;

    @Override
    public void simulate() {
        LongStream.range(0, ITERATIONS).forEach((it) -> playGame());
        printResults();
    }

    private void playGame() {
        Game game = Game.of(deckFactory);
        int round = game.play();
        results.merge(round, 1L, Long::sum);
    }

    private void printResults() {
        System.out.println();

        long sum = 0;

        for (Map.Entry<Integer, Long> result: results.entrySet()) {
            sum += result.getValue();
            BigDecimal probability = calculateProbability(sum);
            System.out.println(result.getKey() + " - " + probability + "%");
        }
    }

    private BigDecimal calculateProbability(long sum) {
        BigDecimal frequency = BigDecimal.valueOf(sum);
        return frequency.multiply(ONE_HUNDRED).divide(BigDecimal.valueOf(ITERATIONS), 2, HALF_UP);
    }
}
