package src;

import java.util.*;

public class Main2 {

    public static void main(String[] args){
        System.out.println("Wybierz 6 różnych liczb od 1 do 49");
        lottoDrawing();
    }

    static int[]  picks(){
        Scanner scanner = new Scanner(System.in);
        int[] picks = new int[6];
        for(int i=0; i<6; i++){
            do {
                try {
                    String currentGuess = scanner.next();
                    int pick = Integer.parseInt(currentGuess);
                    picks[i] = pick;
                    checkIfInRange(picks,pick,i);
                    checkIfUnique(picks,pick,i,true);

                } catch (NumberFormatException e){
                    System.out.println("To nie jest liczba");
                    picks[i] = -1;
                }
            } while (picks[i] == -1);
        }
        Arrays.sort(picks);
        return picks;
    }

    static void checkIfInRange(int[] tableOfNumbers, int newNumber, int counter){
        if((newNumber>49) || (newNumber<1)){
            tableOfNumbers[counter] = -1;
            System.out.println("Wprowadzono liczbę spoza zakresu");
        }
    }

    static void checkIfUnique(int[] tableOfNumbers, int newNumber, int counter, boolean response){
        for (int i=0; i<counter; i++){
            if (newNumber == tableOfNumbers[i]){
                tableOfNumbers[counter] = -1;
                if(response){
                    System.out.println("Wprowadzono ponownie tą samą liczbę");
                }
            }
        }
    }

    static int[] lottoScores(){
        int[]scores = new int[6];
        Random r = new Random();

        for(int i=0; i<6; i++){
            do{
                int score = r.nextInt(49)+1;
                scores[i] = score;
                checkIfUnique(scores,score,i,false);
            }while(scores[i] == -1);
        }
        Arrays.sort(scores);
        return scores;
    }

    static int checkScore(int[] picks, int[] scores){
        int hits = 0;
        for (int pick : picks) {
            for(int score : scores){
                if (pick==score){
                    hits++;
                }
            }
        }
        return hits;
    }


    static void lottoDrawing(){
        int[] userPicks = picks();
        System.out.println(Arrays.toString(userPicks));

        int[] lottoScores = lottoScores();
        System.out.println(Arrays.toString(lottoScores));

        int userScore = checkScore(userPicks, lottoScores);
        if (userScore>2){
            System.out.println("Trafiono " + userScore);
        } else {
            System.out.println("Przegrałeś :(");
        }
    }

    }
