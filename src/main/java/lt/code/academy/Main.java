package lt.code.academy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        AllInOne allInOne = new AllInOne();





        //        ObjectMapper mapper = new ObjectMapper();
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);

    //    User user = new User(Login.userInput.name(), Login.userInput.surname(), Login.userInput.testId());
//       // User user = new User(null, "Baltrunas", "andrius@codeacademy.lt", 35, List.of(new Address("Kaunas", "LT"), new Address("Vilnius", "LT")));
//       // User secondUser = new User("Petras", "Petraitis", "petraitis@codeacademy.lt", 49, null);
//
//        File file = new File("json failas");
//        if(!file.exists()) {
//            file.createNewFile();
//        }
//
//        // write object to file
//        mapper.writeValue(file, user);
//
//        // read object from file
//        User readValue = mapper.readValue(file, User.class);
//        System.out.println(readValue);
//
//        // object to string
////        String stringUser = mapper.writeValueAsString(secondUser);
////        System.out.println(stringUser);
//
//
//        //string to object
////        User objectUser = mapper.readValue(stringUser, User.class);
////        System.out.println(objectUser);
//
//        //write few object to json file
//       // mapper.writeValue(file, List.of(user, secondUser, objectUser));
//
//        //read few objects from file
//        List<User> users = mapper.readValue(file, new TypeReference<>() {});
//        System.out.println(user);
//
//        System.out.println(mapper.writeValueAsString(users));
//
////        Map<String, Object> map = mapper.readValue(stringUser, new TypeReference<>() {});
////        System.out.println(map.get("netikrasVardas"));
////        System.out.println(map.get("kitaPavarde"));
//

    }

}