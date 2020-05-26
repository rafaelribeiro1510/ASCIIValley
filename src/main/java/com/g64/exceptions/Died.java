package com.g64.exceptions;

import com.g64.model.entities.EntityModel;

public class Died extends Exception {
    private EntityModel entity;
    public Died(EntityModel entity){
        this.entity = entity;
    }
    public EntityModel getEntity() {
        return entity;
    }
}
