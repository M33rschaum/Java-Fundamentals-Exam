package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lineNumber = Integer.parseInt(scan.nextLine());
String regex = "([^\\s]+)>(?<numbers>\\d{3})\\|(?<low>[a-z]{3})\\|(?<up>[A-Z]{3})\\|(?<sym>[^<>]{3})<\\1";
        //String regex = "(.*)>(?<numbers>[\\d]{3})\\|(?<low>[a-z]{3})\\|(?<up>[A-Z]{3})\\|(?<sym>[^<>]{3})<\\1";
        Pattern pattern = Pattern.compile(regex);


        for (int i = 0; i < lineNumber; i++) {
            String tryPassword = scan.nextLine();
            Matcher matcher = pattern.matcher(tryPassword);

            if (matcher.find()) {
                //валиден
                StringBuilder decryptedPassword = new StringBuilder();
                String numbers = matcher.group("numbers");
                String low = matcher.group("low");
                String up = matcher.group("up");
                String sym = matcher.group("sym");
                decryptedPassword.append(numbers).append(low).append(up).append(sym);
                System.out.println("Password: "+decryptedPassword);

            }else{
                System.out.println("Try another password!");

            }

        }
    }
}