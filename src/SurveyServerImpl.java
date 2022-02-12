import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.ArrayList;

public class SurveyServerImpl implements SurveyServer {

    // Array List to store question sets
    static ArrayList<Question> questionSet1 = new ArrayList<>();
    static ArrayList<Question> questionSet2 = new ArrayList<>();
    static ArrayList<Question> questionSet3 = new ArrayList<>();

    // Questionnaire objects
    static Questionnaire questionnaire1, questionnaire2, questionnaire3;

    // Arraylist to store all the available questionnaires for easy access
    static ArrayList<Questionnaire> questionnaires = new ArrayList<>();


    SurveyServerImpl() throws RemoteException {
        super();
    }

    // Creates and returns an arraylist of summaries for all the questionnaire
    public ArrayList<QuestionnaireSummary> downloadQuestionnaireSummary() throws RemoteException {

        ArrayList<QuestionnaireSummary> qs = new ArrayList<>();

        for (Questionnaire questionnaire : questionnaires) {
            qs.add(new QuestionnaireSummaryImpl(questionnaire));
        }

        return qs;
    }

    // Check the provided id with id's of all questionnaire and returns the questionnaire one that match
    public Questionnaire downloadQuestionnaire(int questionnaireId) throws RemoteException {

        Questionnaire requestedQuestionnaire = null;

        for (Questionnaire questionnaire : questionnaires) {
            if (questionnaire.getId() == questionnaireId) {
                requestedQuestionnaire = questionnaire;
            }
        }

        return requestedQuestionnaire;
    }

    // Sets the submitted questionnaire status as completed
    public void submitQuestionnaire(Questionnaire submittedQuestionnaire) throws RemoteException {

        for (Questionnaire questionnaire : questionnaires) {
            if (questionnaire.getId() == submittedQuestionnaire.getId()) {
                questionnaire.setCompleted();
            }
        }
    }

    /*
     * Function Name    :   createQuestions
     * Parameters       :   None
     * Returns          :   None
     * Description      :   Populates the question objects with questions and mcq choices
     */
    public static void createQuestions() {

        questionSet1.add(new QuestionImpl("Did the product meet all your needs?", new String[]{"1. Met all my needs", "2. Most of my needs ", "3. Few of my needs", "4. Didn't meet any of my need"}));
        questionSet1.add(new QuestionImpl("How do you rate the product?", new String[]{"1. Excellent", "2. Good", "3. Bad", "4. Worst"}));
        questionSet1.add(new QuestionImpl("How often do you use the product?", new String[]{"1. Frequently", "2. Occasionally", "3. Rarely", "4. Never"}));
        questionSet1.add(new QuestionImpl("Will you recommend the product to others?", new String[]{"1. Strongly recommend", "2. Yes, will recommend", "3. May recommend", "4. No"}));
        questionSet1.add(new QuestionImpl("Did you find the product satisfactory", new String[]{"1. Yes, very much", "2. Yes, Somewhat", "3. Neutral", "4. No"}));

        questionSet2.add(new QuestionImpl("Do you wake up before 8am?", new String[]{"1. Regularly", "2. Mostly", "3. Occasionally", "4. Never"}));
        questionSet2.add(new QuestionImpl("Do you participate in physical activities?", new String[]{"1. Regularly", "2. Mostly", "3. Occasionally", "4. Never"}));
        questionSet2.add(new QuestionImpl("Do you eat fast foods?", new String[]{"1. Regularly", "2. Mostly", "3. Occasionally", "4. Never"}));
        questionSet2.add(new QuestionImpl("Do you feel tired at the end of the day?", new String[]{"1. Regularly", "2. Mostly", "3. Occasionally", "4. Never"}));
        questionSet2.add(new QuestionImpl("How healthy do you consider yourself?", new String[]{"1. Fit", "2. Neutral", "3. Overweight", "4. Obese"}));

        questionSet3.add(new QuestionImpl("How would you rate the service?", new String[]{"1. Very Satisfied", "2. Satisfied", "3. Neutral", "4. Dissatisfied"}));
        questionSet3.add(new QuestionImpl("Would you view this service as", new String[]{"1. Budget", "2. Midscale", "3. Upscale", "4. Luxury"}));
        questionSet3.add(new QuestionImpl("Interaction with staffs", new String[]{"1. Very Satisfied", "2. Satisfied", "3. Neutral", "4. Dissatisfied"}));
        questionSet3.add(new QuestionImpl("How likely are you to get the service again?", new String[]{"1. Most likely", "2. Likely", "3. Maybe", "4. Never"}));
        questionSet3.add(new QuestionImpl("Will you recommed this service to tohers", new String[]{"1. Strongly recommend", "2. Yes, will recommend", "3. May recommend", "4. No"}));

    }

    /*
     * Function Name    :   createQuestionnaire
     * Parameters       :   None
     * Returns          :   None
     * Description      :   Populates the questionnaire objects with questions and details
     */
    public static void createQuestionnaire() {

        questionnaire1 = new QuestionnaireImpl(121, "Product Feedback");
        questionnaire1.setPurpose("To know about the user's satisfaction and opinion on the product");
        questionnaire1.addQuestions(questionSet1);
        questionnaires.add(questionnaire1);

        questionnaire2 = new QuestionnaireImpl(122, "Habit Research");
        questionnaire2.setPurpose("Gather habit details of individuals to find patterns and dependencies");
        questionnaire2.addQuestions(questionSet2);
        questionnaires.add(questionnaire2);

        questionnaire3 = new QuestionnaireImpl(123, "Service Feedback");
        questionnaire3.setPurpose("Get customer's service Experience");
        questionnaire3.addQuestions(questionSet3);
        questionnaires.add(questionnaire3);

    }

    public static void main(String[] args) {

        // Creating questions and questionnaire
        createQuestions();
        createQuestionnaire();

        try {
            // First reset our Security manager
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
                System.out.println("Security manager set");
            }

            // Creating new Survey Server Instance
            SurveyServer surveyServer = new SurveyServerImpl();
            System.out.println("Instance of Survey Server created");
            SurveyServer stub = (SurveyServer) UnicastRemoteObject.exportObject(surveyServer, 0);

            // Put the server object into the Registry
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Survey", stub);
            System.out.println("Name rebind completed");
            System.out.println("Server ready for requests!");
        } catch (Exception exc) {
            System.out.println("Error in main - " + exc);
        }

    }
}

