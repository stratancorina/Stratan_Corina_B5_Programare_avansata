package commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Catalog;

import java.io.File;
import java.io.IOException;

public class SaveCommand extends Command{

    public SaveCommand(String commandName) {
        super(commandName);
    }

    public static void saveCatalog(Catalog catalog, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);
    }
}
