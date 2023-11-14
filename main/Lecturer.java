public class Lecturer {
    private String firstName, lastName, moduleCode,phoneNumber,email;

    public Lecturer(String firstName,String lastName, String moduleCode, String phoneNumber, String email){
        if(firstName.matches("[A-Z]\\w*")){
            this.firstName = firstName;
        }else System.out.println("A");
        if(lastName.matches("[A-Z]\\w*")) {
            this.lastName = lastName;
        }else System.out.println("B");
        if(Character.isLetter(moduleCode.charAt(0))&&Character.isLetter(moduleCode.charAt(1))&& moduleCode.matches("\\w{2}\\d{4}")){
            this.moduleCode = moduleCode;
        }else System.out.println("C");
        if(phoneNumber.matches("[+]\\w{2,3}\\w{9,12}")){
            this.phoneNumber = phoneNumber;
        }else System.out.println("D");
        if(email.matches(".*@\\w+.\\w+")) {
            this.email = email;
        }else System.out.println("e");
    }

    public static void main(String[] args) {
        Lecturer me = new Lecturer("Jakub","SOKAL","Cs2002","+353894525922","jakub.sokal13@gmail.com");
    }
}
