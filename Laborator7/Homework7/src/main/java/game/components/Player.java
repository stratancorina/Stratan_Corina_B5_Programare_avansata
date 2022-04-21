package game.components;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable{
    private String name;
    private List<Tile> pickedTiles;
    private Board gameBoard;

    public Player(String name, Board gameBoard){
        this.name = name;
        pickedTiles = new ArrayList<>();
        this.gameBoard = gameBoard;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public List<Tile> getPickedTiles() {
        return pickedTiles;
    }

    public void setPickedTiles(List<Tile> pickedTiles) {
        this.pickedTiles = pickedTiles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Name must have a value");
        this.name = name;
    }

    public void pickTiles(int nrToPick){
        if(nrToPick <= 0) throw new IllegalArgumentException("player must try to pick at least one tile");

        for (int i = 0; i < nrToPick; i++) {
            Tile tile = gameBoard.getTileBag().extractTile();
            if(tile == null) return;
            pickedTiles.add(tile);
        }
    }

    public void submitTiles(String foundWord){
        int score = 0;

        if(foundWord != null){
            for (char c:
                 foundWord.toCharArray()) {
                Tile containedTile = pickedTiles.stream().filter(tile -> tile.getCharacter() == c).findFirst().get();
                score += containedTile.getPoints();
                pickedTiles.remove(containedTile);
            }
        }
        else pickedTiles.clear();

        gameBoard.addPoints(name, score);
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        String threadName = Thread.currentThread().getName();

        while(gameBoard.getTileBag().getTiles().size() > 0 && gameBoard.isGameRunning()){
            pickTiles(7 - pickedTiles.size());
            synchronized (gameBoard.turnQueue){
                while (!gameBoard.turnQueue.peek().equals(name)){
                    try{
                        gameBoard.turnQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread " + threadName + " picked:");
                System.out.print("<");
                pickedTiles.forEach((tile -> System.out.print(tile.getCharacter() + ", ")));
                System.out.print(">");
                System.out.println();

                String foundWord = gameBoard.getDictionary().
                        findWord(pickedTiles.stream().map( tile -> tile.getCharacter()).toList());

                if(foundWord == null) System.out.println("No word found, discarding tiles");
                else System.out.println("The word found by " + threadName + " is " + foundWord);

                submitTiles(foundWord);
                System.out.println("The current score for thread " + threadName + " is " + gameBoard.getPlayerScore(name));

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                gameBoard.getTurnQueue().poll();
                gameBoard.getTurnQueue().add(name);
                gameBoard.turnQueue.notifyAll();
            }
        }
    }
}
