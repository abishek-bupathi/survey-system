import java.rmi.*;
import java.util.ArrayList;

public class SurveyServerImpl implements SurveyServer{

    ArrayList<Question> questionSet1 = new ArrayList<>();
    ArrayList<Question> questionSet2 = new ArrayList<>();
    ArrayList<Question> questionSet3 = new ArrayList<>();

    Questionnaire questionnaire1, questionnaire2, questionnaire3;

    ArrayList<Questionnaire> questionnaires = new ArrayList<>();


    SurveyServerImpl() throws RemoteException{
        super();
    }

    public ArrayList<QuestionnaireSummary> downloadQuestionnaireSummary() throws RemoteException{

        ArrayList<QuestionnaireSummary> qs = new ArrayList<>();

        for(Questionnaire questionnaire:questionnaires){
            qs.add(new QuestionnaireSummaryImpl(questionnaire));
        }

        return qs;
    }

    public Questionnaire downloadQuestionnaire(int questionnaireId) throws  RemoteException{

        Questionnaire requestedQuestionnaire = null;

        for(Questionnaire questionnaire:questionnaires){
            if(questionnaire.getId() == questionnaireId){
                requestedQuestionnaire = questionnaire;
            }
        }

        return requestedQuestionnaire;
    }

    public void submitQuestionnaire(Questionnaire submittedQuestionnaire) throws  RemoteException{

        for(Questionnaire questionnaire:questionnaires){
            if(questionnaire.getId() == submittedQuestionnaire.getId()){
                questionnaire.setCompleted();
            }
        }
    }

    public void createQuestions(){

        questionSet1.add(new QuestionImpl("How are you?", new String[] {"1. Good", "2. Okay", "3. Neutral", "4. Bad"}));
        questionSet1.add(new QuestionImpl("How are you?", new String[] {"1. Good", "2. Okay", "3. Neutral", "4. Bad"}));
        questionSet1.add(new QuestionImpl("How are you?", new String[] {"1. Good", "2. Okay", "3. Neutral", "4. Bad"}));
        questionSet1.add(new QuestionImpl("How are you?", new String[] {"1. Good", "2. Okay", "3. Neutral", "4. Bad"}));
        questionSet1.add(new QuestionImpl("How are you?", new String[] {"1. Good", "2. Okay", "3. Neutral", "4. Bad"}));

        questionSet2.add(new QuestionImpl("How are you?", new String[] {"1. Good", "2. Okay", "3. Neutral", "4. Bad"}));
        questionSet2.add(new QuestionImpl("How are you?", new String[] {"1. Good", "2. Okay", "3. Neutral", "4. Bad"}));
        questionSet2.add(new QuestionImpl("How are you?", new String[] {"1. Good", "2. Okay", "3. Neutral", "4. Bad"}));
        questionSet2.add(new QuestionImpl("How are you?", new String[] {"1. Good", "2. Okay", "3. Neutral", "4. Bad"}));
        questionSet2.add(new QuestionImpl("How are you?", new String[] {"1. Good", "2. Okay", "3. Neutral", "4. Bad"}));

        questionSet3.add(new QuestionImpl("How are you?", new String[] {"1. Good", "2. Okay", "3. Neutral", "4. Bad"}));
        questionSet3.add(new QuestionImpl("How are you?", new String[] {"1. Good", "2. Okay", "3. Neutral", "4. Bad"}));
        questionSet3.add(new QuestionImpl("How are you?", new String[] {"1. Good", "2. Okay", "3. Neutral", "4. Bad"}));
        questionSet3.add(new QuestionImpl("How are you?", new String[] {"1. Good", "2. Okay", "3. Neutral", "4. Bad"}));
        questionSet3.add(new QuestionImpl("How are you?", new String[] {"1. Good", "2. Okay", "3. Neutral", "4. Bad"}));

    }

    public void createQuestionnaire(){

        questionnaire1 = new QuestionnaireImpl(121, "Personnel Questions");
        questionnaire1.setPurpose("To know about the client's mood");
        questionnaires.add(questionnaire1);

        questionnaire2 = new QuestionnaireImpl(121, "Personnel Questions");
        questionnaire2.setPurpose("To know about the client's mood");
        questionnaires.add(questionnaire2);

        questionnaire3 = new QuestionnaireImpl(121, "Personnel Questions");
        questionnaire3.setPurpose("To know about the client's mood");
        questionnaires.add(questionnaire3);

    }

    public static void main(String[] args){



    }
}

