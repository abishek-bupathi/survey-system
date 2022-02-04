import java.rmi.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SurveyClient {

    public static Scanner obj = new Scanner(System.in);

    public static void main (String args[])
    {

        try {

            SurveyServer surveyServer = (SurveyServer) Naming.lookup("//localhost/Survey");

            //System.out.println(args[0] + " " + args[1]);
            if(args[0].compareTo("get_summaries") == 0){
                ArrayList<QuestionnaireSummary> summaries = surveyServer.downloadQuestionnaireSummary();
                for(QuestionnaireSummary summary : summaries){
                    System.out.println("---");
                    System.out.println(summary.getSummary());
                }
            }
            else if(args[0].compareTo("get_questionnaire") == 0){

                Questionnaire questionnaire = surveyServer.downloadQuestionnaire(Integer.parseInt(args[1]));
                char submit;

                ArrayList<Question> questions = questionnaire.getQuestions();

                for(Question question: questions){

                    int selected_option;

                    System.out.println(question.getQuestion());
                    String[] options = question.getAnsOptions();
                    for(String option: options){
                        System.out.println(option);
                    }

                    System.out.println("Enter your choice (1-4): ");

                    while(true) {
                        selected_option = obj.nextInt();
                        if (question.selectAnswer(selected_option) == 1){
                            break;
                        }else
                        {
                            System.out.println("Invalid input, please enter value between 1 and 4:");
                        }
                    }

                }

                System.out.println("Submit (Y/N) ?");
                submit = obj.next().charAt(0);

                if(submit == 'y'){
                    surveyServer.submitQuestionnaire(questionnaire);
                }else{
                    System.out.println("Questionnaire not submitted!\nExiting...");
                }
            }
        }
        catch (Exception e) {
            System.out.print(e);
        }
    }
}


