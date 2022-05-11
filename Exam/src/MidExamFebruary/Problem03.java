package MidExamFebruary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputLine = scan.nextLine();
        List<String> allCards = stringLineConvertToStringList(inputLine);
        List<String> finalDeck= new ArrayList<>();
        String[] commands = scan.nextLine().split("\\s+");

        while (!commands[0].equals("Ready")) {

            switch (commands[0]){
                case "Add":
                    String cardToAdd = commands[1];
                    if(allCards.contains(cardToAdd)){
                        finalDeck.add(cardToAdd);
                    }else {
                        System.out.println("Card not found.");
                    }
                    break;

                case "Insert":
                    String cardToInsert = commands[1];
                    int insertIndex = Integer.parseInt(commands[2]);
                    if (insertIndex<0 ||!allCards.contains(cardToInsert)){
                        System.out.println("Error!");
                    }else {
                        finalDeck.add(insertIndex,cardToInsert);
                    }
                    break;

                case "Remove":
                    String cardToRemove = commands[1];
                    if (finalDeck.contains(cardToRemove)){
                        finalDeck.remove(cardToRemove);
                    }else{
                        System.out.println("Card not found.");
                    }
                    break;

                case "Swap":

                    String temp = commands[2];
                    int firstIndex = finalDeck.indexOf(commands[1]);
                    int secondIndex = finalDeck.indexOf(commands[2]);
                    finalDeck.set(secondIndex,commands[1]);
                    finalDeck.set(firstIndex,temp);
                    break;

                case "Shuffle":
                    Collections.reverse(finalDeck);
                    break;



            }//end of switch
            commands=scan.nextLine().split("\\s+");
        }//end of while

        for (String item:finalDeck
             ) {
            System.out.print(item + " ");

        }
    }//end of main

    private static List<String> stringLineConvertToStringList(String inputLine) {
        String[] inputLineConvertedToArray = inputLine.split(":");

        List<String> commands = new ArrayList<>();
        for (int i = 0; i < inputLineConvertedToArray.length; i++) {
            String currentCommand = inputLineConvertedToArray[i];
            commands.add(currentCommand);

        }
        return commands;
    }
}
