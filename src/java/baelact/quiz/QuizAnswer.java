package baelact.quiz;

public class QuizAnswer {
    private String question;
    private String expectedResult;
    private String answer;
    
    public QuizAnswer(String qs, String er, String an){
        question = qs;
        expectedResult = er;
        answer = an;
    }
    
    public String getQuestion(){return question;}
    public String getExpectedResult(){return expectedResult;}    
    public String getAnswer(){return answer;}
}
