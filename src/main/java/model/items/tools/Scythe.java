package model.items.tools;

import controller.GameController;
import model.Position;
import model.map.InteractionType;
import model.entities.MapEntity;

public class Scythe extends Tool{
    public Scythe(){
        this.name = "SCYT";
        this.durability = 100;
    }

    @Override
    public void use(GameController controller, Position position){
        MapEntity target = controller.getMapModel().thisChunk().getEntityAt(position);
        if(target.getType() == InteractionType.Plant) {
            this.decrementDurability();
            controller.getInventoryModel().add(target.getRandomDrop());
            target.remove();
        }
    }
}
