import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.ArrayList;

public class SurveyServerImpl implements SurveyServer{

    static ArrayList<Question> questionSet1 = new ArrayList<>();
    static ArrayList<Question> questionSet2 = new ArrayList<>();
    static ArrayList<Question> questionSet3 = new ArrayList<>();

    static Questionnaire questionnaire1, questionnaire2, questionnaire3;

    static ArrayList<Questionnaire> questionnaires = new ArrayList<>();


    SurveyServerImpl() throws RemoteException{
        super();
    }

    public String test() throws RemoteException{
        return "Testing";
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

    public static void createQuestions(){

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

    public static void createQuestionnaire() {

        questionnaire1 = new QuestionnaireImpl(121, "Personnel Questions");
        questionnaire1.setPurpose("To know about the client's mood");
        questionnaire1.addQuestions(questionSet1);
        questionnaires.add(questionnaire1);

        questionnaire2 = new QuestionnaireImpl(122, "Personnel Questions");
        questionnaire2.setPurpose("To know about the client's mood");
        questionnaires.add(questionnaire2);

        questionnaire3 = new QuestionnaireImpl(123, "Personnel Questions");
        questionnaire3.setPurpose("To know about the client's mood");
        questionnaires.add(questionnaire3);

    }

    public static void main(String[] args){

        createQuestions();
        createQuestionnaire();

        try {
            // First reset our Security manager
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
                System.out.println("Security manager set");
            }

            SurveyServer surveyServer = new SurveyServerImpl();
            System.out.println("Instance of Survey Server created");
            SurveyServer stub = (SurveyServer) UnicastRemoteObject.exportObject(surveyServer, 0);

            // Put the server object into the Registry
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Survey", stub);
            System.out.println("Name rebind completed");
            System.out.println("Server ready for requests!");
        }
        catch(Exception exc) {
            System.out.println("Error in main - " + exc.toString());
        }

    }
}

