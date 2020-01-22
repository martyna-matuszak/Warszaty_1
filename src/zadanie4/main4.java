package src.zadanie4;

import java.util.Arrays;
import java.util.Random;

public class main4 {

    public static void main(String[] args){
        String str = "2D20+10";
        System.out.println(diceRPG(str));
    }
    static int diceRPG (String str){
        int indexD = str.indexOf("D");
        int throwCount = 1;
        if (indexD > 0){
            throwCount = Integer.parseInt(str.substring(0,indexD));
        }
        int indexPlus = str.indexOf("+");
        int indexMinus = str.indexOf("-");
        int modifier = 0;
        int diceType = 0;
        if (indexPlus != -1){
            modifier = Integer.parseInt(str.substring(indexPlus+1, str.length()));
            diceType = Integer.parseInt(str.substring(indexD+1, indexPlus));
        }
        if (indexMinus != -1){
            modifier = Integer.parseInt(str.substring(indexMinus+1, str.length()));
            diceType = Integer.parseInt(str.substring(indexD+1, indexMinus));
        }
        if ((indexMinus==-1) && (indexPlus==-1)){
            diceType = Integer.parseInt(str.substring(indexD+1, str.length()));
        }

        //rzucić wyjątek, jeśli dicetype nie istnieje
        int[] validDiceTypes = {3, 4, 6, 8, 10, 12, 20, 100};
        int checkIfValid = 0;
        for (int i=0; i<validDiceTypes.length; i++){
            if(diceType==validDiceTypes[i]){
                checkIfValid++;
            }
        }
        if(checkIfValid==0){
            System.out.println("Podano niewłaściwy typ kostki");
        }

        //otrzymaliśmy zmienne, możemy przejść do rzutów kością i wyników

        int diceRPG = 0;
        Random r = new Random();
        for (int i = 0; i < throwCount; i++) {
            diceRPG += r.nextInt(diceType) + 1;
        }
        diceRPG += modifier;
        return diceRPG;

    }

}
