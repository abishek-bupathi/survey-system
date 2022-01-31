public class QuestionnaireImpl implements Questionnaire{

    String name;
    int id;
    QuestionImpl[] questions;

    public QuestionnaireImpl(int id){

        name = "";
        this.id = id;
        this.questions = new QuestionImpl[]{};

    }

    public void setName(String name){
        this.name = name;
    }

}
