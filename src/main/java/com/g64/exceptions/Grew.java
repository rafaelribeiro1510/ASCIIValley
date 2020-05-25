package com.g64.exceptions;

import com.g64.model.entities.plant.PlantEntity;

public class Grew extends Exception {
    PlantEntity grownEntity;
    public Grew(PlantEntity grownEntity){
        this.grownEntity = grownEntity;
    }
    public PlantEntity getGrownEntity(){
        return grownEntity;
    }
}
