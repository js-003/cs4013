import main.Student;

import java.util.ArrayList;

public class Course {
    private String graduateLevel;
    private String degree;
    private String courseName;
    private final String courseCode;

    private final int yearOfStudy;

    private ArrayList<String> course;

    public Course(String courseCode, String courseName, int yearOfStudy){
        course = new ArrayList<>();
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.yearOfStudy = yearOfStudy;
    }

    public void setCourseName(String newCourseName){
        this.courseName = newCourseName;
    }

    public String getCourseName(){
        return courseName;
    }

    public void addStudent(Student s){
        this.course.add(s.getId()+" "+s.getFirstName()+" "+s.getLastName());
    }

    public void removeStudent(Student s){
        this.course.remove(s.toString());
    }

    public String getStudent(Student s){
        String c = s.getId()+" "+s.getFirstName()+" "+s.getLastName();
        for (String string : course) {
            if (c.matches(string)) {
                return string;
            }
        }
        return "No Student " + s.toString();
    }

    public void graduateLevel(String level){
        this.degree = level;
        if(level.toLowerCase().contains("bachelor")){
            this.graduateLevel = "Undergraduate";
        }else if(level.toLowerCase().contains("masters")){
            this.graduateLevel = "Masters";
        }else this.graduateLevel = "Postgraduate";
    }
    public String toString(){
        return course.toString();
    }

    public String getDegree() {
        return degree;
    }

    public String getGraduateLevel() {
        return graduateLevel;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }
}
