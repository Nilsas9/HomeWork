package lt.code.academy;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class UserDeserializer extends StdDeserializer<User> {
    protected UserDeserializer() {
        super(User.class);
    }

    @Override
    public User deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JacksonException {
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);

        String name = getValue(jsonNode, "name");
        String surname = getValue(jsonNode, "surname");
        String studentId = getValue(jsonNode, "studentId");

        return new User(name, surname, studentId);
    }

    private String getValue(JsonNode jsonNode, String fieldName) {
        JsonNode value = jsonNode.get(fieldName);
        return value != null ? value.asText() : null;
    }
}

