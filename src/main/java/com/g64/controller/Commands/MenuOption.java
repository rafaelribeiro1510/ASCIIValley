package com.g64.controller.Commands;

public class MenuOption {

    private String optionText;
    private Command command;

    public MenuOption(String optionText, Command command) {
        this.optionText = optionText;
        this.command = command;
    }

    public String getOptionText() {
        return optionText;
    }

    public Command getCommand() {
        return command;
    }
}
