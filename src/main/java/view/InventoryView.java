package view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import controller.GameController;
import model.InventoryModel;

public class InventoryView {
    private TextGraphics graphics;

    public InventoryView(Screen screen) { graphics = screen.newTextGraphics(); }

    public void draw(InventoryModel inventory){
        for (int i = 0 ; i < inventory.getItems().size() ; i++){
            System.out.print(inventory.getItems().get(i).getName() + "\n");
            if (i == inventory.getSelectedIndex()) {
                graphics.setBackgroundColor(TextColor.ANSI.WHITE);
                graphics.setForegroundColor(TextColor.ANSI.BLACK);
            }
            else {
                graphics.setBackgroundColor(TextColor.ANSI.BLACK);
                graphics.setForegroundColor(TextColor.ANSI.WHITE);
            }
            graphics.putString(i * 4, GameController.MAP_HEIGHT, inventory.getItems().get(i).getName());
            graphics.putString(i * 4, GameController.MAP_HEIGHT + 1, String.valueOf(inventory.getItems().get(i).getDurability()));
        }
    }
}
