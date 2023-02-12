package lt.code.academy;


import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;


public class ReadLinesFromFile {

    private ReadLinesFromFile(Scanner scanner) {
        // Scanner scanner = new Scanner(System.in);

        int rez = 0;


        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("test_questions.txt"))) {

            String testID = br.readLine();
            System.out.println(testID);
            String testName = br.readLine();
            System.out.println(testName);
            br.readLine();
            System.out.printf("%nPradekime:%n");
            int n = 1;

            for (int i = 0; i < n; i++)

                do {
                    line = br.readLine();
                    System.out.println(line);
                    line = br.readLine();
                    System.out.println(line);
                    line = br.readLine();
                    System.out.println(line);
                    line = br.readLine();
                    System.out.println(line);
                    System.out.println("Iveskite atsakyma:");
                    String answer = scanner.nextLine();

                    if (answer.equals("a")) {
                        System.out.println("volia");
                        rez++;

                    }
                } while (br.readLine() != null);


        } catch (IOException e) {
            System.out.println(e);
        }
        scanner.close();
        System.out.println("Baigete spresti testa, Jusu ivertinimas: " + rez);

    }
}
