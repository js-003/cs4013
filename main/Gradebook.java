import java.util.HashMap;

public class Gradebook {

    private final HashMap<String, Grades> grades;

    public Gradebook(){
        grades  = new HashMap<>();
    }

    public void addTestResult(String studentID,Grades g){
        grades.put(studentID,g);
    }

    public void getTestResult(String testName){

    }

    public String toString(){
        return grades.toString();
    }


}
