package lt.code.academy;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;

public class AllInOne {


    public static void main(String[] args) {

        //  Map<String, User> users;

        AllInOne allInOne = new AllInOne();
        Scanner sc = new Scanner(System.in);


        String line;
        do {
            allInOne.menu();
            line = sc.nextLine();
            userSelection(sc, line);
        } while (!line.equals("3"));
    }

    public static void userSelection(Scanner sc, String action) {
        switch (action) {
            case "1" -> {
                try {
                    userInput(sc);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case "2" -> System.out.println("2");
            case "3" -> {

                //loginWriterReader.saveUsers(users);  //???????
                System.out.println("Reikia irasyti duomenis!!!!");
                System.out.println("Viso gero!");
            }
            default -> System.out.println("Pasirinkite reikiama meniu punkta!");
        }
    }

    public static void userInput(Scanner scanner) throws IOException {
        User user;
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("users.json");
        //if (!file.exists()) {
        // file.createNewFile();

        System.out.println("Iveskite testo ID");
        String testId = scanner.nextLine();
        System.out.println("Iveskite varda:");
        String name = scanner.nextLine();
        System.out.println("Iveskite pavarde:");
        String surname = scanner.nextLine();

        user = new User(name, surname, testId);
        mapper.writeValue(file, List.of(file, user));
        System.out.println(mapper.writeValueAsString(user));

        System.out.println("reikia permesti i jason" + user);  // tikrinu ivesti

        if (testId.equals("33")) {
            System.out.println("ivestis gera");
        } else
            System.out.println("Ivestis bloga");

    }



        private void menu () {
            System.out.println("""
                    [1]. Login (Prisijungti i testa)
                    [2]. Perziureti testo rezultatus
                    [3]. Iseiti
                    """);
        }

    }

