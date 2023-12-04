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

    /**
     * Creates a course object by passing the parameters
     *
     * @param courseCode The code of a course
     * @param courseName The name of a course
     * @param degree The degree of the course
     * @param type
     * @param duration The duration of a course
     */
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

    /**
     * Returns a course Name
     *
     * @return course name
     */

    public String getCourseName(){
        return courseName;
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
     * Sets the graduate level for a course
     */
    private void getGraduateLevel(){
        if(type.toLowerCase().contains("bachelor")){
            this.graduateLevel = "Undergraduate";
        }else if(type.toLowerCase().contains("masters")){
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
     * Returns the module list for the course
     *
     * @return Module List
     */
    public String getModuleList(){
        return moduleList.toString();
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


    //below use in another db
    /**
     * Returns the details of a course in string format
     *
     * @return The details of a course
     */
    public String getDetails(){
        return String.format("Course Name: %s\nCourse Code: %s\nModule List: %s\nStudent List: %s",getCourseName(),getCourseCode(),getModuleList(),getStudentList());
    }
    /**
     * Returns the details of a course needed for the database
     *
     * @return Simpler version of details of a course
     */
    public String toString(){
        return String.format("%s,%s,%s,%s,%s,%d", courseCode, courseName,degree, type,graduateLevel, duration);
    }
}
