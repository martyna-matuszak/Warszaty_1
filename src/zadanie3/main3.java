package src.zadanie3;

import java.util.Scanner;

public class main3 {

    public static void main(String[] args){
        reverseGuessingGame();
    }
    static void reverseGuessingGame(){
        System.out.println("Pomyśl liczbę od 0 do 1000 a ja ją zgadnę w max 10 próbach");
        int min=0, max=1000;
        Scanner scanner = new Scanner(System.in);
        int breakingPoint = 0;
        for(int i=0; i<10; i++){
//            System.out.println(i+1); (tu sobie sprawdzam, która w tej chwili jest próba :)
            int guess = (max-min)/2 + min;
            do {
                breakingPoint = 0;
                System.out.println("Zgaduję "+ guess);
                String usersHint = scanner.nextLine();
                if (usersHint.equals("zgadłeś")){
                    System.out.println("Wygrałem");
                    breakingPoint = 2;
                    break;
                } else if (usersHint.equals("za dużo")){
                    max = guess;
                } else if (usersHint.equals("za mało")){
                    min = guess;
                } else {
                    System.out.println("nie oszukuj!");
                    breakingPoint=1;
                }
            } while (breakingPoint==1);
            if (breakingPoint == 2){
                break;
            }
            //zaimplementowane wg schematu blokowego nie ma szans dać nam 1000 :)
        }



    }

}
