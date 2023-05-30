import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WordGuessing {

    public static void main(String[] args){
        long beginTime = System.currentTimeMillis();

        String[] wordBook = {"Cat", "Dog", "Rabbit", "Fish", "Bird", "Hedgehog", "Ferret", "Horse"};
        System.out.println("There are 8 kinds of pets: " + Arrays.toString(wordBook) + "."
                            + "\nI've picked one for you. Guess what is it? (Only 5 guesses allowed!)");
        Scanner scanner = new Scanner(System.in);
        String secret = wordBook[new Random().nextInt(0, 8)];
        int i = 0;
        while(i++ < 5){
            String guess = scanner.nextLine();
            if(!guess.equalsIgnoreCase(secret))
                System.out.println("Sorry, you lost! (" + i + " try)");
            else{
                System.out.println("You win!");
                break;
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("The execution time is: " + (endTime - beginTime)/1000 + " s");
    }
}
