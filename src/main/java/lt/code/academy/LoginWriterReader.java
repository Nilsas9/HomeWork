//package lt.code.academy;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//
//import java.io.*;
//import java.util.HashMap;
//import java.util.Map;
//
//public class LoginWriterReader {
//    private static final String FILE_NAME = "failo vardas";
//
//    Map<String, User> getUsers() throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);
//        File file = new File("failo pavadinimas");
//        //file.createNewFile();
//        return null;
//
//
//        Map<String, User> users = new HashMap<>();
//        try (ObjectInput oi = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
//            while (true) {
//                User user = (User) oi.readObject();
//                users.put(user.toString(), user);
//            }
//        } catch (EOFException e) {
//            // failas nuskaitytas
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//
//        Map<String, User> saveUsers (Map < String, User > users){
//            try (ObjectOutput ob = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
//                for (User user : users.values()) {
//                    ob.writeObject(user);
//                }
//            } catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
//            return users;
//        }
//
//    }
//
//
//}