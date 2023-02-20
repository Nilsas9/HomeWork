package lt.code.academy;

import org.jetbrains.annotations.NotNull;

record User(

        String studentId,
        String name,
        String surname,
        String testID,
        String testName,
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
    public String testName() {
        return testName;
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
    public String testTime() {
        return testTime;
    }


    @Override
    public @NotNull String toString() {
        return "User{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", testID='" + testID + '\'' +
                ", testName='" + testName + '\'' +
                ", testTime='" + testTime + '\'' +
                ", testResult=" + testResult +
                ", testAnswers=" + testAnswers +
                '}';
    }
}

