public class QuestionnaireSummaryImpl implements QuestionnaireSummary{

    String summary;
    Questionnaire questionnaire;

    QuestionnaireSummaryImpl(Questionnaire questionnaire){
        this.summary = "";
        this.questionnaire = questionnaire;
    }

    public String getSummary(){

        summary += "ID: " + questionnaire.getId() + "\n";
        summary += "Name: " + questionnaire.getName() + "\n";
        summary += "Purpose: " + questionnaire.getPurpose() + "\n";
        summary += "No. of completed Instances: " + questionnaire.getNoOfCompletedInstances();

        return summary;

    }
}
