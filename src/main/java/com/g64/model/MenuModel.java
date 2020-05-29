package com.g64.model;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuModel {

    private ArrayList<String> menuItems = new ArrayList<String>(Arrays.asList("Load Game", "Controls", "Quit"));
    private int selectedOption;

    public MenuModel() {
        this.selectedOption = 0;
    }

}
