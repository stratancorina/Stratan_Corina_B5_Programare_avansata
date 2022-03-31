package commands;

import models.Item;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand extends Command{

    public ViewCommand(String commandName) {
        super(commandName);
    }

    public static void viewItem(Item item) throws IOException {
        if(Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(item.getLocation()));
        }
    }
}
