package lt.code.academy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class AllInOne {

    private static User userInput;
    static AllInOne findStudent;
    //  File file = new File("users_test.json");

    public static void main(String[] args) throws FileNotFoundException {

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
        //  CustomUserSerializer serializationMethod = new CustomUserSerializer();


        switch (action) {
            case "1" -> {
                try {
                    userInput(sc);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case "2" -> {
                findStudent(sc);
            }
            case "3" -> {

                //loginWriterReader.saveUsers(users);  //???????
                System.out.println("Reikia irasyti duomenis!!!!");
                System.out.println("Viso gero!");
            }
            default -> System.out.println("Pasirinkite reikiama meniu punkta!");
        }
    }

    public static User userInput(Scanner scanner) throws IOException {
        User user;
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String testBeginTime = dataTime();

        File file = new File("users_test.json");
        if (!file.exists()) {
            file.createNewFile();
        }

        System.out.println("Iveskite studento ID");
        String studentId = scanner.nextLine();

        System.out.println("Iveskite varda:");
        String name = scanner.nextLine();
        System.out.println("Iveskite pavarde:");
        String surname = scanner.nextLine();
        // user.put(studentId, new User(name, surname, studentId)); // reik salint
        user = new User(name, surname, studentId);

        mapper.writeValue(file, user);


        System.out.printf("Sveiki %s %s, ar pasiruose pradeti testa? T/N %n", name, surname);

        String choise = scanner.nextLine();
        if (choise.equals("T") || choise.equals("t")) {
            System.out.printf("Saunu, pradedam testa:%n Sprendimo pradzios laikas: %s %n", testBeginTime);
            // TODO: 2023-02-05   turiu ideti metoda testo sprendimui
        } else
            System.out.println("Blogas pasirinkimas");
        return user;


        // tikrinu ar tas pats testo ID

//        if (studentId.equals("33")) {
//            System.out.println("ivestis gera");
//        } else
//            System.out.println("Ivestis bloga");

    }

    private static @NotNull String dataTime() {
        LocalDateTime testTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm");
        String fd = testTime.format(dtf);
        System.out.println(fd);
        return fd;
    }

//    public static void setUserInput(User userInput) {
//        AllInOne.userInput = userInput;
//    }


    private void menu() {
        System.out.println("""
                [1]. Login (Prisijungti i testa)
                [2]. Perziureti testo rezultatus
                [3]. Iseiti
                """);
    }


    public static void printOut() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File("users_test.json");

        User readValue = mapper.readValue(file, User.class);
        String stringUser = mapper.writeValueAsString(readValue); //veikia spausdinimas!!!

        System.out.println(stringUser);

//        System.out.println("Iveskite studento ID");
//        String compareStudentId = sc.nextLine();
//
//        if (compareStudentId.equals()) {
//            System.out.println("ivestis gera");
//
//        } else
//            System.out.println("Ivestis bloga");


        //  User user = new User("1", "2","444444");
        //  User secondUser = new User("Petras", "Petraitis", "petraitis@codeacademy.lt");

        // write object to file
        //       mapper.writeValue(file, user);

        // read object from file         cia ismeta teksta vienoje eiluteje

//        //string to object
//        User objectUser = mapper.readValue(stringUser, User.class);
//        System.out.println(objectUser);
//
//        //write few object to json file
//  //      mapper.writeValue(file, List.of(user, secondUser, objectUser));
//
//        //read few objects from file
//        List<User> user = mapper.readValue(file, new TypeReference<>() {
//        });
//        System.out.println(user);
////
//        System.out.println("aaaaaaa" + mapper.writeValueAsString(readValue));

        //      Map<String, Object> map = mapper.readValue(stringUser, new TypeReference<>() {
        //      });
        //      System.out.println(map.get("netikrasVardas"));
        //       System.out.println(map.get("kitaPavarde"));
    }

    public static void findStudent(@NotNull Scanner sc) {
        AllInOne allInOne = new AllInOne();
        //User user = new User(userInput.name(), userInput.surname(), userInput.studentId());


        System.out.printf("Iveskite studento ID:%n");
        String nr = sc.nextLine();


        if (nr.equals("33")) {
            System.out.printf("Tvarka, leidziu atidaryt faila%n");

        } else
            System.out.printf("Tokio studento pagal paduota id: %s nera! %n%n", nr);
    }
}






