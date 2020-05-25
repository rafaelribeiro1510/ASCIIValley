package com.g64.model;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuModel {

    private ArrayList<String> menuItems = new ArrayList<String>(Arrays.asList("Load Game", "Controls", "Quit"));
    private int selectedOption;

    public MenuModel() {
        this.selectedOption = 0;
    }

    public ArrayList<String> getMenuItems() {
        return menuItems;
    }

    public int getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(int selectedOption) {
        this.selectedOption = selectedOption;
    }
}
