import java.util.ArrayList;

public class QuestionnaireImpl implements Questionnaire {

    String name;
    String purpose;
    int id;
    int completedInstances;
    ArrayList<Question> questions;

    public QuestionnaireImpl(int id, String name) {

        this.name = name;
        purpose = "";
        this.id = id;
        this.questions = new ArrayList<>();
        this.completedInstances = 0;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    // Each time the questionnaire is submitted, the value of completedInstances will increment by 1
    public void setCompleted() {
        completedInstances += 1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPurpose() {
        return purpose;
    }

    public int getNoOfCompletedInstances() {
        return completedInstances;
    }

    public void addQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

}
