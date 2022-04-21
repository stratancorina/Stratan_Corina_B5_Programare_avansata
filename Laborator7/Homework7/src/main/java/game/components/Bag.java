package game.components;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Bag {
    private Map<Tile, Integer> tiles;

    public Bag(){
        tiles = new HashMap<>();
    }

    public void fillBag(String characters, int pointValue, int quantity, boolean generateRand, int randStart, int randEnd){
        if(!generateRand){
            for (char c:
                 characters.toCharArray()) {
                Tile newTile = Tile.makeTile(c, pointValue);
                tiles.put(newTile, quantity);
            }
        }
        else{
            for (char c:
                    characters.toCharArray()) {
                Tile newTile = Tile.makeTile(c, ThreadLocalRandom.current().nextInt(randStart, randEnd));
                tiles.put(newTile, quantity);
            }
        }
    }

    public void fillBag(String characters, List<Integer> pointValues, List<Integer> quantities){
        if(!(characters.length() == pointValues.size() && quantities.size() == characters.length())) throw new IllegalArgumentException("Need to have an association between characters, points and quantities");

        char[] charArray = characters.toCharArray();
        for (int idx = 0; idx < charArray.length; idx++) {
            if(quantities.get(idx) == null || quantities.get(idx) < 0) throw new IllegalArgumentException("Quantity must be at least 0");
            Tile newTile = Tile.makeTile(charArray[idx], pointValues.get(idx));
            tiles.put(newTile, quantities.get(idx));
        }
    }

    public synchronized Map<Tile, Integer> getTiles() {
        return tiles;
    }

    public void setTiles(Map<Tile, Integer> tiles) {
        this.tiles = tiles;
    }

    public synchronized Tile extractTile(){
        clearEmptyTiles();
        if(tiles.size() == 0) return null;

        int index = ThreadLocalRandom.current().nextInt(0, tiles.size());
        Map.Entry<Tile, Integer> randomEntry = (Map.Entry<Tile, Integer>)tiles.entrySet().toArray()[index];
        tiles.put(randomEntry.getKey(), randomEntry.getValue() - 1);

        return randomEntry.getKey();
    }

    private synchronized void clearEmptyTiles(){
        var emptyTilesList = tiles.entrySet().stream()
                .filter(tileIntegerEntry -> tileIntegerEntry.getValue() <= 0 || tileIntegerEntry.getValue() == null)
                .toList();
        for (Map.Entry<Tile, Integer> entry:
             emptyTilesList) {
            if(entry.getValue() == 0 || entry.getKey() == null)
                tiles.remove(entry.getKey());
        }
    }
}
