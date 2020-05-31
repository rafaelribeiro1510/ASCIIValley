package com.g64.model.menuCommands;

public class MenuOption {

    private String optionText;
    private MenuCommand menuCommand;

    public MenuOption(String optionText, MenuCommand menuCommand) {
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
