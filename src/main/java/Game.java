import com.googlecode.lanterna.TextColor;
import model.MapModel;
import model.Position;
import model.PlayerModel;
import view.MapView;
import controller.GameController;

public class Game {

    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.start();
    }

}
