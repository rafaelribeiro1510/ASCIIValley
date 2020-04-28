package model.map;

import com.googlecode.lanterna.TextColor;
import model.Position;
import model.entities.PlayerModel;
import org.junit.Test;
import org.mockito.Mockito;
import view.MapView;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class playerModelTest {
    /*
    private MapView.COMMAND randomCommand() {
        int pick = new Random().nextInt(MapView.COMMAND.values().length);
        return MapView.COMMAND.values()[pick];
    }
    */


    @Test
    public void updatePosTest() {
        PlayerModel pm = new PlayerModel(new Position(4, 5), "P", Mockito.mock(TextColor.class));

        pm.updatePosition(MapView.COMMAND.DOWN);
        pm.updatePosition(MapView.COMMAND.DOWN);
        pm.updatePosition(MapView.COMMAND.DOWN);
        assertEquals(4, pm.getPosition().getX());
        assertEquals(8, pm.getPosition().getY());

        pm.updatePosition(MapView.COMMAND.UP);
        pm.updatePosition(MapView.COMMAND.LEFT);
        pm.updatePosition(MapView.COMMAND.LEFT);
        assertEquals(2, pm.getPosition().getX());
        assertEquals(7, pm.getPosition().getY());

        pm.updatePosition(MapView.COMMAND.DOWN);
        pm.updatePosition(MapView.COMMAND.RIGHT);
        pm.updatePosition(MapView.COMMAND.RIGHT);
        pm.updatePosition(MapView.COMMAND.RIGHT);
        assertEquals(5, pm.getPosition().getX());
        assertEquals(8, pm.getPosition().getY());
    }



}
