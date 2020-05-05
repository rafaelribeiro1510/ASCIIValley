package view;

import model.map.MapModel;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MapViewTest {

    @Test
    public void mapViewConstructorTest() throws IOException {
        MapView mv = new MapView(20,40);
    }

    // Just testing if the function works. Maybe delete this?
    @Test
    public void drawMapTest() {
        MapView mv = Mockito.mock(MapView.class);
        mv.draw(Mockito.mock(MapModel.class));
    }
}
