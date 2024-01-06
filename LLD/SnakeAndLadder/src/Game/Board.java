package Game;

import java.util.concurrent.ThreadLocalRandom;

public class Board {

    Cell[][] cells;
    int size;

    int numberSnake;
    int numberLadder;



    public Board( int size, int numberSnake, int numberLadder) {
//        this.cells = cells;
        this.size = size;
        this.numberSnake = numberSnake;
        this.numberLadder = numberLadder;
    }

    public Cell getCells(int playerPosition) {
        int boardRow = playerPosition / cells.length;
        int boardColumn = playerPosition % cells.length;
        return cells[boardRow][boardColumn];
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumberSnake() {
        return numberSnake;
    }

    public void setNumberSnake(int numberSnake) {
        this.numberSnake = numberSnake;
    }

    public int getNumberLadder() {
        return numberLadder;
    }

    public void setNumberLadder(int numberLadder) {
        this.numberLadder = numberLadder;
    }

    public Cell[][] createBoard(int size){
        cells = new Cell[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                Cell cellObj = new Cell();
                cells[i][j] = new Cell();
            }
        }
        return cells;
    }


    public void addSnakeAndLadder(Cell[][] cells, int numberLadder, int numberSnake){

        while(numberSnake > 0){
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length+cells.length-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length+ cells.length-1);

            if(snakeTail > snakeHead)
                continue;

            Jump snakeObj = new Jump();
            snakeObj.start = snakeHead;
            snakeObj.end = snakeTail;

            Cell cell = getCells(snakeHead);
            cell.jump = snakeObj;
            numberSnake--;

        }

        while(numberLadder > 0){
            int ladderStart = ThreadLocalRandom.current().nextInt(1, cells.length+cells.length-1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1, cells.length+ cells.length-1);

            if(ladderStart > ladderEnd)
                continue;

            Jump ladderObj = new Jump();
            ladderObj.start = ladderStart;
            ladderObj.end = ladderEnd;

            Cell cell = getCells(ladderStart);
            cell.jump = ladderObj;
            numberLadder--;


        }
    }
}
