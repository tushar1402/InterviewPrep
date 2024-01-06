package Game;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    int diceCount;
    int min = 1;
    int max = 6;


    Dice(int diceCount){
        this.diceCount = diceCount;

    }

    public int rollDice(){
        int totalSum = 0;
        int diceused = 0;

        while(diceused < diceCount){
            totalSum = ThreadLocalRandom.current().nextInt(min,max+1);
            diceused++;
        }
        return totalSum;
    }
}
