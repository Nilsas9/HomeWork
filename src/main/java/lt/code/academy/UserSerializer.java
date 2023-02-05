package lt.code.academy;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
public class UserSerializer extends StdSerializer<User> {

    protected UserSerializer() {
        super(User.class);
    }

    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeStringField("userName", user.name());
        jsonGenerator.writeStringField("userSurname", user.surname());
        jsonGenerator.writeStringField("studentId", user.studentId());

        jsonGenerator.writeEndObject();
    }
}
