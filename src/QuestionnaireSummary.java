import java.io.*;

public interface QuestionnaireSummary extends Serializable {

    /*
     * Function Name    :   getId
     * Parameters       :   None
     * Returns          :   id of the questionnaire (int)
     * Description      :   Get the id value present in the summary
     */
    int getId();

    /*
     * Function Name    :   getSummary
     * Parameters       :   None
     * Returns          :   Summary details containing questionnaire id, name, purpose
     *                      and number of completed instances (String)
     * Description      :   Get the summary of questionnaire
     */
    String getSummary();

}
