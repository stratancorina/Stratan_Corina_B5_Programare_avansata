package game.components;

import data.structures.PrefixTree;

import java.util.*;

public class Board {
    private Map<String, Integer> playersScore;
    private List<Player> players;
    private Bag tileBag;
    private PrefixTree dictionary;
    private Timer timeDaemon;
    public Queue<String> turnQueue;
    private boolean gameRunning;

    public Board(Bag tileBag, PrefixTree dictionary){
        playersScore = new HashMap<>();
        players = new ArrayList<>();
        this.tileBag = tileBag;
        this.dictionary = dictionary;
        turnQueue = new LinkedList<>();
    }

    public void addPlayer(String name){
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Name must have a value");
        if(players.stream().filter(player -> player.getName().equals(name)).count() != 0) throw new IllegalArgumentException("duplicate player");

        Player newPlayer = new Player(name, this);
        players.add(newPlayer);
        turnQueue.add(name);
        playersScore.put(name, 0);
    }

    public Queue<String> getTurnQueue() {
        return turnQueue;
    }

    public void setTurnQueue(Queue<String> turnQueue) {
        this.turnQueue = turnQueue;
    }

    public synchronized Bag getTileBag() {
        return tileBag;
    }

    public void setTileBag(Bag tileBag) {
        this.tileBag = tileBag;
    }

    public synchronized PrefixTree getDictionary() {
        return dictionary;
    }

    public void setDictionary(PrefixTree dictionary) {
        this.dictionary = dictionary;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public synchronized boolean isGameRunning() {
        return gameRunning;
    }

    public void setGameRunning(boolean gameIsRunning) {
        this.gameRunning = gameIsRunning;
    }

    public void setTimeDaemon(Timer timeDaemon) {
        this.timeDaemon = timeDaemon;
        timeDaemon.setGameBoard(this);
    }

    public synchronized Integer getPlayerScore(String name){
        return playersScore.get(name);
    }

    public synchronized void addPoints(String playerName, int points){
        playersScore.put(playerName, playersScore.get(playerName) + points);
    }

    public void finalScores(){
        var sortedScores = playersScore.entrySet().stream()
                .sorted((entry1, entry2)->entry2.getValue().compareTo(entry1.getValue())).toList();
        for (int i = 0; i < sortedScores.size(); i++) {
            System.out.println( (i + 1) + ". " + sortedScores.get(i).getKey() + " : " + sortedScores.get(i).getValue());
        }
    }

    public void startGame() throws InterruptedException {
        System.out.println("The points for each character are:");
        tileBag.getTiles().keySet().stream().forEach(tile -> {System.out.println(tile.getCharacter() + " : " + tile.getPoints());});

        List<Thread> playerThreads = new ArrayList<>();
        for (Player player:
             players) {
            playerThreads.add(new Thread(player));
        }

        gameRunning = true;
        if(timeDaemon != null){
            Thread daemon = new Thread(timeDaemon);
            daemon.setDaemon(true);
            daemon.start();
        }

        for (Thread thread:
             playerThreads) {
            thread.start();
        }

        for (Thread thread:
                playerThreads) {
            thread.join();
        }

        finalScores();
    }
}
