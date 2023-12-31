import java.util.ArrayList;

/**
 * Transcript class provides an environment in which other objects can be used to form a well-structured documentation
 */
public class Transcript {
    private String student_id;
    private CourseModulesDatabase courseModuleDB;

    private StudentDatabase studentDB;
    private ArrayList<ArrayList<String>> modulesPerSemester;
    private String[] studentDetails;

    private GradingDatabase gradingDB;


    private CourseDatabase courseDB;
    private ArrayList<ArrayList<Object>> grades;
    private String[] courseDetails;
    private ModuleDatabase moduleDB;

    /**
     * Transcript constructors generates the object from student id and introduces other objects
     * @param student_id
     */
    public Transcript(String student_id){
        this.student_id = student_id;

        this.studentDB = new StudentDatabase();
        this.studentDetails = studentDB.getDetails(student_id);

        this.moduleDB = new ModuleDatabase();

        this.courseDB = new CourseDatabase();
        this.courseDetails = courseDB.getDetails(studentDetails[5]);

        this.gradingDB = new GradingDatabase();
        this.grades = gradingDB.getGrades(student_id);
        //hi

        this.courseModuleDB = new CourseModulesDatabase();
        this.modulesPerSemester = courseModuleDB.getModules(studentDetails[5]);
    }

    /**
     * Transcript is returned for the given module that the student has undertaken
     * @param moduleCode The parameter navigate the module for which a test may haven taken
     * @return The return a multi line String which contain the information regarding the grades for that module along with student details
     */
    public String getModuleTranscript(String moduleCode){
        for(ArrayList<Object> test : gradingDB.getGrades(student_id)){
            if(test.contains(moduleCode)){
                String[] holder = moduleDB.getDetails(moduleCode);

                return String.format((String.format("""
            +------------------------------------------------------------------------------------------------------------------------------+
            |                                                   UL Student Transcript                                                      |
            | First Name:    %-110s|                                                                                                                                                                                                                  
            | Email:         %-110s|                                                                                                                                                                    
            | Course:        %-110s|                                                                                                              
            +------------------------------------------------------------------------------------------------------------------------------+
            +------------------------------------------------------------------------------------------------------------------------------+
            |                                                                                                                              |
            | Module      Title                                                                  Grade               Credit                |
            |                                                                                                                              |
            | %-5s        %-65s       %-2s                %-1s                    |
            |                                                                                                                              |
            +------------------------------------------------------------------------------------------------------------------------------+
            """, studentDetails[0] + " " + studentDetails[1], studentDetails[3], studentDetails[5], moduleCode,holder[0] ,test.get(2), holder[1])));
            }
        }
        return "";
    }

    /**
     * Transcript for the student which lists the undertaken modules for the course with the associated course
     * @return The returns a multi line String which contains the student details and progression throughout the course with respect to module grading
     */
    public String getTranscript() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("""
            +------------------------------------------------------------------------------------------------------------------------------+
            |                                                   UL Student Transcript                                                      |
            | First Name:    %-110s|                                                                                                       
            | Address:       %-110s|                                                                                                            
            | Email:         %-110s|                                                                                                                                                                                                                              
            | Telephone:     %-110s|                                                                                                             
            | Course:        %-110s|                                                                                                              
            +------------------------------------------------------------------------------------------------------------------------------+
            """, studentDetails[0] + " " + studentDetails[1], studentDetails[2], studentDetails[3], studentDetails[4], studentDetails[5]));

        int i = 0;
        for (ArrayList<String> semester : modulesPerSemester) {
            double sumQca = 0.00;
            int sumCredit = 0;
            int numOfModules = semester.size();
            i++;
            sb.append(String.format("""
                    +------------------------------------------------------------------------------------------------------------------------------+
                    | SEMESTER%-117d|
                    |                                                                                                                              |
                    | Module      Title                                                                  Grade               Credit                |
                    |                                                                                                                              |
                    """,i));
            for (String module : semester) {
                String[] holder = moduleDB.getDetails(module);

                for (ArrayList<Object> gradeDetail : grades) {
                    if (module.equals(gradeDetail.get(0))) {
                        sb.append(String.format("""
                    | %-5s        %-65s       %-2s                %-1s                    |
                    """,module, holder[0],gradeDetail.get(2), holder[1]));
                        sumQca += (double) gradeDetail.get(3);
                        sumCredit += Integer.parseInt(holder[1]);
                        break;
                    }
                }

            }
            sb.append(String.format("""
                |                                                                                                                              |                                                                                                                                                              
                +------------------------------------------------------------------------------------------------------------------------------+
                    """));
            sb.append(String.format("""
                | Sesstion To-Date                                                                                                             |
                |                                                                                                                              |
                | Credits:   %-114d|
                | QCA:       %-114.2f|
                | QCS:       %-114.2f|
                +------------------------------------------------------------------------------------------------------------------------------+\n\n
                """, sumCredit, sumQca/numOfModules,(sumQca/numOfModules)*sumCredit));
        }
        return sb.toString();
    }
}
