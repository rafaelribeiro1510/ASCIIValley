package com.g64.model.entities.target;

import com.g64.model.entities.EntityModel;
import com.g64.model.entities.enemy.Enemy;
import com.g64.model.entities.map.NullEntity;
import com.g64.model.entities.map.RockEntity;
import com.g64.model.entities.map.TreeEntity;
import com.g64.model.entities.plant.PlantEntity;
import com.g64.model.entities.plant.SeedEntity;
import com.g64.model.items.drops.*;
import com.g64.model.items.tools.*;
import com.g64.model.terrain.GrassTerrain;
import com.g64.model.terrain.MapTerrain;
import com.g64.model.terrain.SoilTerrain;

public class Target {
    EntityModel entity;
    MapTerrain terrain;

    public Target(EntityModel entity, MapTerrain terrain) {
        this.entity = entity;
        this.terrain = terrain;
    }

    public boolean allowUsage(SeedDrop item) {
        return (entity instanceof NullEntity && terrain instanceof SoilTerrain);
    }

    public boolean allowUsage(ConsumableDrop item) {
        return true;
    }

    public boolean allowUsage(LogDrop item) {
        return (entity instanceof NullEntity && terrain instanceof GrassTerrain);
    }

    public boolean allowUsage(RockDrop item) {
        return (entity instanceof NullEntity);
    }

    public boolean allowUsage(TallGrassDrop item) {
        return (entity instanceof NullEntity && terrain instanceof GrassTerrain);
    }

    public boolean allowUsage(Axe item) {
        return (entity instanceof TreeEntity || entity instanceof Enemy);
    }

    public boolean allowUsage(Hoe item) {
        return (terrain instanceof GrassTerrain);
    }

    public boolean allowUsage(Pickaxe item) {
        return (entity instanceof RockEntity);
    }

    public boolean allowUsage(Scythe item) {
        return (entity instanceof PlantEntity);
    }

    public boolean allowUsage(WateringCan item) {
        return (entity instanceof SeedEntity);
    }

}
