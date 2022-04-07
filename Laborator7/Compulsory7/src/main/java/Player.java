import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Player implements Runnable {

    private String name;
    private Game game;
    private boolean running;
    public Player(String name) { this.name = name; }

    private boolean submitWord() throws InterruptedException {
        List<Tile> extracted = game.getBag().exctractTiles(this,7);
        if(extracted.isEmpty()) {
            return false;
        }

        StringBuilder word = new StringBuilder();
        for (var t : extracted) {
            word.append(t.getLetter());
        }
        return submitWord();
    }

    public void setGame(Game game) {
    }

    public String getName() {
        return name;
     }

    @Override
    public void run() {

    }

    //implement the run method;



}