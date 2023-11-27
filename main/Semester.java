package main;
import java.util.Date;
import java.util.ArrayList;


public class Semester {
    private int semesterNumber;
    private Date startDate;
    private Date endDate;
    private ArrayList<Module> SemesterModules;
    private ArrayList<Semester> allSemesters;

    public Semester(int semesterNumber){
        //this method only takes into account 4 year courses (8 semesters)
        this.semesterNumber= semesterNumber;
        this.startDate= startDate;
        this.endDate= endDate;

    }
    public void addModulesToSemester(Semester s,Module m){
        SemesterModules.add(m);
        //add the specified module to the specified semester
    }
    public ArrayList<Module> getSemesterModules(){
        return SemesterModules;
        //returns the modules in the semester
    }

    //adds a semester to an array list of semesters
    public void addSemester(Semester s) {
        // Checks if the semester is not already in the allSemesters list
        if (!allSemesters.contains(s)) {
            allSemesters.add(s);
        } else {
            System.out.println("Semester " + s + " already exists.");
        }

    }
}
