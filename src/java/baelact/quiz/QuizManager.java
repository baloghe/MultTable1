package baelact.quiz;

import java.util.ArrayList;
import java.util.Random;

public class QuizManager {
    private final int qzNum;
    private final int qzRng;
    
    private int goodAns;
    private ArrayList<QuizAnswer> badList;
    
    public QuizManager(int qNum, int rng){
        qzNum = qNum;
        qzRng = rng;
        goodAns = 0;
        badList = new ArrayList<>();
    }
    
    public int getQuizNumber(){return qzNum;}
    public int getQuizRange(){return qzRng;}
    
    public int[] getQuiz(){
        Random rand = new Random();
        int[] ret = new int[3];
        ret[0] = rand.nextInt(qzRng+1);
        ret[1] = rand.nextInt(qzRng+1);
        return ret;
    }
    
    public int getGoodAns(){return goodAns;}
    
    public void evaluateAnswer(int[] question, int answer){
        int expResult = question[0] * question[1];
        if(answer == expResult){
            goodAns++;
        } else {
            badList.add(new QuizAnswer(
                    Integer.toString(question[0])+" * "+Integer.toString(question[1])
                    , Integer.toString(expResult), Integer.toString(answer) ));
        }
    }
    
    public ArrayList<QuizAnswer> getBadList(){return badList;}
}