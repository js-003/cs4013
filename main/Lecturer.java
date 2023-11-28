import java.util.ArrayList;

public class Lecturer {

    private String firstName;
    private String surname;
    private String moduleCode;
    private String phoneNumber;
    private String email;
    private String department;

    private final ArrayList<Integer> listId = new ArrayList<>();
    private int id;

    public Lecturer(String firstName,String surname, String moduleCode, String phoneNumber, String email, String department){
        this.firstName = firstName;
        this.surname = surname;
        this.moduleCode = moduleCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.department = department;
        int newID = (int) ((Math.random())*99999);
        while(listId.contains(newID)){
            newID = (int) ((Math.random())*99999);
        }
        this.id = newID;

    }

    public String getModuleCode(){
        return this.moduleCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return surname;
    }
    public void setSurname(String newSurname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String newNumber) {
        this.phoneNumber = newNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public String toString(){
        return String.format("%s,%s,%s,%s,%s,%s",this.id,this.firstName,this.surname,this.moduleCode,this.phoneNumber,this.email);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}
