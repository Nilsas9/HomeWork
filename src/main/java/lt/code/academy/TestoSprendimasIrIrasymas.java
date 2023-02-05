package lt.code.academy;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class TestoSprendimasIrIrasymas {
    public static void main(String[] args) {


        try (BufferedReader br = new BufferedReader(new FileReader("test_answers.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.length() > 5) {

                    System.out.println("*****");

                } else if (line.startsWith("3.")) {
                    System.out.printf("Va sita: %s%n", line);

                } else
                    System.out.println(line);
//                System.out.println(line.length());
//                System.out.println(line.trim());

            }
        } catch (IOException e) {
            System.out.println("Cannot read file " + e.getMessage());
        }

    }

    public static void lineByLine() throws FileNotFoundException {
        System.out.println("skaitau eilutes");
        //String separator = File.separator;


        File file = new File("test_answers.txt");

        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        String[] numbersString = line.split(" ");
        int[] numbers = new int[10];
        int counter = 0;

        for (String number : numbersString) {
            numbers[counter++] = Integer.parseInt(number);
        }
        System.out.println(Arrays.toString(numbers));
        scanner.close();
    }

}


