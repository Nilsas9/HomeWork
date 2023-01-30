package lt.code.academy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
record User(
        String name,
        String surname,
        String testId
) {

    User(String name, String surname, String testId) {
        this.name = name;
        this.surname = surname;
        this.testId = testId;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String surname() {
        return surname;
    }

    @Override
    public String testId() {
        return testId;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", testId=" + testId +
                '}';
    }
}