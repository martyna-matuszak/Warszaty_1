package src.zadanie1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class main1 {

    public static void main(String[] args){
        guessingGame();

    }

    static void guessingGame() {
        Random r = new Random();
        int number = r.nextInt(100)+1;
        System.out.println("Zgadnij liczbę");
        Scanner scanner = new Scanner(System.in);
        int guess = -1;
        do {
            try {
                String temp = scanner.next();
                guess = Integer.parseInt(temp);
                if(guess>number){
                    System.out.println("Za dużo!");
                } else if (guess<number){
                    System.out.println("Za mało!");
                }
            } catch (NumberFormatException e){
                System.out.println("To nie jest liczba");
                guess = -1;
            }

        } while (guess != number);
        System.out.println("Zgadłeś!");
    }


}
