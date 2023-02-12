package lt.code.academy;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
public class UserSerializer extends StdSerializer<User> {

    protected UserSerializer() {
        super(User.class);
    }

    @Override
    public void serialize(@NotNull User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeStringField("name", user.name());
        jsonGenerator.writeStringField("surname", user.surname());
        jsonGenerator.writeStringField("studentId", user.studentId());

        jsonGenerator.writeEndObject();
    }
}
