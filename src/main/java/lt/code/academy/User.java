package lt.code.academy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

record User(
        @JsonProperty ("studentId")
        String studentId,
        @JsonProperty ("name")
        String name,
        String surname,
        String testID,
        String testTime,
        Object testResult,
        Object testAnswers
) {
    @Override
    public String studentId() {
        return studentId;
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
    public String testID() {
        return testID;
    }

    @Override
    public String testTime() {
        return testTime;
    }

    @Override
    public Object testResult() {
        return testResult;
    }

    @Override
    public Object testAnswers() {
        return testAnswers;
    }

    @Override
    public String toString() {
        return "User{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", testID='" + testID + '\'' +
                ", testTime='" + testTime + '\'' +
                ", testResult=" + testResult +
                ", testAnswers=" + testAnswers +
                '}';
    }
}