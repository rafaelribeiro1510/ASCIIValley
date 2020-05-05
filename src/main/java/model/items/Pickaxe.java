package model.items;

import controller.GameController;
import model.Position;
import model.map.InteractionType;
import model.map.MapEntity;

public class Pickaxe extends Item {
    public Pickaxe(){
        this.name = "PIC ";
        this.durability = 200;
    }

    @Override
    public void use(GameController controller, Position position) {
        MapEntity target = controller.getMapModel().thisChunk().getEntityAt(position);
        if(target.getType() == InteractionType.Rock) {
            this.durability--;
            target.remove();
        }
    }
}
