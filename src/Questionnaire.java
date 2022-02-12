import java.io.Serializable;
import java.util.ArrayList;

public interface Questionnaire extends Serializable {

    /*
     * Function Name    :   setName
     * Parameters       :   Name of the questionnaire - name(String)
     * Returns          :   None
     * Description      :   Sets the name of the questionnaire
     */
    void setName(String name);

    /*
     * Function Name    :   setId
     * Parameters       :   id of the questionnaire - id(int)
     * Returns          :   None
     * Description      :   Sets the id of the questionnaire
     */
    void setId(int id);

    /*
     * Function Name    :   setPurpose
     * Parameters       :   purpose of the questionnaire - purpose(String)
     * Returns          :   None
     * Description      :   Sets the purpose for the questionnaire
     */
    void setPurpose(String purpose);

    /*
     * Function Name    :   setCompleted
     * Parameters       :   None
     * Returns          :   None Answer
     * Description      :   Sets the questionnaire status as completed
     */
    void setCompleted();

    /*
     * Function Name    :   getId
     * Parameters       :   None
     * Returns          :   id (int)
     * Description      :   Get the questionnaire id
     */
    int getId();

    /*
     * Function Name    :   getName
     * Parameters       :   None
     * Returns          :   Mame (String)
     * Description      :   Get the questionnaire name
     */
    String getName();

    /*
     * Function Name    :   getPurpose
     * Parameters       :   None
     * Returns          :   Purpose (String)
     * Description      :   Get the questionnaire purpose
     */
    String getPurpose();

    /*
     * Function Name    :   getNoOfCompletedInstances
     * Parameters       :   None
     * Returns          :   number of completed instances(int)
     * Description      :   Get the number of times this questionnaire has been completed
     */
    int getNoOfCompletedInstances();

    /*
     * Function Name    :   addQuestions
     * Parameters       :   Questions(ArrayList<Question>)
     * Returns          :   None
     * Description      :   Add question objects to the questionnaire
     */
    void addQuestions(ArrayList<Question> questions);

    /*
     * Function Name    :   getQuestions
     * Parameters       :   None
     * Returns          :   Question objects List (ArrayList<Question>)
     * Description      :   Get the Questions present in the questionnaire
     */
    ArrayList<Question> getQuestions();

}
