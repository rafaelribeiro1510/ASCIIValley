package com.g64.model.menu;

public class menuOption {

    private String optionText;
    private MenuCommand menuCommand;

    public menuOption(String optionText, MenuCommand menuCommand) {
        this.optionText = optionText;
        this.menuCommand = menuCommand;
    }

    public String getOptionText() {
        return optionText;
    }

    public MenuCommand getMenuCommand() {
        return menuCommand;
    }
}
