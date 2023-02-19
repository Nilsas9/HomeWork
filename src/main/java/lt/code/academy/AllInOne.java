package lt.code.academy;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.jetbrains.annotations.NotNull;


public class AllInOne {
    private final File file = new File("user_test_results.json");
    private Map<String, User> users = new HashMap<>();
    private final ArrayList<String> studentAnswers = new ArrayList<>();
    private final ArrayList<String> trueAnswers = new ArrayList<>();
    private int numb = 1;
    private String testID;
    private String testName;
    private int testCount;


    public void userSelection(Scanner sc, @NotNull String action) {

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        switch (action) {
            case "1" -> {
                try {
                    readUsersFile();
                    userInput(sc);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case "2" -> {
                System.out.println("Jusu atsakymai: " + studentAnswers);
                System.out.println("Jusu ivertinimas: " + testCount);
            }
            case "3" -> System.out.println("Viso gero!");
            default -> System.out.println("Pasirinkite reikiama meniu punkta!");
        }
    }

    public void userInput(Scanner scanner) throws IOException, ClassCastException {

        String testBeginTime = dataTime();

        System.out.println("Iveskite studento ID");
        String studentId = scanner.nextLine();

        User previous = users.get(studentId);

        if (previous != null) {
            LocalDateTime last = dataTimeFromString(previous.testTime());
            if (last.plusDays(3).compareTo(LocalDateTime.now()) > 0) {
                System.out.println("Testa bus galima perlaikyti tik po 3 dienu. Jus sprendete si testa: " + previous.testTime());
            }
            return;
        }
        System.out.println("Iveskite varda:");
        String name = scanner.nextLine();
        System.out.println("Iveskite pavarde:");
        String surname = scanner.nextLine();

        if (studentId.isEmpty() || name.isEmpty() || surname.isEmpty()) {
            System.out.println("Prasau uzpildykite savo duomenis tinkamai!");
            return;
        } else
            System.out.printf("Sveiki, %s %s, ar pasiruose pradeti testa? T/N %n", name, surname);

        studentAnswers.clear();
        trueAnswers.clear();

        String choise = scanner.nextLine();

        if (choise.equals("T") || choise.equals("t")) {
            System.out.printf("Saunu, pradedam testa:%nSprendimo pradzios laikas: %s %n", testBeginTime);
            readLinesFromQuestionFile();
            users.put(studentId, new User(studentId, name, surname, testID, testName, testBeginTime, testCount, studentAnswers));
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
            this.testID = testID;

            String testName = br.readLine();
            this.testName = testName;
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
        //System.out.println("Jusu ivesti atsakymai: " + studentAnswers);
        testResult();


    }

    public void getCorrectUserAnswer(@NotNull Scanner sc) {
        while (true) {
            try {
                String input = sc.next();

                if (input.equals("a") || input.equals("b") || input.equals("c")) {
                    studentAnswers.add(numb++ + input);
                    return;
                }
                System.out.println("Pasirinkite is pateiktu variantu");
                sc.nextLine();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }


    public void readLinesFromAnswersFile() {

        try (BufferedReader br = new BufferedReader(new FileReader("test_answers.txt"))) {
            String line;

            br.readLine();
            br.readLine();
            br.readLine();

            while ((line = br.readLine()) != null) {
                trueAnswers.add(line);

            }

        } catch (IOException e) {
            System.out.println("Klaida eiluciu nuskaityme: " + e);

        }

        //  System.out.println("Teisingi atsakymai: " + trueAnswers);


    }

    public void testResult() {
        readLinesFromAnswersFile();

        String[] array1 = studentAnswers.toArray(new String[0]);
        String[] array2 = trueAnswers.toArray(new String[0]);
        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i].equals(array2[i])) {
                count += 1;
            }
        }

        numb = 1;
        testCount = count;
        // System.out.println("Jusu testo ivertinimas: " + count);
    }


    public void usersWriter() {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            mapper.writeValue(file, users);

        } catch (IOException e) {
            System.err.println("Klaida: " + e);
        }
    }

    public void readUsersFile() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            if (file.exists()) {

                users = mapper.readValue(file, HashMap.class);

            }
        } catch (IOException ignored) {

        }
    }


    private @NotNull String dataTime() {
        LocalDateTime testTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm");
        String fd = testTime.format(dtf);
        System.out.println(fd);
        return fd;
    }

    private @NotNull LocalDateTime dataTimeFromString(String string) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm");
        return LocalDateTime.parse(string, dtf);
    }

}





