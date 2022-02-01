public class QuestionnaireImpl implements Questionnaire{

    String name;
    String purpose;
    int id;
    int completedInstances;
    Question[] questions;

    public QuestionnaireImpl(int id, String name){

        this.name = name;
        purpose = "";
        this.id = id;
        this.questions = new Question[]{};
        this.completedInstances = 0;

    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setPurpose(String purpose){
        this.purpose = purpose;
    }

    public void setCompleted() {
        completedInstances += 1;
    }


    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getPurpose(){
        return purpose;
    }

    public int getNoOfCompletedInstances() {
        return completedInstances;
    }

    public void addQuestions(Question[] questions){
        this.questions = questions;
    }

    public Question[] getQuestions(){
        return questions;
    }

}
