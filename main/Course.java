import java.util.ArrayList;

public class Course {
    private String type;
    private String degree;
    private String courseName;

    private final String courseCode;
    private String graduateLevel;

    private final int duration;

    private ArrayList<Student> studentList;

    private ArrayList<String> moduleList;


    public Course(String courseCode, String courseName, String degree, String type, int duration){

        studentList = new ArrayList<>();
        moduleList = new ArrayList<>();


        this.courseCode = courseCode;
        this.courseName = courseName;
        this.degree = degree;
        this.type = type;
        this.duration = duration;
        getGraduateLevel();
    }

    public String getCourseName(){
        return courseName;
    }

    public String getStudent(Student s){
        String c = s.getId()+" "+s.getFirstName()+" "+s.getLastName();
        for (Student string : studentList) {
            if (c.matches(string.toString())) {
                return string.toString();
            }
        }
        return "No Student " + s.toString();
    }

    private void getGraduateLevel(){
        if(type.toLowerCase().contains("bachelor")){
            this.graduateLevel = "Undergraduate";
        }else if(type.toLowerCase().contains("masters")){
            this.graduateLevel = "Masters";
        }else this.graduateLevel = "Postgraduate";
    }

    public String getStudentList(){
        return studentList.toString();
    }

    public String getModuleList(){
        return moduleList.toString();
    }

    public String getCourseCode() {
        return courseCode;
    }



    //below use in another db
    public String getDetails(){
        return String.format("Course Name: %s\nCourse Code: %s\nModule List: %s\nStudent List: %s",getCourseName(),getCourseCode(),getModuleList(),getStudentList());
    }

    public String toString(){
        return String.format("%s,%s,%s,%s,%s,%d", courseCode, courseName,degree, type,graduateLevel, duration);
    }
}
