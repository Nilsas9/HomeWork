package lt.code.academy;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.*;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    public static void userSelection(Scanner sc, @NotNull String action) {
        switch (action) {
            case "1" -> {
                try {
                    userInput(sc);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case "2" -> testResult();
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
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File("users_test.json");
        if (!file.exists()) file.createNewFile();

        System.out.println("Iveskite testo ID");
        String testId = scanner.nextLine();
        System.out.println("Iveskite varda:");
        String name = scanner.nextLine();
        System.out.println("Iveskite pavarde:");
        String surname = scanner.nextLine();

        user = new User(name, surname, testId);
        mapper.writeValue(file, user);
        System.out.printf("Sveiki %s %s, ar pasiruose pradeti testa? T/N%n", name, surname);
        String choise = scanner.nextLine();
        if (choise.equals("T") || choise.equals("t")) {
            System.out.println("saunu, pradedam testa:");
        } else return;


        // tikrinu ar tas pats testo ID

        if (testId.equals("33")) {
            System.out.println("ivestis gera");
        } else
            System.out.println("Ivestis bloga");

    }


    private void menu() {
        System.out.println("""
                [1]. Login (Prisijungti i testa)
                [2]. Perziureti testo rezultatus
                [3]. Iseiti
                """);
    }

    public static void testResult() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("users_test.json"));
            // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);
            System.out.println(obj);
            // A JSON array. JSONObject supports java.util.List interface.
            //          JSONArray companyList = (JSONArray) jsonObject.get("Company List");
            // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
            // Iterators differ from enumerations in two ways:
            // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
            // 2. Method names have been improved.
            //           Iterator<JSONObject> iterator = companyList.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


