import java.util.*;

public class Module {
    private String moduleName;
    private String moduleCode;

    private int semester;

    private int credits;
    private ArrayList<Student> module;

    public Module(String moduleName, String moduleCode,int semester, int credits ){
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.semester = semester;
        this.credits = credits;
        module = new ArrayList<>();
    }

    public String getModuleName(){
        return this.moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void addStudent(Student s){
        this.module.add(s);
    }

    public void removeStudent(Student s){
        this.module.remove(s);
    }

    public String StudentList(){
        return this.module.toString();
    }

    public int getSemester() {
        return semester;
    }

    public int getCredits() {
        return credits;
    }

    public String toString(){
        return Arrays.toString(module.toArray()).replace("[","").replace("]","");
    }

}
