package commands;

import models.Catalog;

public class ToStringCommand extends Command{

    public ToStringCommand(String commandName) {
        super(commandName);
    }

    public static String toString(Catalog catalog) {
        return "Catalog\n{\n" +
                "\tname='" + catalog.getName() + "\'," + '\n' +
                "\titems=" + catalog.getItems() +
                "\n}";
    }
}
