package lt.code.academy;


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
    public String testTime() {
        return testTime;
    }
}

