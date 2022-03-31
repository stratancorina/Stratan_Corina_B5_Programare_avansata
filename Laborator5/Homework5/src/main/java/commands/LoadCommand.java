package commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Catalog;

import java.io.File;
import java.io.IOException;

public class LoadCommand extends Command{

    public LoadCommand(String commandName) {
        super(commandName);
    }

    public static Catalog loadCatalog(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);
        return catalog;
    }
}
