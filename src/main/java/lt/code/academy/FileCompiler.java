package lt.code.academy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class FileCompiler {
    ObjectMapper objectMapper = new ObjectMapper();
    UserSerializer user = new UserSerializer();
    SimpleModule module = new SimpleModule();
//		module.addSerializer(new UserSerializer());
//		module.addDeserializer(User.class, new UserDeserializer());

	//	objectMapper.registerModule(module);

   // User user = new User("Andrius", "Baltrunas", "andrius@codeacedamy.lt", 0, null);
    String json = objectMapper.writeValueAsString(user);

		//System.out.println(json);

    User deserializedUser = objectMapper.readValue(json, User.class);

    public FileCompiler() throws JsonProcessingException {
    }

    public User getDeserializedUser() {
        return deserializedUser;
    }

}
