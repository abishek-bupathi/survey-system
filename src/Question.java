import java.io.Serializable;

public interface Question extends Serializable {

    /*
     * Function Name    :   setQuestion
     * Parameters       :   Question string - question(String)
     * Returns          :   None
     * Description      :   sets the question field with the provided question string
     */
    void setQuestion(String question);

    /*
     * Function Name    :   setAnswers
     * Parameters       :   Answers String Array - answers(String)
     * Returns          :   None
     * Description      :   sets the mcq answers for the question
     */
    void setAnswers(String[] answers);

    /*
     * Function Name    :   getAnsOptions
     * Parameters       :   None
     * Returns          :   String array of available answers
     * Description      :   Returns answer options for the question
     */
    String[] getAnsOptions();

    /*
     * Function Name    :   selectAnswer
     * Parameters       :   answer index value - option(int)
     * Returns          :   result of answer selection process (int)
     * Description      :   sets the question field with the provided question string
     */
    int selectAnswer(int option);

    /*
     * Function Name    :   getQuestion
     * Parameters       :   None
     * Returns          :   String value of question
     * Description      :   Get the question string
     */
    String getQuestion();

    /*
     * Function Name    :   getSelectedAnswer
     * Parameters       :   None
     * Returns          :   Selected Answer
     * Description      :   Get the selected answer for the question
     */
    String getSelectedAnswer();

}
