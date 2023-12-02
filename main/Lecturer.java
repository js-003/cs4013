import java.util.ArrayList;

public class Lecturer {

    private String firstName;
    private String surname;
    private String moduleCode;
    private String phoneNumber;
    private String email;
    private String department;

    private final ArrayList<Integer> listId = new ArrayList<>();

    private String username;

    public Lecturer(String firstName,String surname, String moduleCode, String phoneNumber, String email, String department){
        this.firstName = firstName;
        this.surname = surname;
        this.moduleCode = moduleCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.department = department;
        generateUsername();
    }

    public void generateUsername(){
        this.username = this.firstName.toLowerCase()+"."+this.surname.toLowerCase();
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

    public String getSurname() {
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

    public String getUsername(){
        return this.username;
    }
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public String toString(){
        return String.format("%s,%s,%s,%s,%s,%s",getUsername(),getFirstName(),getSurname(),getModuleCode(),getPhoneNumber(),getEmail());
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public static void main(String[] args) {
        Lecturer n = new Lecturer("Mi","Eng","CS4013","+353876523466","m.eng@ul.ie","Science");
    }
}
