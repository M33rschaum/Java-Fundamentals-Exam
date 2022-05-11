package FinalExam;

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String message = scan.nextLine();
        String[] command = scan.nextLine().split("\\s+");
        while (!command[0].equals("End")) {
            String action = command[0];
            switch (action) {
                case "Translate":
                    String existedChar = command[1];
                    String replacement = command[2];
                    message = message.replace(existedChar, replacement);
                    System.out.println(message);
                    break;
                case "Includes":
                    String part = command[1];
                    if (message.contains(part)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    String firstPart = command[1];
                    if (message.startsWith(firstPart)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Lowercase":
                    message = message.toLowerCase();
                    System.out.println(message);
                    break;
                case "FindIndex":
                    String symbol = command[1];
                    int index = message.lastIndexOf(symbol);
                    System.out.println(index);
                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(command[1]);
                    int count = Integer.parseInt(command[2]);
                    String substring = message.substring(startIndex, startIndex + count);
                    message=message.replace(substring,"");
                    System.out.println(message);
                    break;
            }

            command = scan.nextLine().split("\\s+");
        }
    }
}





