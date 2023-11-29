

//btw I was meant to send this discord as something that could potentially function and trying to get rid of it
import java.util.HashMap;
import java.util.ArrayList;
public class Grades {
    private static int[] percentage = {0,30,35,40,48,52,56,60,64,72,80};
    private String[] gradeText = {"F","D2","D1","C3","C2","C1","B3","B2","B1","A2","A1"};

    private HashMap<String, ArrayList<Object>> results = new HashMap<>();
    private double[] gcaScore = {0.00, 1.20, 1.60, 2.00, 2.40, 2.60, 2.80, 3.00, 3.20, 3.60, 4.00};

    public Grades(String testName,double result){
        ArrayList<Object> info = new ArrayList<>();
        info.add(gradeConvert(result));
        info.add(scoreConvert(result));
        results.put(testName, info);
    }

    public String gradeConvert(double result){
        for(int i = percentage.length-1; i>-1;i--){
            if(result>=percentage[i]){
                return gradeText[i];
            }
        }
        return "NG";
    }

    public double scoreConvert(double result){
        for(int i = percentage.length-1; i>-1;i--){
            if(result>=percentage[i]){
                return gcaScore[i];
            }
        }
        return 0.00;
    }

    public String giveIGrade(){
        return "I (Repeat Exam)";
    }

    public String toString(){
        return results.toString();
    }
}
