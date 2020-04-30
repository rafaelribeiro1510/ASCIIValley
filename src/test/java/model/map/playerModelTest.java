package model.map;

import com.googlecode.lanterna.TextColor;
import model.Position;
import model.PlayerModel;
import org.junit.Test;
import org.mockito.Mockito;
import view.MapView;

import static org.junit.Assert.assertEquals;

public class playerModelTest {
    /*
    private MapView.COMMAND randomCommand() {
        int pick = new Random().nextInt(MapView.COMMAND.values().length);
        return MapView.COMMAND.values()[pick];
    }
    */


    @Test
    public void updatePosTest1() {
        PlayerModel pm = new PlayerModel(new Position(4, 5), "P", Mockito.mock(TextColor.class));

        pm.updatePosition(MapView.COMMAND.DOWN);
        pm.updatePosition(MapView.COMMAND.DOWN);
        pm.updatePosition(MapView.COMMAND.DOWN);

        assertEquals(4, pm.getPosition().getX());
        assertEquals(8, pm.getPosition().getY());
    }

    @Test
    public void updatePosTest2() {
        PlayerModel pm = new PlayerModel(new Position(4, 5), "P", Mockito.mock(TextColor.class));

        pm.updatePosition(MapView.COMMAND.UP);
        pm.updatePosition(MapView.COMMAND.UP);
        assertEquals(4, pm.getPosition().getX());
        assertEquals(3, pm.getPosition().getY());
    }

    @Test
    public void updatePosTest3() {
        PlayerModel pm = new PlayerModel(new Position(4, 5), "P", Mockito.mock(TextColor.class));

        pm.updatePosition(MapView.COMMAND.LEFT);
        assertEquals(3, pm.getPosition().getX());
        assertEquals(5, pm.getPosition().getY());
    }

    @Test
    public void updatePosTest4() {
        PlayerModel pm = new PlayerModel(new Position(4, 5), "P", Mockito.mock(TextColor.class));

        pm.updatePosition(MapView.COMMAND.RIGHT);
        pm.updatePosition(MapView.COMMAND.RIGHT);
        pm.updatePosition(MapView.COMMAND.RIGHT);
        assertEquals(7, pm.getPosition().getX());
        assertEquals(5, pm.getPosition().getY());
    }



}
