import java.util.ArrayList;

public class Course {
    private String graduateLevel;
    private String degree;
    private String courseName;
    private final String courseCode;
    private String Level;

    private final int yearOfStudy;

    private ArrayList<Student> studentList;

    private ArrayList<String> moduleList;

    private ArrayList<Semester> semester;

    public Course(String courseCode, String courseName, int yearOfStudy){
        studentList = new ArrayList<>();
        moduleList = new ArrayList<>();
        semester = new ArrayList<>();
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
        this.studentList.add(s);
    }

    public void removeStudent(Student s){
        this.studentList.remove(s);
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

    public void graduateLevel(String level){
        this.degree = level;
        if(level.toLowerCase().contains("bachelor")){
            this.graduateLevel = "Undergraduate";
        }else if(level.toLowerCase().contains("masters")){
            this.graduateLevel = "Masters";
        }else this.graduateLevel = "Postgraduate";
    }

    public String getStudentList(){
        return studentList.toString();
    }

    public String getModuleList(){
        return moduleList.toString();
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

    public void addModule(Module m){
        moduleList.add(m.getModuleName());
    }

    public void addSemester(Semester s){
        semester.add(s);
    }

    public String getSemesters(){
        return semester.toString();
    }

    public String toString(){
        return String.format("Course Name: %s\nCourse Code: %s\nSemester: %s\nModule List: %s\nStudent List: %s",getCourseName(),getCourseCode(),getSemesters(),getModuleList(),getStudentList());
    }
}
