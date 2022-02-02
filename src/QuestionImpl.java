public class QuestionImpl implements Question{

    String question;
    String[][] answers = {{"n", ""}, {"n", ""}, {"n", ""}, {"n", ""}};

    public QuestionImpl(String question, String[] answers){
        this.question = question;
        for(int i = 0; i < 4; i++) {
            this.answers[i][1] = answers[i];
        }
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public void setAnswers(String[] answers){
        for(int i = 0; i < 4; i++) {
            this.answers[i][1] = answers[i];
        }
    }

    public String[] getAnsOptions() {
        String[] options = new String[4];
        for(int i = 0; i < 4; i++){
            options[i] = answers[i][1];
        }
        return options;
    }

    public void selectAnswer(int option){
        answers[0][option - 1] = "y";
    }

    public String getQuestion(){
        return question;
    }

    public String getSelectedAnswer(){
        String selectedAns = "None";

        for(int i = 0; i < 4; i++){
            if(answers[0][i].compareTo("y") > 0){
                selectedAns = answers[1][i];
            }
        }

        return selectedAns;
    }

}
