import java.util.ArrayList;

public class Course {
    private String graduateLevel;
    private String degree;
    private String courseName;
    private final String courseCode;
    private String Level;

    private final int duration;

    private ArrayList<Student> studentList;

    private ArrayList<String> moduleList;

    private ArrayList<Semester> semester;

    /**
     * Creates a course object by passing the parameters below
     *
     * @param courseCode The code of a course
     * @param courseName The name of a course
     * @param duration The duration of a course
     */

    public Course(String courseCode, String courseName, int duration){
        studentList = new ArrayList<>();
        moduleList = new ArrayList<>();
        semester = new ArrayList<>();
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.duration = duration;
    }

    /**
     * Changes the name of a course already created
     *
     * @param newCourseName The new name for a course
     */

    public void setCourseName(String newCourseName){
        this.courseName = newCourseName;
    }

    /**
     * Returns the name of a course already created
     *
     * @return
     */
    public String getCourseName(){
        return courseName;
    }

    /**
     * Adds a student object to a course already created
     *
     * @param s The student object getting added to a course
     */
    public void addStudent(Student s){
        this.studentList.add(s);
    }

    /**
     * Removes a student object from a course already created
     *
     * @param s The student object getting removed from a course
     */
    public void removeStudent(Student s){
        this.studentList.remove(s);
    }

    /**
     * Returns a student object to a string if such student exists in a course
     *
     * @param s The student object getting searched
     * @return The details of a student in string format if the student is found
     */
    public String getStudent(Student s){
        String c = s.getId()+" "+s.getFirstName()+" "+s.getLastName();
        for (Student string : studentList) {
            if (c.matches(string.toString())) {
                return string.toString();
            }
        }
        return "No Student " + s.toString();
    }

    /**
     * Gives a course a graduate level
     *
     * @param level The level of the course
     */

    public void graduateLevel(String level){
        this.degree = level;
        if(level.toLowerCase().contains("bachelor")){
            this.graduateLevel = "Undergraduate";
        }else if(level.toLowerCase().contains("masters")){
            this.graduateLevel = "Masters";
        }else this.graduateLevel = "Postgraduate";
    }

    /**
     * Returns a list of students in a course
     *
     * @return A list of students in string format
     */
    public String getStudentList(){
        return studentList.toString();
    }

    /**
     * Returns a list of modules in a course
     *
     * @return A list of modules in a course
     */
    public String getModuleList(){
        return moduleList.toString();
    }

    /**
     * Returns the degree of a course
     *
     * @return The degree of a course
     */
    public String getDegree() {
        return degree;
    }

    /**
     * Returns the graduate level of a course
     *
     * @return The graduate level of a course
     */
    public String getGraduateLevel() {
        return graduateLevel;
    }

    /**
     * Returns the course code of a course
     *
     * @return The course code of a course
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Returns the duration of a course in years
     *
     * @return The duration of a course
     */

    public int getDuration() {
        return duration;
    }

    /**
     * Adds a module object to a course
     *
     * @param m The module getting added to a course
     */
    public void addModule(Module m){
        moduleList.add(m.getModuleName());
    }

    /**
     * Adds a semester object to a course
     *
     * @param s The semester getting added
     */
    public void addSemester(Semester s){
        semester.add(s);
    }

    /**
     * Returns the semesters in a course
     *
     * @return The semesters in a course
     */
    public String getSemesters(){
        return semester.toString();
    }

    /**
     * Returns the details of a course in string format
     *
     * @return The details of a course
     */
    public String getDetails(){
        return String.format("Course Name: %s\nCourse Code: %s\nSemester: %s\nModule List: %s\nStudent List: %s",getCourseName(),getCourseCode(),getSemesters(),getModuleList(),getStudentList());
    }

    /**
     * Returns the details of a course needed for the database
     *
     * @return Simpler version of details of a course
     */
    public String toString(){
        return String.format("%s %s %d",getCourseCode(),getCourseName(),getDuration());
    }
}
