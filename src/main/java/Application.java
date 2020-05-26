import com.g64.controller.GameController;

public class Application {

    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.start();
    }
}

//TODO Smell: some instanceof still
//TODO Smell: use of exceptions to controll flow (corssed e afins)