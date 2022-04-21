package game.components;

public class Timer implements Runnable{
    private long startTime;
    private long timeLimit;

    private Board gameBoard;

    public Timer(long timeLimit){
        this.timeLimit = timeLimit;
    }

    public long getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(long timeLimit) {
        if(timeLimit < 0) throw new IllegalArgumentException("timeLimit");
        this.timeLimit = timeLimit;
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        while(true){
            System.out.println("The game has been going on for " + (System.currentTimeMillis() - startTime) + " milliseconds");
            if(System.currentTimeMillis() - startTime > timeLimit){
                gameBoard.setGameRunning(false);
                System.out.println("The game has been stopped since it exceeded the time limit");
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
