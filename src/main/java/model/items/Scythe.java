package model.items;

import controller.GameController;
import model.Position;
import model.map.InteractionType;
import model.map.MapEntity;

public class Scythe extends Item{
    public Scythe(){
        name = "SCYT";
    }

    @Override
    public void use(GameController controller, Position position){
        MapEntity target = controller.getMapModel().thisChunk().getEntityAt(position);
        if(target.getType() == InteractionType.Plant) target.remove();
    }
}
