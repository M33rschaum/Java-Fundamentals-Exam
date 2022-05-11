package MidExamFebruary;

import java.util.*;
import java.util.stream.Collectors;

public class Problem02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();
        List<Integer> numbers = stringLineConvertToIntegerList(inputLine);
        String commands = scan.nextLine();

        while (!commands.equals("end")) {
            String[] currentCommand = commands.split("\\s+");

            switch (currentCommand[0]) {
                case "reverse":
                    int startIndex = Integer.parseInt(currentCommand[2]);
                    int countTimes = Integer.parseInt(currentCommand[4]);

                    for (int i = 2; i <= (countTimes + startIndex) / 2; i++) {
                        int old = numbers.get(i);
                        numbers.set(i, numbers.get((countTimes + startIndex * 2) - 1 - i));
                        numbers.set((countTimes + startIndex * 2) - 1 - i, old);
                    }
                    break;

                case "sort":
                    int from = Integer.parseInt(currentCommand[2]);
                    int turns = Integer.parseInt(currentCommand[4]);
                    int to = from+turns;
                    List<Integer> temp = numbers.subList(from, to);
                    Collections.sort(numbers.subList(from, to));


                    break;
                case "remove":
                    int removeCount = Integer.parseInt(currentCommand[1]);
                    for (int i = 0; i < removeCount; i++) {
                        numbers.remove(0);
                    }
                    break;


            }//end of switch

            commands = scan.nextLine();
        }//end of while

        String result = numbers.stream()
                .map(s -> String.valueOf(s))
                .collect(Collectors.joining(", "));
        System.out.println(result);

    }//end of main

    private static List<Integer> stringLineConvertToIntegerList(String inputLine) {
        String[] inputLineConvertedToArray = inputLine.split(" ");

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < inputLineConvertedToArray.length; i++) {
            int currentNumber = Integer.parseInt(inputLineConvertedToArray[i]);
            numbers.add(currentNumber);

        }
        return numbers;
    }
}
