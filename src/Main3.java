package src;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args){
        reverseGuessingGame();
    }
    static void reverseGuessingGame(){
        System.out.println("Pomyśl liczbę od 0 do 1000 a ja ją zgadnę w max 10 próbach");
        int min=0, max=1001;
        Scanner scanner = new Scanner(System.in);
        int breakingPoint;

        for(int i=0; i<10; i++){
            int guess = (max-min)/2 + min;
            do {
                System.out.println("Próba "+ (i+1) +":  Zgaduję "+ guess);
                breakingPoint = 0;
                String usersHint = scanner.nextLine();

                switch (usersHint) {
                    case "zgadłeś" -> {
                        System.out.println("Wygrałem");
                        breakingPoint = 2;
                    }
                    case "za dużo" -> max = guess;
                    case "za mało" -> min = guess;
                    default -> {
                        System.out.println("Nie oszukuj! Wpisz: \"za mało\", \"za dużo\" lub \"zgadłeś\"");
                        breakingPoint = 1;
                    }
                }
            } while (breakingPoint==1);
            if (breakingPoint == 2){
                break;
            }
        }

    }

}
