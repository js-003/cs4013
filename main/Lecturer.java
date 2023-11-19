public class Lecturer {

    private String firstName;
    private String surname;
    private String moduleCode;
    private String phoneNumber;
    private String email;
    private String department;

    public Lecturer(String firstName,String surname, String moduleCode, String phoneNumber, String email, String department){
        if(firstName.matches("[A-Z]\\w*")){
            this.firstName = firstName;
        }else throw new IllegalArgumentException("Check your first name");
        if(surname.matches("[A-Z]\\w*")) {
            this.surname = surname;
        }else throw new IllegalArgumentException("Check your last name");
        if(Character.isLetter(moduleCode.charAt(0))&&Character.isLetter(moduleCode.charAt(1))&& moduleCode.matches("\\w{2}\\d{4}")){
            this.moduleCode = moduleCode;
        }else throw new IllegalArgumentException("Incorrect Module Code");
        if(phoneNumber.matches("[+]\\w{2,3}\\w{9,12}")){
            this.phoneNumber = phoneNumber;
        }else throw new IllegalArgumentException("Incorrect Phone Number");
        if(email.matches(".*@\\w+.\\w+")) {
            this.email = email;
        }else throw new IllegalArgumentException("Incorrect Email");
        this.department = department;

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
        return String.format("%s,%s,%s,%s,%s",this.firstName,this.surname,this.moduleCode,this.phoneNumber,this.email);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
