package model.items;

import controller.GameController;
import model.Position;
import model.map.InteractionType;
import model.map.MapEntity;

public class Scythe extends Item{
    public Scythe(){
        this.name = "SCY ";
        this.durability = 100;
    }

    @Override
    public void use(GameController controller, Position position){
        MapEntity target = controller.getMapModel().thisChunk().getEntityAt(position);
        if(target.getType() == InteractionType.Plant) {
            this.decrementDurability();
            target.remove();
        }
    }
}
