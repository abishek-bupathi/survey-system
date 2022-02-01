public interface Questionnaire {

    void setName(String name);
    void setId(int id);
    void setPurpose(String purpose);
    void setCompleted();
    int getId();
    String getName();
    String getPurpose();
    int getNoOfCompletedInstances();
    void addQuestions(Question[] questions);
    Question[] getQuestions();

}
