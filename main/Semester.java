
import java.util.ArrayList;

/**
 * @author Sinead
 */
public class Semester {
    private int semesterNumber;
    private ArrayList<Module> SemesterModules; //creates an arraylist of type module
    private ArrayList<Semester> allSemesters = new ArrayList<Semester>(); //not sure where to intilise this

    /**
     * a method that creates a semester given a semesterNumber
     * @param semesterNumber the semesterNumber
     * */
    public Semester(int semesterNumber) {
        this.semesterNumber = semesterNumber;
        this.SemesterModules = new ArrayList<Module>();

    }
    /**
     * a method that adds a specified module to a specified semester
     * @param s the semester we wish to add a module to
     * @param m the module we wish to add
     * */
    public void addModulesToSemester(Semester s, Module m) { //not sure if i should specify semeseter or semester number
        if (s.doesSemesterExist(allSemesters, semesterNumber)) {
            SemesterModules.add(m);
            //add the specified module to the specified semester
        }
    }
    /**
     * a method that returns all the modules that are in a semester
     * */
    public ArrayList<Module> getSemesterModules() {
        return SemesterModules;
        //returns the modules in the semester
    }

    /**
     * a method that returns a semester number
     * */
    public int getSemesterNumber() {
        return semesterNumber;
    }

    /**
     * a method that checks if a semester already exists
     * @param allSemesters an arraylist that contains all semester numbers
     * @param semesterNumber the specified semesterNumber
     * */
    public static boolean doesSemesterExist(ArrayList<Semester> allSemesters, int semesterNumber) {
        for (Semester semester : allSemesters) {
            if (semester.getSemesterNumber() == semesterNumber) {
                return true;
            }
        }
        return false;
    }
}

