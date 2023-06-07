import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


/**
 * The Class is a word-guessing game. It works as follows:
 * (1) The initial array wordBook contains eight elements, in which are eight kinds of pets,
 * including "Cat", "Dog", "Rabbit", "Fish", "Bird", "Hedgehog", "Ferret", and “Horse”.
 * (2) A secret pet will be selected randomly from the wordBook and asks the player to guess the
 * secret pet. The maximum number of tries is five.
 * (3) If the player guesses the right pet, the console displays “You win!”, then the program ends;
 * otherwise, the console displays “Sorry, you lost!” And keep continuing until five times of
 * tries are used up.
 */
public class WordGuessing {
    String[] wordBook = {"Cat", "Dog", "Rabbit", "Fish", "Bird", "Hedgehog", "Ferret", "Horse"};
    String secretPick;
    long inputTime;
    public void run(){
        System.out.println("There are 8 kinds of pets: " + Arrays.toString(wordBook) + "."
                + "\nI've picked one for you. Guess what is it? (Only 5 guesses allowed!)");
        Scanner scanner = new Scanner(System.in);
        secretPick = wordBook[new Random().nextInt(0, 8)];
        int i = 0;
        while(i++ < 5){
            long inputBeginTime = System.currentTimeMillis();
            String guess = scanner.nextLine();
            long inputEndTime = System.currentTimeMillis();
            inputTime += inputEndTime - inputBeginTime;
            if(!guess.equalsIgnoreCase(secretPick))
                System.out.println("Sorry, you lost! (" + i + " try)");
            else{
                System.out.println("You win!");
                break;
            }
        }
    }
    public static void main(String[] args){
        long beginTime = System.currentTimeMillis();
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

        WordGuessing game = new WordGuessing();
        game.run();

        long endTime = System.currentTimeMillis();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

        System.out.println("The compile time is: " + (endTime -beginTime - game.inputTime) + " ms");
        System.out.println("The execution time is: " + (endTime - beginTime)/1000 + " s");
        System.out.println("The memory usage is: " + (afterUsedMem - beforeUsedMem) + " bytes");
    }
}
