package com.g64.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.g64.model.entities.EntityModel;
import com.g64.model.ChunkModel;

public class EntityView {
    private TextGraphics graphics;

    public EntityView(Screen screen) { this.graphics = screen.newTextGraphics(); }

    public void draw(EntityModel entity, ChunkModel chunkModel) {
        graphics.setForegroundColor(entity.getColor());
        graphics.setBackgroundColor(chunkModel.getTerrainAt(entity.getPosition()).getColor());
        graphics.putString(entity.getPosition().getX(), entity.getPosition().getY(), entity.getString());
    }
}
