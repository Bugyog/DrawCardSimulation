package org.example.simulation;

import lombok.RequiredArgsConstructor;
import org.example.Configuration;
import org.example.game.Game;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.LongStream;

import static java.math.RoundingMode.HALF_UP;

@RequiredArgsConstructor
class SimulationImpl implements Simulation {

    private static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);
    private final Configuration configuration;
    private final Map<Integer, Long> results = new TreeMap<>();

    @Override
    public void simulate() {
        LongStream.range(0, configuration.getIterations()).forEach((it) -> playGame());
        printResults();
    }

    private void playGame() {
        Game game = Game.of(configuration);
        int round = game.play();
        results.merge(round, 1L, Long::sum);
    }

    private void printResults() {
        long sum = 0;

        for (Map.Entry<Integer, Long> result: results.entrySet()) {
            sum += result.getValue();
            BigDecimal probability = calculateProbability(sum, configuration.getIterations());
            System.out.println(result.getKey() + " - " + probability);

            if (probability.equals(ONE_HUNDRED)) {
                break;
            }
        }
    }

    private BigDecimal calculateProbability(long sum, long iterations) {
        BigDecimal frequency = BigDecimal.valueOf(sum);
        return frequency.multiply(ONE_HUNDRED).divide(BigDecimal.valueOf(iterations), 2, HALF_UP);
    }
}
