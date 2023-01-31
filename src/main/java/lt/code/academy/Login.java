//package lt.code.academy;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import netscape.javascript.JSObject;
//
//import java.awt.*;
//import java.io.File;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class Login {
//    public static User userInput;
//    private final Map<String, User> users;
//    private final LoginWriterReader loginWriterReader;
//
//
//
//    public Login() {
//        loginWriterReader = new LoginWriterReader();
//        users = loginWriterReader.saveUsers(new HashMap<>());
//    }
//
//    public static void main(String[] args) {
//        Login login = new Login();
//        Scanner sc = new Scanner(System.in);
//
//
//        String line;
//        do {
//            Login.menu();
//            line = sc.nextLine();
//            login.userSelection(sc, line);
//        } while(!line.equals("3"));
//    }
//
//    public void userSelection(Scanner sc, String action) {
//        switch(action) {
//            case "1" -> userInput(sc);
//            case "2" -> System.out.println("2");
//            case "3" -> {
//
//                loginWriterReader.saveUsers(users);  //???????
//                System.out.println("Viso gero!");
//            }
//            default -> System.out.println("Pasirinkite reikiama meniu punkta!");
//        }
//    }
//    public void userInput (Scanner scanner) {
//
//        System.out.println("Iveskite testo ID");
//        String testId = scanner.nextLine();
//        System.out.println("Iveskite varda:");
//        String name = scanner.nextLine();
//        System.out.println("Iveskite pavarde:");
//        String surname = scanner.nextLine();
//    }
//    public static void menu() {
//        System.out.println("""
//								   [1]. Login (Prisijungti i testa)
//								   [2]. Perziureti testo rezultatus
//								   [3]. Iseiti
//								   """);
//    }
//}
//
//
