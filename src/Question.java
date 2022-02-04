import java.io.Serializable;

public interface Question extends Serializable {

    void setQuestion(String question);
    void setAnswers(String[] answers);
    String[] getAnsOptions();
    int selectAnswer(int option);
    String getQuestion();
    String getSelectedAnswer();

}
