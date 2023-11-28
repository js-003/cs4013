import java.util.HashMap;

public class Grades {
    private static int[] percentage = {0,1,30,35,40,48,52,56,60,64,72,80};
    private String[] gradeText = {"NG","F","D2","D2","C3","C2","C1","B3","B2","B1","A2","A1"};
    private HashMap<String, String> results = new HashMap<>();

    public Grades(String testName,double result){
        results.put(testName,gradeConvert(result));
    }

    public String gradeConvert(double result){
        for(int i = percentage.length-1; i>-1;i--){
            if(result>=80){
                return gradeText[10];
            }
            if(result>=percentage[i]){
                return gradeText[i-1];
            }
        }
        return "Inccorrect Grade";
    }

    public String toString(){
        return results.toString();
    }
}
