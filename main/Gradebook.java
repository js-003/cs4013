import java.util.HashMap;

public class Gradebook {

    private HashMap<String, Grades> grades;

    public Gradebook(){
        grades  = new HashMap<>();
    }

    public void addTestResult(String studentID,Grades g){
        grades.put(studentID,g);
    }

    public String toString(){
        return grades.toString();
    }

    public void setGrade(String studentID,String testName ,double newResult){
        grades.put(studentID,new Grades(testName,newResult));
    }

}
