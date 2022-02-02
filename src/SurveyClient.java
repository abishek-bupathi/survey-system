import java.rmi.*;
import java.util.ArrayList;

public class SurveyClient {

    public static void main (String args[])
    {
        try {
            SurveyServer surveyServer = (SurveyServer) Naming.lookup("//localhost/Survey");

            System.out.println(args[0] + " " + args[1]);
            if(args[0].compareTo("get_summaries") == 0){
                ArrayList<QuestionnaireSummary> summaries = surveyServer.downloadQuestionnaireSummary();
                for(QuestionnaireSummary summary : summaries){
                    System.out.println("---");
                    System.out.println(summary.getSummary());
                }
            }
            else if(args[0].compareTo("get_questionnaire") == 0){

                Questionnaire questionnaire = surveyServer.downloadQuestionnaire(Integer.parseInt(args[1]));
                ArrayList<Question>  questions = questionnaire.getQuestions();

                for(Question question: questions){
                    System.out.println(question.getQuestion());
                    String[] options = question.getAnsOptions();
                    for(String option: options){
                        System.out.println(option);
                    }

                }
            }


            //Questionnaire questionnaire = surveyServer.downloadQuestionnaire(121);

            //System.out.println(surveyServer.downloadQuestionnaire(121));
        }
        catch (Exception e) {
            System.out.print(e);
        }
    }
}


