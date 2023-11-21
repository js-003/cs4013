import java.util.ArrayList;
import java.util.HashMap;

public class Course {
    private String courseName;
    private String courseCode;
    private int year;

    private ArrayList<String> course;

    public Course(String courseCode,String courseName, int year){
        course = new ArrayList<>();
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.year = year;
    }

    public void setCourseName(String newCourseName){
        this.courseName = newCourseName;
    }

    public String getCourseName(){
        return courseName;
    }

    public void addStudent(Student s){
        this.course.add(s.getId()+" "+s.getFirstName()+" "+s.getSurname());
    }

    public void removeStudent(Student s){
        this.course.remove(s.toString());
    }

    public String getStudent(Student s){
        String c = s.getId()+" "+s.getFirstName()+" "+s.getSurname();
        for(int i = 0; i<course.size();i++) {
            if(c.matches(this.course.get(i))){
                return this.course.get(i);
            }
        }
        return "No Student" + s.toString();
    }
    public String toString(){
        return course.toString();
    }
}
