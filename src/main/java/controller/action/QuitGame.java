package controller.action;

import controller.GameController;
import view.MapView;

import java.io.IOException;

public class QuitGame implements ActionEvent {
    private final GameController controller;
    private final MapView view;

    public QuitGame(GameController controller, MapView view) { this.controller = controller; this.view = view;}

    @Override
    public void execute() throws IOException {
        view.getScreen().close();
        controller.setRunning(false);
        System.out.println("\nQuitting");
    }
}
