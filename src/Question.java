public interface Question {

    void setQuestion(String question);
    void setAnswers(String[] answers);
    void selectAnswer(int option);
    String getQuestion();
    String getSelectedAnswer();

}
