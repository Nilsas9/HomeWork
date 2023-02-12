package lt.code.academy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;


public class CustomUserSerializer {

    public void serializationMethod () throws JsonProcessingException{

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("users_test.json");
        SimpleModule module = new SimpleModule();
        module.addSerializer(User.class, new UserSerializer());
        module.addDeserializer(User.class, new UserDeserializer());

        objectMapper.registerModule(module);

       // User user = new User("Andrius", "Baltrunas", "andrius@codeacedamy.lt");
        String json = objectMapper.writeValueAsString(file);


        System.out.println(json);

        User deserializedUser = objectMapper.readValue(json, User.class);
        System.out.println(deserializedUser);
    }
}

