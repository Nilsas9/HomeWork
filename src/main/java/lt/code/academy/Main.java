package lt.code.academy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NullPointerException, NumberFormatException, NoSuchElementException, IOException {

        AllInOne all = new AllInOne();
        Scanner sc = new Scanner(System.in);

        String line;

        do {
            menu();
            line = sc.nextLine();
            all.userSelection(sc, line);
        } while (!line.equals("3"));
    }
    public static void menu() {
        System.out.println("""
                
                [1]. Login (Prisijungti i testa)
                [2]. Perziureti testo rezultatus
                [3]. Iseiti
                """);
    }
}