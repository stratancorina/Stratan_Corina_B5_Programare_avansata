package models;

import exceptions.InvalidItemId;
import models.Item;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {

    private String name;
    private List<Item> items = new ArrayList<>();

    public Catalog() {

    }

    public Catalog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public Item getItemById(String id) throws InvalidItemId{
        for(Item item: items) {
            if(item.getId().equals(id))
                return item;
        }
        throw new InvalidItemId("Cannot find the id in the items list");
    }

    public void add(Item item) {
        items.add(item);
    }

    @Override
    public String toString() {
        return "models.Catalog\n{\n" +
                "\tname='" + name + "\'," + '\n' +
                "\titems=" + items +
                "\n}";
    }
}
