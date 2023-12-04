import java.util.*;
/**
 * @author Jakub
 */
public class Module {
    private String moduleName;
    private String moduleCode;

    private int semester;

    private int credits;
    private ArrayList<Student> module;

    /**
     * Creates a module object by passing in the parameters below
     *
     * @param moduleName Name of the module
     * @param moduleCode Code of the module
     * @param credits Credits a module carries
     */
    public Module(String moduleName, String moduleCode, int credits ){
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.credits = credits;
        module = new ArrayList<>();
    }

    /**
     * Returns the name of a module
     *
     * @return The name of a module
     */

    public String getModuleName(){
        return this.moduleName;
    }

    /**
     * Returns the module code of a module
     *
     * @return The module code of a module
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * Adds a student to a module already created
     *      - Stores the student object in an ArrayList<Student> called module
     *
     * @param s The student object getting added
     */
    public void addStudent(Student s){
        this.module.add(s);
    }

    /**
     * Removes a student from a module
     *      - Removes the student object from the ArrayList<Student> called module
     *
     * @param s The student object getting removed
     */
    public void removeStudent(Student s){
        this.module.remove(s);
    }

    /**
     * Returns the list of student objects in string format
     *
     * @return Student objects in string format
     */
    public String StudentList(){
        return Arrays.toString(module.toArray()).replace("[","").replace("]","");
    }

    /**
     * Returns the semester of the module
     *
     * @return The semester the module is in
     */
    public int getSemester() {
        return semester;
    }

    /**
     * Returns the credits the module carries
     *
     * @return The credits the module carries
     */

    public int getCredits() {
        return credits;
    }

    /**
     * Returns the details of a module in string format
     *
     * @return The details of a module in string format
     */
    public String toString(){
        return String.format("%s,%s,%s",getModuleCode(),getModuleName(),getCredits()) ;
    }

}
