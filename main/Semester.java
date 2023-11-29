
import java.util.ArrayList;


public class Semester {
    private int semesterNumber;
    private ArrayList<Module> SemesterModules; //creates an arraylist of type module
    private ArrayList<Semester> allSemesters;

    public Semester(int semesterNumber){
        this.semesterNumber= semesterNumber;
        this.SemesterModules= new ArrayList<Module>();

    }
    public void addModulesToSemester(Semester s,Module m) {
        if (s.doesSemesterExist(allSemesters, semesterNumber)) {
            SemesterModules.add(m);
            //add the specified module to the specified semester
        }
    }
    public ArrayList<Module> getSemesterModules(){
        return SemesterModules;
        //returns the modules in the semester
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }

    //a method to check wether or not a semester exists
    public static boolean doesSemesterExist(ArrayList<Semester> allSemesters, int semesterNumber) {
        for (Semester semester : allSemesters) {
            if (semester.getSemesterNumber() == semesterNumber) {
                return true;
            }
        }
        return false;
    }
}
