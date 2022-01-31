public class QuestionnaireImpl implements Questionnaire{

    String name;
    String purpose;
    int id;
    QuestionImpl[] questions;

    public QuestionnaireImpl(int id, String name){

        this.name = name;
        purpose = "";
        this.id = id;
        this.questions = new QuestionImpl[]{};

    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void addQuestions(QuestionImpl[] questions){
        this.questions = questions;
    }

    public Question[] getQuestions(){
        return questions;
    }

}
