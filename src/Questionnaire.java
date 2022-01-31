public interface Questionnaire {

    void setName(String name);
    void setId(int id);
    int getId();
    String getName();
    void addQuestions(QuestionImpl[] questions);
    Question[] getQuestions();

}
