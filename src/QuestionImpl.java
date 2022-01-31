public class QuestionImpl implements Question{

    String question;
    String[][] answers = {{"n", ""}, {"n", ""}, {"n", ""}, {"n", ""}};

    public QuestionImpl(String question, String[] answers){
        this.question = question;
        System.arraycopy(answers, 0, this.answers[1], 0, 4);
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public void setAnswers(String[] answers){
        System.arraycopy(answers, 0, this.answers[1], 0, 4);
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
