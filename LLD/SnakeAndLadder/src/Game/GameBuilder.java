package Game;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GameBuilder {

    Player winner;
    Deque<Player> playerList = new LinkedList<>();

    Dice dice;
    Board board;

    public GameBuilder(){
        initializeGame();
    }

    public void initializeGame(){
        Board board = new Board(10, 5, 5);
        Dice dice = new Dice(1);
        winner = null;
        addPlayers();

    }

    public void addPlayers(){
        Player player1 = new Player("P1", 0);
        Player player2 = new Player("P2", 0);
        playerList.add(player1);
        playerList.add(player2);

    }

    public void startGame(){

        while(winner == null){
            // Get the player turn
            Player playerTurn = findPlayerTurn();
            System.out.println("Player turn = " + playerTurn.playerId + " Player position = " + playerTurn.position);

            //Check dice number
            int diceNumber = dice.rollDice();

            // get the new Position
            int playerNewPosition = playerTurn.position + diceNumber;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.position = playerNewPosition;

            System.out.println("player turn is : " + playerTurn.playerId + " new position is :" + playerNewPosition);

            if(playerNewPosition >= board.cells.length * board.cells.length-1)
                winner = playerTurn;

            System.out.println("Winner is : " + winner.playerId);

            
        }
    }

    private Player findPlayerTurn() {
        Player playerTurn = playerList.removeFirst();
        playerList.add(playerTurn);
        return playerTurn;
    }

    public int jumpCheck(int playerPosition){
        if(playerPosition > board.cells.length * board.cells.length-1)
            return playerPosition;

        Cell cell = board.getCells(playerPosition);
        if(cell.jump != null && cell.jump.start == playerPosition){
            String jumpBy = (cell.jump.start < cell.jump.end) ? "Ladder" : "Snake";
            System.out.println("Jump Done By" + jumpBy);
            return cell.jump.end;
        }
        return playerPosition;
    }
}
