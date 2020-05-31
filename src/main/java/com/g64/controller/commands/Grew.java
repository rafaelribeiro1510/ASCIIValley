package com.g64.controller.commands;

import com.g64.controller.GameController;
import com.g64.model.entities.plant.PlantEntity;
import com.g64.model.entities.plant.SeedEntity;


public class Grew implements Command {
    private final GameController controller;
    private final SeedEntity seed;
    private final PlantEntity plant;

    public Grew(GameController controller, SeedEntity seed, PlantEntity plant) {
        this.controller = controller;
        this.seed = seed;
        this.plant = plant;
    }


    @Override
    public void execute() {
        controller.getMapModel().thisChunk().getEntities().remove(seed);
        controller.getMapModel().thisChunk().getEntities().add(plant);
    }
}
