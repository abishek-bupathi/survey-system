import java.rmi.*;
import java.util.ArrayList;

public interface SurveyServer extends Remote {

    /*
     * Function Name    :   downloadQuestionnaireSummary
     * Parameters       :   None
     * Returns          :   Array list of questionnaire summaries
     * Description      :   Gets the summaries for available questionnaires
     */
    ArrayList<QuestionnaireSummary> downloadQuestionnaireSummary() throws RemoteException;

    /*
     * Function Name    :   downloadQuestionnaire
     * Parameters       :   questionnaire id (int)
     * Returns          :   Questionnaire object with the specified id
     * Description      :   Retrieve a questionnaire using it's id
     */
    Questionnaire downloadQuestionnaire(int questionnaireId) throws RemoteException;

    /*
     * Function Name    :   submitQuestionnaire
     * Parameters       :   Completed Questionnaire object
     * Returns          :   None
     * Description      :   Submit the completed questionnaire
     */
    void submitQuestionnaire(Questionnaire questionnaire) throws RemoteException;

}
