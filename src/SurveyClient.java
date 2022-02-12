import java.rmi.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SurveyClient {

    public static Scanner obj = new Scanner(System.in);

    public static void main(String[] args) {

        try {

            // Connecting to the SurverServer
            SurveyServer surveyServer = (SurveyServer) Naming.lookup("//localhost/Survey");
            int action_choice;

            System.out.println("------------------------");
            System.out.println("Welcome to Survey System");
            System.out.println("------------------------");

            while(true){

                System.out.println("Select Action:");
                System.out.println("1. View available questionnaire summaries");
                System.out.println("2. Answer and Submit Questionnaire");
                System.out.println("3. Exit");
                System.out.print("Enter your choice (1 - 3): ");
                action_choice = obj.nextInt();

                // Checking is get_summaries is passed as the 1st argument in the command line
                if (action_choice == 1) {
                    System.out.println("-------------------------------------");
                    System.out.println("Questionnaire summaries");

                    // Requesting the summaries from SurveyServer
                    ArrayList<QuestionnaireSummary> summaries = surveyServer.downloadQuestionnaireSummary();
                    for (QuestionnaireSummary summary : summaries) {
                        System.out.println("---");
                        System.out.println(summary.getSummary());
                    }

                    System.out.println("-------------------------------------");
                } else if (action_choice == 2) {

                    // Getting the list of summaries to know about the available questionnaires on the server
                    ArrayList<QuestionnaireSummary> summaries = surveyServer.downloadQuestionnaireSummary();
                    int requested_qn_id;

                    boolean questionnaire_present = false;

                    System.out.print("Enter questionnaire id: ");
                    requested_qn_id = obj.nextInt();

                    // Loop through the available summaries
                    for (QuestionnaireSummary summary : summaries) {

                        // Checking if the questionnaire is present
                        if (summary.getId() == requested_qn_id) {
                            questionnaire_present = true;
                        }
                    }

                    if (questionnaire_present) {

                        // If questionnaire is present then the questionnaire object is retrieved from the server
                        Questionnaire questionnaire = surveyServer.downloadQuestionnaire(requested_qn_id);

                        char submit;

                        System.out.println("-------------------------------------");
                        System.out.println("Questionnaire ID: " + questionnaire.getId());
                        System.out.println("Questionnaire Name: " + questionnaire.getName());
                        System.out.println("Questionnaire Purpose: " + questionnaire.getPurpose());
                        System.out.println("-------------------------------------");

                        // Getting the questions from the questionnaire
                        ArrayList<Question> questions = questionnaire.getQuestions();

                        // Looping through each question
                        for (Question question : questions) {

                            int selected_option;

                            System.out.println(question.getQuestion());
                            String[] options = question.getAnsOptions();

                            // Looping through each mcq choice for the question
                            for (String option : options) {
                                System.out.println(option);
                            }

                            System.out.println("Enter your choice (1-4): ");

                            while (true) {
                                // Getting input from user and selecting the answer accordingly
                                selected_option = obj.nextInt();
                                // Trying to select answer and checking if the input choice is valid for the question
                                if (question.selectAnswer(selected_option) == 1) {
                                    break;
                                } else {
                                    System.out.println("Invalid input, please enter value between 1 and 4:");
                                }
                            }

                        }

                        // Asking user to complete submission
                        System.out.println("Submit (Y/N) ?");
                        submit = obj.next().charAt(0);

                        if (submit == 'y') {
                            // Submitting the questionnaire to the server
                            surveyServer.submitQuestionnaire(questionnaire);
                            System.out.println("Questionnaire successfully submitted to the server!\nReturning to main menu...\n");
                            System.out.println("-------------------------------------");
                        } else {
                            System.out.println("Questionnaire not submitted!\nReturning to main menu...\n");
                            System.out.println("-------------------------------------");
                        }

                    } else {
                        // Error message is printed when questionnaire with the requested id is not present
                        System.out.println("\nRequested Questionnaire ID is invalid\n");
                        System.out.println("-------------------------------------");
                    }
                } else if(action_choice == 3){
                    System.out.println("Exiting...");
                    break;
                } else {
                    System.out.println("\nInvalid choice! please select between 1 - 3\n");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


