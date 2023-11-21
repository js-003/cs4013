package main;
import java.util.Date;
import java.util.ArrayList;


public class Semester {
    private int semesterNumber;
    private Date startDate;
    private Date endDate;
    private ArrayList<Module> SemesterModules;

    public Semester(int semesterNumber,Date startDate,Date endDate){
        //this method only takes into account 4 year courses (8 semesters)
        this.semesterNumber= semesterNumber;
        this.startDate= startDate;
        this.endDate= endDate;

    }
    public void addModulesToSemester(int SemesterNumber,Module m){
        SemesterModules.add(m);
        //add the specified module to the specified semester
    }
    public ArrayList<Module> getSemesterModules(){
        return SemesterModules;
        //returns the modules in the semester
    }
}
