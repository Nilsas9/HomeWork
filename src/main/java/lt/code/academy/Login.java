package lt.code.academy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import netscape.javascript.JSObject;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Login {
//    public static User userInput;
//    private final Map<String, User> users;
   // private final LoginWriterReader loginWriterReader;


    public Login() {
        //loginWriterReader = new LoginWriterReader();
       // users = loginWriterReader.getUsers();
    }


        Login login = new Login();
        Scanner sc = new Scanner(System.in);


        String line;
        do {
            Login.menu();
            line = sc.nextLine();
            login.userSelection(sc, line);
        } while(!line.equals("3"));
    }

    private void userSelection(Scanner sc, String action) {
        switch(action) {
            case "1" -> userInput(sc);
            case "2" -> System.out.println("2");
            case "3" -> {

                //loginWriterReader.saveUsers(users);  //???????
                System.out.println("Viso gero!");
            }
            default -> System.out.println("Pasirinkite reikiama meniu punkta!");
        }


    }

//    private void login(Scanner sc) {
//        System.out.println("Iveskite username");
//        String username = sc.nextLine();
//        User user = users.get(username);
//        if(user == null) {
//            System.out.println("Tokio userio nera, prasome priregistruoti");
//            return;
//        }
//
//        System.out.println("Iveskite slaptazodi:");
//        String password = sc.nextLine();
//        if(!user.password().equals(DigestUtils.sha512Hex(password))) {
//            System.out.println("Neteisingas slaptazodis");
//            return;
//        }
//
//        System.out.printf("Sveiki prisijunge %s %s%n", user.name(), user.surname());
//    }

    private void userInput (Scanner scanner) {
        User user;
         //ObjectMapper objectMapper = new ObjectMapper();
//        do {
//            System.out.println("Iveskite username:");
//            userName = scanner.nextLine();
//            user = users.get(userName);
//            if(user != null) {
//                System.out.println("Toks vartotojas yra");
//            }
//        } while(user != null);
        System.out.println("Iveskite testo ID");
        String testId = scanner.nextLine();
        System.out.println("Iveskite varda:");
        String name = scanner.nextLine();
        System.out.println("Iveskite pavarde:");
        String surname = scanner.nextLine();



//
//        String repeatId;
//        do {
//            System.out.println("Iveskite teisinga testo ID:");
//            repeatId = scanner.nextLine();
//        } while(!repeatId.equals(testId));
//        user = new User(name ,surname, );
//        users.put(user);
    }

    private void menu() {
        System.out.println("""
								   [1]. Login (Prisijungti i testa)
								   [2]. Perziureti testo rezultatus
								   [3]. Iseiti
								   """);
    }
}

