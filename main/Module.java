import java.util.ArrayList;

public class Module {
    private String moduleName;
    private String moduleCode;
    private ArrayList<Student> module;

    public Module(String moduleName,String moduleCode){
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
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
}
