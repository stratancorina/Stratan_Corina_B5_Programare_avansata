package commands;

import models.Catalog;
import models.Item;

public class AddCommand extends Command {

    public AddCommand(String commandName) {
        super(commandName);
    }

    public static void addItem(Catalog catalog, Item item) {
        catalog.add(item);
    }

}
