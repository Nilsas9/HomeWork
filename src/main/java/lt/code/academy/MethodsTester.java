//package lt.code.academy;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class MethodsTester {
//    public static void main(String[] args) {
//
//        Deze D = new Deze();
//        ArrayList<Vinis> vinys = new ArrayList<Vinis>(); // paprasciau nei Vinis[] jei nezinomas isankstinis dydis
//
//        String path = "kelias_iki_failo"; // pvz.: C://failai/failas.txt
//
//        try {
//            FileInputStream fis = new FileInputStream(path);
//            Scanner scan = new Scanner(fis);
//
//            while (scan.hasNextLine()) { // einam per eilutes
//                String line = scan.nextLine(); // nuskaitom esama eilute
//
//                if (line.startsWith("Vinis")) { // radom vini
//                    vinys.add(new Vinis(line));
//                } else if (line.startsWith("Dėžė")) { // radom deze
//                    deze.name = line;
//                }
//            }
//
//            scan.close();
//
//// Jei butinai reikia Vinis[], tada galima
//        //    Vinis[] vinysArr = vinys.toArray(new Vinis[vinys.size()]);
//
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found: " + path);
//        }
//    }
//}
