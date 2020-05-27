package com.g64.model.entities.target;

import com.g64.controller.GameController;
import com.g64.exceptions.Died;
import com.g64.exceptions.RemoveFromInventory;
import com.g64.model.Position;
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
import com.g64.model.terrain.NullTerrain;
import com.g64.model.terrain.SoilTerrain;

public class Target {
    GameController controller;
    Position position;
    EntityModel entity;
    MapTerrain terrain;

    public Target(GameController controller, Position position) {
        this.controller = controller;
        this.position = position;
        this.entity = controller.getMapModel().thisChunk().getEntityAt(position);
        this.terrain = controller.getMapModel().thisChunk().getTerrainAt(position);
    }

    public void allowUsage(SeedDrop item) throws RemoveFromInventory {
        if (entity instanceof NullEntity && terrain instanceof SoilTerrain){
            controller.getMapModel().thisChunk().getEntities().add(item.getEntityFromDrop(position));
            item.decrementValue();
        }
    }

    public void allowUsage(ConsumableDrop item) throws RemoveFromInventory {
        controller.getPlayer().addHealth(item.getHealthUpValue());
        item.decrementValue();
    }

    public void allowUsage(LogDrop item) throws RemoveFromInventory {
        if  (entity instanceof NullEntity && terrain instanceof GrassTerrain){
            controller.getMapModel().thisChunk().getEntities().add(item.getEntityFromDrop(position));
            item.decrementValue();
        }
    }

    public void allowUsage(RockDrop item) throws RemoveFromInventory {
        if (entity instanceof NullEntity && !(terrain instanceof NullTerrain)){
            controller.getMapModel().thisChunk().getEntities().add(item.getEntityFromDrop(position));
            item.decrementValue();
        }
    }

    public void allowUsage(TallGrassDrop item) throws RemoveFromInventory {
        if (entity instanceof NullEntity && terrain instanceof GrassTerrain){
            controller.getMapModel().thisChunk().getEntities().add(item.getEntityFromDrop(position));
            item.decrementValue();
        }
    }

    public void allowUsage(Axe item) throws RemoveFromInventory {
        if (entity instanceof TreeEntity || entity instanceof Enemy){
            try { entity.reduceHealth(item.getHitValue()); }
            catch (Died died) {
                controller.getInventoryModel().add(entity.getRandomDrop());
                controller.getMapModel().thisChunk().getEntities().remove(entity);
            }
            item.decrementValue();
        }
    }

    public void allowUsage(Hoe item) throws RemoveFromInventory {
        if (entity instanceof NullEntity && terrain instanceof GrassTerrain){
            controller.getMapModel().thisChunk().getTerrain().remove(terrain);
            controller.getMapModel().thisChunk().getTerrain().add(new SoilTerrain(position));
            item.decrementValue();
        }
    }

    public void allowUsage(Pickaxe item) throws RemoveFromInventory {
        if (entity instanceof RockEntity){
            try { entity.reduceHealth(item.getHitValue()); }
            catch (Died died) {
                controller.getInventoryModel().add(entity.getRandomDrop());
                controller.getMapModel().thisChunk().getEntities().remove(entity);
            }
            item.decrementValue();
        }
    }

    public void allowUsage(Scythe item) throws RemoveFromInventory {
        if (entity instanceof PlantEntity){
            try { entity.reduceHealth(item.getHitValue()); }
            catch (Died died) {
                controller.getInventoryModel().add(entity.getRandomDrop());
                controller.getMapModel().thisChunk().getEntities().remove(entity);
            }
            item.decrementValue();
        }
    }

    public void allowUsage(WateringCan item) throws RemoveFromInventory {
        if (entity instanceof SeedEntity){
            ((SeedEntity)entity).water(item.getHitValue());
            item.decrementValue();
        }
    }
}

//TODO ADD VISITOR PATTERN TO REPORT
