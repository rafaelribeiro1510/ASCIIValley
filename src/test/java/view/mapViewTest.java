package view;

import model.map.MapModel;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class mapViewTest {

    @Test
    public void mapViewConstructorTest() throws IOException {
        MapView mv = new MapView(20,40);
    }

    // Just testing if the function works. Maybe delete this?
    @Test
    public void drawMapTest() {
        MapView mv = Mockito.mock(MapView.class);
        mv.drawMap(Mockito.mock(MapModel.class));
    }
}
