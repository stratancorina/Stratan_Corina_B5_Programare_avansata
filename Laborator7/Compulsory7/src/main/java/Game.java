import java.util.ArrayList;

import java.util.List;

public class Game {
    private Bag bag = new Bag();
    private Board board = new Board();
    private Dictionary dictionary = new Dictionary();
    private final List<Player> players = new ArrayList<>();


    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }
    public void play() {
        for (Player player : players) {
            new Thread(player).start();
        }
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }


    public List<Player> getPlayers() {
        return players;
    }

    private void setBoard(Board board) {

    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public Board getBoard() {
        return board;
    }

    public static void main(String args[]) {
        Game game = new Game();
        game.setBag(new Bag());
        game.setBoard(new Board());

        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }

}
