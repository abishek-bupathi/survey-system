import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class SurveyServerImpl implements SurveyServer{

    SurveyServerImpl() throws RemoteException{
        super();
    }

    public QuestionnaireSummary downloadQuestionnaireSummary() throws RemoteException{

        QuestionnaireSummary qs = new QuestionnaireSummaryImpl();

        return qs;
    }

    public Questionnaire downloadQuestionnaire(int questionnaireId) throws  RemoteException{

        Questionnaire questionnaire = new QuestionnaireImpl(questionnaireId, "Test");

        return questionnaire;
    }

    public void submitQuestionnaire(Questionnaire questionnaire) throws  RemoteException{

    }

    public static void main(String[] args){



    }
}

