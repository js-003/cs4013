import java.util.HashMap;

public class Grades {
    String[] gradeText = {"F","D2","D2","C3","C2","C1","B3","B2","B1","A2","A1"};
    private HashMap<String, String> results = new HashMap<>();


    public Grades(String testName,double result){
        results.put(testName,gradeConvert(result));
    }

    public String gradeConvert(double result){
        int getGrade = (int) (result%10);
        if(getGrade>81){
            return gradeText[8];
        }
        return gradeText[getGrade];
    }

    public String toString(){
        return results.toString();
    }
}
