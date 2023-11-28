import java.util.Objects;
import java.util.Scanner;


public class CLI {

    private Course course ;
    private Module module;
    private Gradebook gradebook = new Gradebook();;
    private Grades grade ;

    private Lecturer lecturer;
    private Student student;
    private String user;
    private String password;
    //Admin password for restricted access
    private String admin_pass = "TestingStuff123?";
    Scanner in = new Scanner(System.in);
    AccountDatabase user_db = new AccountDatabase("Account.csv");

    public void run() {
        System.out.println("""
                ############################################################
                
                U   U  L            PPPP    OOO   RRRR   TTTTT   AAA   L     
                U   U  L            P   P  O   O  R   R    T    A   A  L    
                U   U  L            PPPP   O   O  RRRR     T    AAAAA  L    
                U   U  L            P      O   O  R R      T    A   A  L    
                 UUU   LLLLL        P       OOO   R  RR    T    A   A  LLLLL
                
                ############################################################
                """);

        boolean running = true;
        System.out.println(user_db.toString());
        while (running) {
            System.out.println("U)ser-Acess F)ormatting A)dmin L)ecturer");
            String command = in.nextLine();
            switch (command) {
                case "U" -> {
                    studentAccess();
                }
                case "F" -> {
                    System.out.println("""
                            #####################################################################
                            ID FORMATTING:
                            -IDs will contain only 8 numbers
                                                        
                            PASSWORD FORMATTING:
                            -Ensure that at least one upper case letter is used
                            -Ensure that at least one lower case letter is used
                            -Ensure that at least one digit is used
                            -Ensure that at least one special character is used from the follow:
                                        [ !, @, #, $, %, ^, &, *, (, ), ? ]
                            -Only passwords with 8 to 64 characters will be acceptable
                            #####################################################################""");


                }
                case "L" -> {
                    lecturerAccess();
                }
                case "A" -> {
                    adminAccess();
                }

            }

        }
    }

    private void adminAccess(){
        System.out.println("ADMIN PASSWORD REQUIRED");
        String admin_pass_attempt = in.nextLine();
        if(Objects.equals(admin_pass_attempt, admin_pass)) {
            System.out.println("ACCESS GRANTED");
            String adminCommands;
            boolean running = true;
            while(running){
                System.out.println("A)dd-User R)emove-User Q)uit");
                adminCommands = in.nextLine();
                switch(adminCommands){
                    case "A" -> {
                        System.out.println("Create the new user ID or Username");
                        user = in.nextLine();
                        if(!user_db.isValidId(user) && !user_db.isValidUsername(user)){
                            System.out.println("Invalid ID or Username try again!");
                            break;
                        }
                        System.out.println("Create the new password for that user");
                        password = in.nextLine();
                        if(!user_db.isValidPassword(password)){
                            System.out.println("Invalid password try again!");
                            break;
                        }
                        user_db.addUser(user, password);
                        System.out.println("New user added!");
                    }
                    case "R" -> {
                        System.out.println("Enter user ID for removal");
                        user = in.nextLine();
                        if(!user_db.isValidId(user) && !user_db.isValidUsername(user)){
                            System.out.println("Invalid ID or Username try again!");
                            break;
                        }
                        user_db.removeUser(user);
                        System.out.println("User removed!");
                    }
                    case "Q" -> {
                        running = false;
                    }
                }
            }
        }

    }

    public void userAccess(){
        boolean running = true;
        String userCommandds;
        while(running){
            System.out.print("L)ogin Q)uit ~more functionality to be added~" );
            userCommandds = in.nextLine();
            switch(userCommandds){
                case "L" -> {
                    System.out.println("Enter your user id.");
                    user = in.nextLine();
                    System.out.println("Enter the user's password.");
                    password = in.nextLine();
                    if (user_db.login(user, password)) {
                        System.out.println("login was successful");
                    } else {
                        System.out.println("login was unsuccessful");
                    }
                }
                case "Q" -> {
                    running = false;
                }
            }
        }
    }


    //JAKUB
    private void adminAccess1(){
        System.out.println("ADMIN PASSWORD REQUIRED");
        String admin_pass_attempt = in.nextLine();
        if(Objects.equals(admin_pass_attempt, admin_pass)) {
            System.out.println("ACCESS GRANTED");
            String adminCommands;
            boolean running = true;
            while(running){
                System.out.println("C)reate R)emove-User Q)uit");
                adminCommands = in.nextLine();
                switch(adminCommands){
                    case "C" -> {
                        adminCreate();
                    }
                    case "R" -> {
                        System.out.println("Enter user ID for removal");
                        user = in.nextLine();
                        if(!user_db.isValidId(user) && !user_db.isValidUsername(user)){
                            System.out.println("Invalid ID or Username try again!");
                            break;
                        }
                        user_db.removeUser(user);
                        System.out.println("User removed!");
                    }
                    case "Q" -> {
                        running = false;
                    }
                }
            }
        }
    }
    public void adminCreate(){
        boolean running = true;
        while(running) {
            System.out.println("C)ourse M)odule L)ecturer S)tudent Q)uit");
            String input = in.nextLine();
            switch (input) {
                case "C" -> {
                    System.out.println("Enter Course Code");
                    String courseCode = in.nextLine();
                    System.out.println("Enter Course Name");
                    String courseName = in.nextLine();
                    System.out.println("Enter Course Year Of Study");
                    String courseYear = in.nextLine();
                    course = new Course(courseCode,courseName,Integer.parseInt(courseYear)) ;

                }
                case "M" -> {
                    System.out.println("Enter Module Code");
                    String moduleCode = in.nextLine();
                    System.out.println("Enter Module Name");
                    String moduleName = in.nextLine();
                    System.out.println("Enter Module Semester");
                    String moduleSemester = in.nextLine();
                    System.out.println("Enter Module Credit");
                    String moduleCredits = in.nextLine();
                    module = new Module(moduleName,moduleCode,Integer.parseInt(moduleSemester),Integer.parseInt(moduleCredits));
                }
                case "L" -> {
                    System.out.println("Enter Lecturer Name");
                    String firstName = in.nextLine();
                    System.out.println("Enter Lecturer Surname");
                    String surname = in.nextLine();
                    System.out.println("Enter Lecturer Module Code");
                    String moduleCode = in.nextLine();
                    System.out.println("Enter Lecturer Phone Number");
                    String phoneNumber = in.nextLine();
                    System.out.println("Enter Lecturer Email");
                    String email = in.nextLine();
                    System.out.println("Enter Lecturer Department");
                    String department = in.nextLine();
                    lecturer = new Lecturer(firstName,surname,moduleCode,phoneNumber,email,department);
                }
                case "S" -> {
                    System.out.println("Enter Student Name");
                    String firstName = in.nextLine();
                    System.out.println("Enter Student Surname");
                    String surname = in.nextLine();
                    System.out.println("Enter Student Course");
                    String moduleCode = in.nextLine();
                    System.out.println("Enter Lecturer Phone Number");
                    String phoneNumber = in.nextLine();
                    System.out.println("Enter Lecturer Email");
                    String email = in.nextLine();
                    System.out.println("Enter Lecturer Department");
                    String department = in.nextLine();
                    lecturer = new Lecturer(firstName,surname,moduleCode,phoneNumber,email,department);
                }
            }
        }
    }

    private void lecturerLoggedOn(){
        boolean checker = true;
        String userCommands;
        while(checker){
            System.out.print("S)how-Student-List G)rade-Student Q)uit");
            userCommands = in.nextLine();
            switch (userCommands) {
                case "S" -> {
                    System.out.println(course.getStudentList());
                }
                case "G" -> {
                    System.out.println("Enter Student ID");
                    String sId = in.nextLine();
                    System.out.println("Enter Result Of The Test");
                    String result = in.nextLine();
                    System.out.println("Enter Name Of The Test");
                    String testName = in.nextLine();
                    grade = new Grades(testName,Double.parseDouble(result));
                    gradebook.addTestResult(sId,grade);
                }
            }
        }
    }

    private void lecturerAccess() {
        boolean checker = true;
        String userCommands;
        while (checker) {
            System.out.print("L)ogin Q)uit");
            userCommands = in.nextLine();
            switch (userCommands) {
                case "L" -> {
                    System.out.println("Enter your User Name: (Firstname.surname - eg. michael.english)");
                    this.user = in.nextLine();
                    System.out.println("Enter your Password: ");
                    this.password = in.nextLine();
                    if (user_db.login(user, password) && user_db.isValidUsername(user)) {
                        System.out.println("Log on was successful");
                        lecturerLoggedOn();
                    } else System.out.println("Log on was unsuccessful");
                }
                case "Q" -> {
                    checker = false;
                }
            }
        }
    }
}
