package src.zadanie2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class main2 {

    public static void main(String[] args){
        lottoDrawing();
    }

    static int[]  types(){
        Scanner scanner = new Scanner(System.in);
        int[] types = new int[6];
        for(int i=0; i<6; i++){
            do {
                try {
                    String temp = scanner.next();
                    int type = Integer.parseInt(temp);
                    types[i] = type;
                    if((type>49) || (type<1)){
                        types[i] = -1;
                        System.out.println("Wprowadzono liczbę spoza zakresu");
                    }
                    for (int j=0; j<i; j++){
                        if (type == types[j]){
                            types[i] = -1;
                            System.out.println("Wprowadzono ponownie tą samą liczbę");
                        }
                    }
                } catch (NumberFormatException e){
                    System.out.println("To nie jest liczba");
                    types[i] = -1;
                }
            } while (types[i] == -1);
        } return types;
    }

    static int[]  lottoScores(){
        Random r = new Random();
        int[] scores = new int[6];
        int counter = 0;
        do {
            int score = r.nextInt(49)+1;
            int check = 0;
            for (int i=0; i<counter; i++){
                if (score == scores[i]){
                    check++;
                }
            }
            if (check==0){
                scores[counter] = score;
                counter++;
            }
        } while (counter<6);
        return scores;
    }

    static int checkScore(int[] types, int[] lottoScores ){
        int counter = 0;
        for (int i = 0; i < types.length ; i++) {
            for (int j = 0; j < lottoScores.length ; j++) {
                if (types[i]==lottoScores[j]){
                    counter++;
                }
            }

        }
        return counter;
    }

    static void lottoDrawing(){
        int[] userTypes = types();
        Arrays.sort(userTypes);
        System.out.println(Arrays.toString(userTypes));
        int[] lottoScores = lottoScores();
        System.out.println(Arrays.toString(lottoScores));
        int userScore = checkScore(userTypes, lottoScores);
        if ((2 < userScore) && (userScore < 7)){
            System.out.println("Trafiono " + userScore);
        } else {
            System.out.println("Przegrałeś :(");
        }
    }


    }
