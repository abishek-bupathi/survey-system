import java.rmi.*;
import java.util.ArrayList;

public interface SurveyServer extends Remote{

    ArrayList<QuestionnaireSummary> downloadQuestionnaireSummary() throws RemoteException;

    Questionnaire downloadQuestionnaire(int questionnaireId) throws  RemoteException;

    void submitQuestionnaire(Questionnaire questionnaire) throws  RemoteException;

}
