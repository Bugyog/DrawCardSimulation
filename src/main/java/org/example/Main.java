package org.example;

import org.example.simulation.Simulation;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        Simulation simulation = Simulation.of(configuration);
        simulation.simulate();
    }
}