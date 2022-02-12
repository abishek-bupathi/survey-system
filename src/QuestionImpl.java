public class QuestionImpl implements Question {

    String question;
    // Array to store mcq choices, and it's status (selected or not selected)
    String[][] answers = {{"n", ""}, {"n", ""}, {"n", ""}, {"n", ""}};

    public QuestionImpl(String question, String[] answers) {
        this.question = question;
        for (int i = 0; i < 4; i++) {
            this.answers[i][1] = answers[i];
        }
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswers(String[] answers) {
        for (int i = 0; i < 4; i++) {
            this.answers[i][1] = answers[i];
        }
    }

    public String[] getAnsOptions() {
        String[] options = new String[4];
        for (int i = 0; i < 4; i++) {
            options[i] = answers[i][1];
        }
        return options;
    }

    // Sets the selected answer as 'y' in the status index
    // and returns 1 if successful or else 0
    public int selectAnswer(int option) {
        if (option < 5) {
            answers[option - 1][0] = "y";
            return 1;
        } else {
            return 0;
        }
    }

    public String getQuestion() {
        return question;
    }

    // Check the answer array and return answer string
    public String getSelectedAnswer() {
        String selectedAns = "None";

        for (int i = 0; i < 4; i++) {
            // Check if the answer is selected
            if (answers[i][0].compareTo("y") > 0) {
                selectedAns = answers[i][1];
                break;
            }
        }

        return selectedAns;
    }

}
