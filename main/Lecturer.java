public class Lecturer {
    private String firstName, lastName, moduleCode,phoneNumber,email;

    public Lecturer(String firstName,String lastName, String moduleCode, String phoneNumber, String email){
        if(firstName.matches("[A-Z]\\w*")){
            this.firstName = firstName;
        }else throw new IllegalArgumentException("Check your first name");
        if(lastName.matches("[A-Z]\\w*")) {
            this.lastName = lastName;
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
    }

    public static void main(String[] args) {
        Lecturer me = new Lecturer("Jakub","SOKAL","Cs2002","+353894525922","jakub.sokal13@gmail.com");
    }
}
