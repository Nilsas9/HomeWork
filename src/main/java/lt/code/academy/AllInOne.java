package lt.code.academy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class AllInOne {
    private int numb = 1;

    public void userSelection(Scanner sc, @NotNull String action) {

        switch (action) {
            case "1" -> {
                try {
                    userInput(sc);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case "2" -> {
                // usersWriter();
                //findStudent(sc);
                // System.out.println("Jusu atsakymai: " + studentAnswers);

            }
            case "3" -> {
                // usersWriter();
                System.out.println("Viso gero!");

            }
            default -> System.out.println("Pasirinkite reikiama meniu punkta!");
        }
    }

    private final Map<String, User> users = new HashMap<>();
    private final ArrayList<String> studentAnswers = new ArrayList<>();
    private final ArrayList<String> trueAnswers = new ArrayList<>();
    private final File file = new File("users_test.json");


    public void userInput(Scanner scanner) throws IOException {

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Negaliu sukurti failo " + e.getMessage());
            }
        }
        String testBeginTime = dataTime();

        System.out.println("Iveskite studento ID");
        String studentId = scanner.nextLine();

        //todo cia reikia padaryt, kad negaletu tas pats jungtis

        System.out.println("Iveskite varda:");
        String name = scanner.nextLine();
        System.out.println("Iveskite pavarde:");
        String surname = scanner.nextLine();

        System.out.printf("Sveiki, %s %s, ar pasiruose pradeti testa? T/N %n", name, surname);


        String choise = scanner.nextLine();
        if (choise.equals("T") || choise.equals("t")) {

            System.out.printf("Saunu, pradedam testa:%nSprendimo pradzios laikas: %s %n", testBeginTime);
            users.put("Test time: " + testBeginTime, new User(name, surname, studentId));

            readLinesFromQuestionFile();
            usersWriter();

        } else if ((choise.equals("N") || choise.equals("n"))) {
            System.out.println("Tada dar pasimokykite");

        } else System.out.println("blogas pasirinkimas");

    }

    public void readLinesFromQuestionFile() throws NoSuchElementException {
        Scanner scanner = new Scanner(System.in);
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
                    System.out.println("Pasirinkite atsakyma: 'a', 'b' arba 'c'");

                    getCorrectUserAnswer(scanner);


                } while (br.readLine() != null);

        } catch (IOException e) {
            System.out.println("Klaida eiluciu nuskaityme");
        }
        System.out.println(studentAnswers);

        testResult();
        //System.out.printf("Baigete spresti testa, Jusu ivertinimas: %s%n");
    }

    private void getCorrectUserAnswer(@NotNull Scanner sc) {

        while (true) {
            try {
                String input = sc.next();
                if (input.equals("a") || input.equals("b") || input.equals("c")) {
                    studentAnswers.add(numb++ + input);
                    return;
                }
                System.out.println("Iveskite pateikta varianta");
                sc.nextLine();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }


    public void readLinesFromAnswersFile() {

        try (BufferedReader br = new BufferedReader(new FileReader("test_answers.txt"))) {
            String line;

            String testID = br.readLine();
            System.out.println(testID);
            String testName = br.readLine();
            System.out.println(testName);
            br.readLine();

            while ((line = br.readLine()) != null) {
                trueAnswers.add(line);
            }

        } catch (IOException e) {
            System.out.println("Klaida eiluciu nuskaityme: " + e);
        }

        System.out.println("Teisingi atsakymai: " + trueAnswers);


    }

    private void testResult() {
        readLinesFromAnswersFile();
        String[] array1 = studentAnswers.toArray(new String[0]);
        String[] array2 = trueAnswers.toArray(new String[0]);
        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i].equals(array2[i])) {
                count += 1;
            }
        }
        System.out.println("Jusu testo ivertinimas: " + count);

    }

    public void usersWriter() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(file, users);

            System.out.println(users);   // sitas atspausdina eilute su uzpildytu useriu
            System.out.println("---------Ivyko irasymas userio-------");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private @NotNull String dataTime() {
        LocalDateTime testTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm");
        String fd = testTime.format(dtf);
        System.out.println(fd);
        return fd;
    }

    public void printOut() throws IOException {
        serializationMethod();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);


        //--------
        // File file = new File("users_test.json");

        User readValue = mapper.readValue(file, User.class);
        String stringUser = mapper.writeValueAsString(readValue); //veikia spausdinimas!!!

        System.out.println(stringUser);
        System.out.println(mapper);

        //-------


//        User deserializedUser = mapper.readValue(file, User.class); //todo rodo kad nulas
//        System.out.println(deserializedUser);

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

    private void findStudent(Scanner sc) throws NullPointerException {

//        System.out.printf("Iveskite testo ID:%n");
//        String tId = sc.nextLine();
        System.out.printf("Iveskite studento ID:%n");
        String id = sc.nextLine();
        User us = users.get(id);  // TODO: 2023-02-06

        if (id.equals("33")) {   // todo reikia daryt
            try {
                // serializationMethod();
                printOut();
                System.out.println("blablabla");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("Tvarka, leidziu atidaryt faila%n");

        } else
            System.out.printf("Tokio studento pagal paduota id: %s nera! %n%n", id);

    }

    public void serializationMethod() throws IOException {
        //  usersWriter();  // salinti jei nepapildys duomenu jaujais useriais
        ObjectMapper objectMapper = new ObjectMapper();
        //  ObjectMapper mapper = new ObjectMapper();
        //   File file = new File("users_test.json");
        SimpleModule module = new SimpleModule();
        module.addSerializer(User.class, new UserSerializer());
        module.addDeserializer(User.class, new UserDeserializer());

        objectMapper.registerModule(module);

        //   User user = new User("Andrius", "Baltrunas", "andrius@codeacedamy.lt");
        String json = objectMapper.writeValueAsString(file);


        System.out.println("Json ->>>>>" + json);
        System.out.println("Spausdinu faila:   " + file);
//
//        User deserializedUser = objectMapper.readValue(json, User.class);
//        System.out.println(deserializedUser);

//        User readValue = mapper.readValue(file, User.class);
//        String stringUser = mapper.writeValueAsString(readValue); //veikia spausdinimas!!!
//
//        System.out.println(stringUser);
    }
}






