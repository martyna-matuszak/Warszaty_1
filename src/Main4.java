package src;

import java.util.Random;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args){
        System.out.println(diceRPG());
    }

    static int diceRPG(){
        System.out.println("Symulator rzutu kostką RPG");
        Scanner scanner = new Scanner(System.in);
        String diceThrow = "";
        do{
            String userDiceThrow = scanner.nextLine();
            String upperCaseDiceThrow = userDiceThrow.toUpperCase().trim();
            if (!upperCaseDiceThrow.matches("[1-9]*D\\d*([+\\-]\\d+)?")) {
                System.out.println("Błędny format kostki");
            } else if (!isDiceTypeValid(upperCaseDiceThrow)){
                System.out.println("Podany typ kostki nie istnieje");
            } else {
                diceThrow = upperCaseDiceThrow;
            }
        } while (diceThrow.isBlank());

        int throwCount = throwCount(diceThrow);
        int diceType = diceType(diceThrow);
        int modifier = modifier(diceThrow);

        return score(throwCount, diceType, modifier);
    }

    static int throwCount(String diceThrow){
        int dIndex = diceThrow.indexOf("D");
        if(dIndex == 0){
            return 1;
        } else {
            return Integer.parseInt(diceThrow.substring(0,dIndex));
        }
    }

    static int diceType(String diceThrow){
        int dIndex = diceThrow.indexOf("D");
        int plusMinusIndex;
        if(diceThrow.contains("+")){
            plusMinusIndex = diceThrow.indexOf("+");
        } else if (diceThrow.contains("-")){
            plusMinusIndex = diceThrow.indexOf("-");
        } else {
            plusMinusIndex = diceThrow.length();
        }
        return Integer.parseInt(diceThrow.substring(dIndex+1,plusMinusIndex));
    }

    static boolean isDiceTypeValid (String diceThrow){
        int diceType = diceType(diceThrow);
        int[] validDiceTypes = {3, 4, 6, 8, 10, 12, 20, 100};
        for (int validDiceType : validDiceTypes) {
            if(diceType == validDiceType){
                return true;
            }
        }
        return false;
    }

    static int modifier (String diceThrow){
        int modifier;
        if(diceThrow.contains("+")){
            int indexOfPlus = diceThrow.indexOf("+");
            modifier = Integer.parseInt(diceThrow.substring(indexOfPlus+1));
        } else if (diceThrow.contains("-")){
            int indexOfMinus = diceThrow.indexOf("-");
            modifier = -1 * Integer.parseInt(diceThrow.substring(indexOfMinus+1));
        } else {
            modifier=0;
        }
        return modifier;
    }

    static int score (int throwCount, int diceType, int modifier){
        int score = 0;
        Random r = new Random();
        for(int i=0; i<throwCount; i++){
            int randomThrow = r.nextInt(diceType)+1;
            score += randomThrow;
        }
        return score + modifier;
    }

}
