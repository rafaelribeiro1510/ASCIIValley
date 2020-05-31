package com.g64.model.entities.map;

import com.g64.model.Position;
import com.g64.model.items.drops.Drop;
import com.g64.model.items.drops.LogDrop;
import com.googlecode.lanterna.TextColor;

public class TreeEntity extends MapEntity {
    public TreeEntity(Position position){
        super(position, "O", new TextColor.RGB(40,20,0), true, new Drop[] {new LogDrop()}, 10);
    }
}
