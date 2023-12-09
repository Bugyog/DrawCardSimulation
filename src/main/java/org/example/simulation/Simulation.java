package org.example.simulation;

import org.example.Configuration;

public interface Simulation {

    void simulate();

    static Simulation of(Configuration configuration) {
        return new SimulationImpl(configuration);
    }
}
