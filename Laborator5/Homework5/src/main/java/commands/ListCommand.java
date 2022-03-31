package commands;

import models.Catalog;
import models.Item;

import java.util.List;

public class ListCommand extends Command {

    public ListCommand(String commandName) {
        super(commandName);
    }

    public static void listItems(Catalog catalog) {
        List<Item> listItems = catalog.getItems();
        for(Item item: listItems) {
            System.out.println(item);
        }
    }
}
