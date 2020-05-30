package com.g64.model.entities.visitors;

import com.g64.controller.GameController;
import com.g64.exceptions.Died;
import com.g64.model.Position;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.enemy.Enemy;
import com.g64.model.entities.map.NullEntity;
import com.g64.model.entities.map.RockEntity;
import com.g64.model.entities.map.TreeEntity;
import com.g64.model.entities.plant.PlantEntity;
import com.g64.model.entities.plant.SeedEntity;
import com.g64.model.items.Item;
import com.g64.model.items.drops.*;
import com.g64.model.items.tools.*;
import com.g64.model.terrain.GrassTerrain;
import com.g64.model.terrain.MapTerrain;
import com.g64.model.terrain.NullTerrain;
import com.g64.model.terrain.SoilTerrain;

public class TargetVisitor implements Visitor{
    GameController controller;
    Position position;
    EntityModel entity;
    MapTerrain terrain;

    public TargetVisitor(GameController controller, Position position) {
        this.controller = controller;
        this.position = position;
        this.entity = controller.getMapModel().thisChunk().getEntityAt(position);
        this.terrain = controller.getMapModel().thisChunk().getTerrainAt(position);
    }

    @Override
    public Item.itemValue allowUsage(SeedDrop item) {
        if (entity instanceof NullEntity && terrain instanceof SoilTerrain){
            controller.getMapModel().thisChunk().getEntities().add(item.getEntityFromDrop(position));
            return item.decrementValue();
        }
        else return Item.itemValue.UNUSED;
    }

    @Override
    public Item.itemValue allowUsage(ConsumableDrop item) {
        controller.getPlayer().addHealth(item.getHealthUpValue());
        return item.decrementValue();
    }

    @Override
    public Item.itemValue allowUsage(LogDrop item) {
        if  (entity instanceof NullEntity && terrain instanceof GrassTerrain){
            controller.getMapModel().thisChunk().getEntities().add(item.getEntityFromDrop(position));
            return item.decrementValue();
        }
        else return Item.itemValue.UNUSED;
    }

    @Override
    public Item.itemValue allowUsage(RockDrop item) {
        if (entity instanceof NullEntity && !(terrain instanceof NullTerrain)){
            controller.getMapModel().thisChunk().getEntities().add(item.getEntityFromDrop(position));
            return item.decrementValue();
        }
        else return Item.itemValue.UNUSED;
    }

    @Override
    public Item.itemValue allowUsage(TallGrassDrop item) {
        if (entity instanceof NullEntity && terrain instanceof GrassTerrain){
            controller.getMapModel().thisChunk().getEntities().add(item.getEntityFromDrop(position));
            return item.decrementValue();
        }
        else return Item.itemValue.UNUSED;
    }

    @Override
    public Item.itemValue allowUsage(Axe item) {
        if (entity instanceof TreeEntity || entity instanceof Enemy){
            try { entity.reduceHealth(item.getHitValue()); }
            catch (Died died) {
                controller.getInventoryModel().add(entity.getRandomDrop());
                controller.getMapModel().thisChunk().getEntities().remove(entity);
            }
            return item.decrementValue();
        }
        else return Item.itemValue.UNUSED;
    }

    @Override
    public Item.itemValue allowUsage(Hoe item) {
        if (entity instanceof NullEntity && terrain instanceof GrassTerrain){
            controller.getMapModel().thisChunk().getTerrain().remove(terrain);
            controller.getMapModel().thisChunk().getTerrain().add(new SoilTerrain(position));
            return item.decrementValue();
        }
        else return Item.itemValue.UNUSED;
    }

    @Override
    public Item.itemValue allowUsage(Pickaxe item) {
        if (entity instanceof RockEntity){
            try { entity.reduceHealth(item.getHitValue()); }
            catch (Died died) {
                controller.getInventoryModel().add(entity.getRandomDrop());
                controller.getMapModel().thisChunk().getEntities().remove(entity);
            }
            return item.decrementValue();
        }
        else return Item.itemValue.UNUSED;
    }

    @Override
    public Item.itemValue allowUsage(Scythe item) {
        if (entity instanceof PlantEntity){
            try { entity.reduceHealth(item.getHitValue()); }
            catch (Died died) {
                controller.getInventoryModel().add(entity.getRandomDrop());
                controller.getMapModel().thisChunk().getEntities().remove(entity);
            }
            return item.decrementValue();
        }
        else return Item.itemValue.UNUSED;
    }

    @Override
    public Item.itemValue allowUsage(WateringCan item) {
        if (entity instanceof SeedEntity){
            ((SeedEntity)entity).water(item.getHitValue());
            return item.decrementValue();
        }
        else return Item.itemValue.UNUSED;
    }
}
