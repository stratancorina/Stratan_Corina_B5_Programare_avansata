import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bag {
    private final Queue<Tile> letters = new LinkedList<>();
    public Bag() {
        for (char c = 'a'; c < 'z'; c++) {
            for (int i =0; i< 10; i++) {
                letters.add(new Tile(c,1));
            }
        }
    }
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            extracted.add(letters.poll());
        }
        return extracted;
    }

    public List<Tile> exctractTiles(Player player, int i) {
        return null;
    }
}
