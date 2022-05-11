package MidExamFebruary;

import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countOfOrders = Integer.parseInt(scan.nextLine());
        double totalSum = 0;


        for (int i = 1; i <= countOfOrders; i++) {
            double pricePerCapsule = Double.parseDouble(scan.nextLine());
            int days = Integer.parseInt(scan.nextLine());
            int capsulesCount = Integer.parseInt(scan.nextLine());
            double price = (days * capsulesCount) * pricePerCapsule;

            System.out.printf("The price for the coffee is: $%.2f%n",price);
            totalSum += price;
        }
        System.out.printf("Total: $%.2f",totalSum);
    }
}
