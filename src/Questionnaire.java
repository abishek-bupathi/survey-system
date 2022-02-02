import java.io.Serializable;
import java.util.ArrayList;

public interface Questionnaire extends Serializable{

    void setName(String name);
    void setId(int id);
    void setPurpose(String purpose);
    void setCompleted();
    int getId();
    String getName();
    String getPurpose();
    int getNoOfCompletedInstances();
    void addQuestions(ArrayList<Question> questions);
    ArrayList<Question>  getQuestions();

}
