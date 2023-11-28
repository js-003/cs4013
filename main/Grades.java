import java.util.HashMap;

public class Grades {
    private static int[] percentage = {-1,0,30,35,40,48,52,56,60,64,72,80};
    private String[] gradeText = {"NG","F","D2","D1","C3","C2","C1","B3","B2","B1","A2","A1"};
    private HashMap<String, String> results = new HashMap<>();

    public Grades(String testName,double result){
        results.put(testName,gradeConvert(result));
    }

    public String gradeConvert(double result){
        if(result>-1){
            for(int i = percentage.length-1; i>-1;i--) {
                if (result >= percentage[i]) {
                    return gradeText[i];
                }
            }
        }
        return "Cannot Have A Negative Percentage";
    }

    public String giveIGrade(){
        return "I (Repeat Exam)";
    }

    public String toString(){
        return results.toString();
    }
}


