import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Jakub & Eryk
 */
public class CLI {
    private Course course;
    private Module module;

    //private Lecturer lecturer;
    private Student student;
    private String user;
    private String password;
    //Admin password for restricted access
    private String admin_pass = "TestingStuff123?";
    Scanner in = new Scanner(System.in);
    AccountDatabase user_db = new AccountDatabase();
    LecturerDatabase lecturerDb = new LecturerDatabase();
    StudentDatabase studentDb = new StudentDatabase();

    ModuleDatabase moduleDb = new ModuleDatabase();

    CourseDatabase courseDb = new CourseDatabase();

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
            System.out.println("A)dmin F)ormat L)ecturer S)tudent Q)uit");
            String command = in.nextLine();
            switch (command.toUpperCase()) {
                case "S" -> {
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
                case "Q" -> {
                    running = false;
                }

            }

        }

    }

    private void adminAccess1(){
        System.out.println("ADMIN PASSWORD REQUIRED");
        String admin_pass_attempt = in.nextLine();
        if(Objects.equals(admin_pass_attempt, admin_pass)) {
            System.out.println("ACCESS GRANTED");
            String adminCommands;
            boolean running = true;
            while(running){
                System.out.println("A)dd-User R)emove-User Q)uit");
                adminCommands = in.nextLine();
                switch(adminCommands.toUpperCase()){
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

    public void studentAccess(){
        boolean running = true;
        String userCommandds;
        while(running){
            System.out.print("L)ogin Q)uit ~more functionality to be added~" );
            userCommandds = in.nextLine();
            switch(userCommandds.toUpperCase()){
                case "L" -> {
                    boolean checker = true;
                    while (checker) {
                        System.out.println("Enter your user id.");
                        user = in.nextLine();
                        System.out.println("Enter the user's password.");
                        password = in.nextLine();
                        if (user_db.login(user, password)) {
                            System.out.println("login was successful");
                            checker = false;
                            studentMenu(user);
                        } else {
                            System.out.println("login was unsuccessful");
                        }
                    }
                }
                case "Q" -> {
                    running = false;
                }
            }
        }
    }


    //JAKUB

    /**
     * Student menu which displays all options a student can use
     */

    private void studentMenu(String id){
        boolean running = true;
        String userCommands;
        while(running){
            System.out.print("S)tudent-Details T)ranscript Q)uit" );
            userCommands = in.nextLine();
            switch(userCommands.toUpperCase()){
                case  "S" -> {
                    try{
                        StudentDatabase studentDB = new StudentDatabase();
                        System.out.println(Arrays.toString(studentDB.getDetails(id)));
                    } catch(RuntimeException e){
                        e.printStackTrace();
                    }
                }
                case "T" -> {
                    try{
                        Transcript transcript = new Transcript(user);
                        System.out.println(transcript.getTranscript());
                    } catch(RuntimeException e){
                        e.printStackTrace();
                }

                }case "Q" ->{
                    running = false;

                }
            }
        }
    }

    /**
     * Admin menu which displays all options an admin can use
     *      - User has to input the admin password, if password is correct access is granted
     */
    private void adminAccess(){
        System.out.println("ADMIN PASSWORD REQUIRED");
        String admin_pass_attempt = in.nextLine();
        if(Objects.equals(admin_pass_attempt, admin_pass)) {
            System.out.println("ACCESS GRANTED");
            String input;
            boolean running = true;
            while(running){
                System.out.println("A)dd R)emove Q)uit");
                input = in.nextLine();
                switch(input.toUpperCase()){
                    case "A" ->{
                        adminAdd();
                    }
                    case "Q" -> {
                        running = false;
                    }

                }
            }
        }
    }


    /**
     * Admin add menu after selecting add on admin home page
     */
    private void adminAdd(){
        boolean running = true;
        while(running){
            System.out.println("Select What You Want To Add: (NOTE: Whatever You Want To Add Needs To Be Created First!)\n" +
                    "M)odule L)ecturer S)tudent C)ourse Q)uit");
            String input = in.nextLine();
            switch (input.toUpperCase()){
                case "M" ->{
                    try{
                        System.out.println("Enter Module Code:");
                        String moduleCode = in.nextLine();
                        System.out.println("Enter Module Name:");
                        String moduleName = in.nextLine();
                        System.out.println("Enter Module Name:");
                        int credit = Integer.parseInt(in.nextLine());
                        Module module = new Module(moduleCode, moduleName, credit );
                        ModuleDatabase moduleDB = new ModuleDatabase();
                        moduleDB.addToDb(module);
                    } catch (RuntimeException e){
                        System.out.println("Processing failed please try again!");
                        e.printStackTrace();
                    }
                }case "L" ->{

                    System.out.println("Enter Lecturer Name");
                    String firstName = in.nextLine();
                    boolean checker = true;
                    while (checker) {
                        if (!firstName.matches("[a-z A-Z]\\w*")) {
                            System.out.println("Enter Lecturers Name (DO NOT USE SPACES, USE -");
                            firstName = in.nextLine();
                        }else  checker = false;
                    }
                    checker = true;
                    System.out.println("Enter Lecturer Surname");
                    String surname = in.nextLine();
                    while (checker) {
                        if (!surname.matches("[a-z A-Z]\\w*")) {
                            System.out.println("Enter Lecturers Surname (DO NOT USE SPACES, USE -\"");
                            surname = in.nextLine();
                        }else  checker = false;
                    }
                    checker = true;
                    System.out.println("Enter Lecturer Module Code");
                    String moduleCode = in.nextLine();
                    while (checker) {
                        if (!Character.isLetter(moduleCode.charAt(0)) && Character.isLetter(moduleCode.charAt(1)) && moduleCode.matches("\\w{2}\\d{4}")) {
                            System.out.println("Enter Lecturer Module Code (MUST CONTAIN, 2 LETTERS IN CAPITALS, 4 DIGITS");
                            moduleCode = in.nextLine();
                        }else  checker = false;
                    }
                    checker = true;
                    System.out.println("Enter Lecturer Phone Number");
                    String phoneNumber = in.nextLine();
                    while (checker) {
                        if (!phoneNumber.matches("[+]\\w{2,3}\\w{4,12}")) {
                            System.out.println("Enter Lecturer Phone Number (MUST CONTAIN, +, COUNTRY CODE [2-3 DIGITS] AND UP TO 12 DIGITS AFTER COUNTRY CODE");
                            phoneNumber = in.nextLine();
                        }else  checker = false;
                    }
                    System.out.println("Enter Lecturer Email");
                    String email = in.nextLine();
                    while (checker) {
                        if (!email.matches(".*@\\w+.\\w+")) {
                            System.out.println("Enter Lecturer Email FORMAT - *******@***.***");
                            email = in.nextLine();
                        } else checker = false;
                    }
                    System.out.println("Enter Lecturer Department");
                    String department = in.nextLine();
                     Lecturer lecturer = new Lecturer(firstName, surname, moduleCode, phoneNumber, email, department);
                    lecturerDb.addToDb(lecturer);
                }case "S" -> {
                    System.out.println("Create the new ID");
                    user = in.nextLine();
                    if (!user_db.isValidId(user) && !user_db.isValidUsername(user)) {
                        System.out.println("Invalid ID try again!");
                        break;
                    }
                    System.out.println("Create the new password for that user");
                    password = in.nextLine();
                    if (!user_db.isValidPassword(password)) {
                        System.out.println("Invalid password try again!");
                        break;
                    }

                    try {
                        System.out.println("Enter ID");
                        String id = in.nextLine();
                        System.out.println("Enter first name");
                        String firstName = in.nextLine();
                        System.out.println("Enter surname");
                        String surName = in.nextLine();
                        System.out.println("Enter address");
                        String address = in.nextLine();
                        System.out.println("Enter phonenumber");
                        String phoneNumber = in.nextLine();
                        System.out.println("Enter email");
                        String email = in.nextLine();
                        System.out.println("Enter course code");
                        String courseCode = in.nextLine();
                        Student student = new Student(id, firstName, surName, address, phoneNumber, email, courseCode);
                        StudentDatabase studentDB = new StudentDatabase();
                        studentDB.addToDb(student);
                        user_db.addUser(user, password);
                        System.out.println("New user added!");
                    } catch (RuntimeException e) {
                        System.out.println("Processing failed please try again!");
                        e.printStackTrace();
                    }
                }case "C" ->{
                    System.out.println("Enter ModuleCode");
                    String courseCode = in.nextLine();
                    System.out.println("Enter Num of Semesters");
                    int numOfSem = Integer.parseInt(in.nextLine());
                    CourseModulesDatabase cmDB = new CourseModulesDatabase();
                    cmDB.addCourse(courseCode, numOfSem);
                    boolean adding = true;
                    if(adding){
                        System.out.println("Enter Semester");
                        int semester = Integer.parseInt(in.nextLine());
                         System.out.println("Enter module code");
                         String moduleCode = in.nextLine();
                         cmDB.createModule(courseCode, semester,moduleCode);
                         System.out.println("Continue adding Y/N");
                         String reply = in.nextLine();
                         if(reply != "Y"){
                             adding = false;
                             cmDB.saveToFile();
                         }
                    }


                }case "Q" ->{
                    running = false;
                }
            }

        }
    }

    /**
     * Admin create menu after being selected from admin home page
     */

    private void adminCreate(){
        boolean running = true;
        while(running) {
            System.out.println("C)ourse M)odule L)ecturer S)tudent Q)uit");
            String input = in.nextLine();
            switch (input.toUpperCase()) {
                case "C" -> {
                    System.out.println("Enter Course Code");
                    String courseCode = in.nextLine();
                    System.out.println("Enter Course Name");
                    String courseName = in.nextLine();
                    System.out.println("Enter Course Degree");
                    String degree = in.nextLine();
                    System.out.println("Enter Course Type");
                    String courseType = in.nextLine();
                    System.out.println("Enter Course Duration");
                    int duration = Integer.parseInt(in.nextLine());
                    course = new Course(courseCode,courseName, degree, courseType, duration  ) ;
                    courseDb.addToDb(course);
                }
                case "M" -> {
                    System.out.println("Enter Module Code");
                    String moduleCode = in.nextLine();
                    boolean checker = true;
                    while (checker) {
                        if (!Character.isLetter(moduleCode.charAt(0)) && Character.isLetter(moduleCode.charAt(1)) && moduleCode.matches("\\w{2}\\d{4}")){
                            System.out.println("Enter Module Code");
                            moduleCode = in.nextLine();
                        }else  checker = false;
                    }
                    System.out.println("Enter Module Name");
                    String moduleName = in.nextLine();
                    System.out.println("Enter Module Credit");
                    String moduleCredits = in.nextLine();
                    module = new Module(moduleName,moduleCode,Integer.parseInt(moduleCredits));
                    moduleDb.addToDb(module);
                }
                case "L" -> {
                    System.out.println("Enter Lecturer Name");
                    String firstName = in.nextLine();
                    boolean checker = true;
                    while (checker) {
                        if (!firstName.matches("[a-z A-Z]\\w*")) {
                            System.out.println("Enter Lecturers Name (DO NOT USE SPACES, USE -");
                            firstName = in.nextLine();
                        }else  checker = false;
                    }
                    checker = true;
                    System.out.println("Enter Lecturer Surname");
                    String surname = in.nextLine();
                    while (checker) {
                        if (!surname.matches("[a-z A-Z]\\w*")) {
                            System.out.println("Enter Lecturers Surname (DO NOT USE SPACES, USE -\"");
                            surname = in.nextLine();
                        }else  checker = false;
                    }
                    checker = true;
                    System.out.println("Enter Lecturer Module Code");
                    String moduleCode = in.nextLine();
                    while (checker) {
                        if (!Character.isLetter(moduleCode.charAt(0)) && Character.isLetter(moduleCode.charAt(1)) && moduleCode.matches("\\w{2}\\d{4}")) {
                            System.out.println("Enter Lecturer Module Code (MUST CONTAIN, 2 LETTERS IN CAPITALS, 4 DIGITS");
                            moduleCode = in.nextLine();
                        }else  checker = false;
                    }
                    checker = true;
                    System.out.println("Enter Lecturer Phone Number");
                    String phoneNumber = in.nextLine();
                    while (checker) {
                        if (!phoneNumber.matches("[+]\\w{2,3}\\w{4,12}")) {
                            System.out.println("Enter Lecturer Phone Number (MUST CONTAIN, +, COUNTRY CODE [2-3 DIGITS] AND UP TO 12 DIGITS AFTER COUNTRY CODE");
                            phoneNumber = in.nextLine();
                        }else  checker = false;
                    }
                    System.out.println("Enter Lecturer Email");
                    String email = in.nextLine();
                    while (checker) {
                        if (!email.matches(".*@\\w+.\\w+")) {
                            System.out.println("Enter Lecturer Email FORMAT - *******@***.***");
                            email = in.nextLine();
                        } else checker = false;
                    }
                    System.out.println("Enter Lecturer Department");
                    String department = in.nextLine();
                    Lecturer lecturer = new Lecturer(firstName, surname, moduleCode, phoneNumber, email, department);
                    lecturerDb.addToDb(lecturer);
                }
                case "S" -> {
                    boolean checker = true;
                    System.out.println("Enter Student Name");
                    String firstName = in.nextLine();
                    System.out.println("Enter Student Surname");
                    String surname = in.nextLine();
                    System.out.println("Enter Student Address");
                    String moduleCode = in.nextLine();
                    System.out.println("Enter Student Phone Number");
                    String phoneNumber = in.nextLine();
                    while (checker) {
                        if (!phoneNumber.matches("[+]\\w{2,3}\\w{9,12}")) {
                            System.out.println("Enter Lecturer Phone Number (MUST CONTAIN, + COUNTRY CODE 9-12 DIGITS");
                            phoneNumber = in.nextLine();
                        } else checker = false;
                    }
                    System.out.println("Enter Student Email");
                    String email = in.nextLine();
                    checker = true;
                    while(checker){
                        if(!email.contains("@") && email.contains(".")){
                            System.out.println("Enter Student Email - Format (****@*****.***) ");
                            email = in.nextLine();
                        }checker = false;
                    }
                    System.out.println("Enter Course Code");
                    String courseCode = in.nextLine();
                    student = new Student(firstName,surname,moduleCode,phoneNumber,email,courseCode);
                    studentDb.addToDb(student);
                }

                case "Q" -> {
                    running = false;
                }
            }
        }
    }

    /**
     * Lecturer menu after successful log on
     *
     */
    private void lecturerLoggedOn(){
        boolean running = true;
        String input;
        while(running){
            System.out.print("G)rade-Students Q)uit");
            input = in.nextLine();
            switch (input.toUpperCase()) {
                case "G" -> {
                    System.out.println("Enter Module Code");
                    String moduleCode = in.nextLine();
                    System.out.println("Enter Result Release DD/MM/YYYY");
                    String date = in.nextLine();
                    Gradebook book = new Gradebook(moduleCode, date);
                    boolean adding = true;
                    while(adding){
                        System.out.print("Student id");
                        String id = in.nextLine();
                        System.out.println("Student Result");
                        int moduleResult = Integer.parseInt(in.nextLine());
                        book.addStudentResult(id, moduleResult);
                        System.out.println("Continue Y/N ?");
                        String continued = "Y";
                        if ( continued != "Y"){
                            adding = false;
                            book.storeExamination();
                        }
                    }
                }
                case "Q" -> {
                    running = false;
                }
            }
        }
    }



    /**
     * Lecturer log on system
     *
     */
    private void lecturerAccess() {
        boolean running = true;
        String input;
        while (running) {
            System.out.println("L)ogin Q)uit");
            input = in.nextLine();
            switch (input.toUpperCase()) {
                case "L" -> {
                    System.out.println("Enter your User Name: (firstname.surname - eg. michael.english)");
                    this.user = in.nextLine();
                    System.out.println("Enter your Password: ");
                    this.password = in.nextLine();
                    if (user_db.login(user, password) && user_db.isValidUsername(user)) {
                        System.out.println("Log on was successful");
                        lecturerLoggedOn();
                    } else System.out.println("Log on was unsuccessful");
                }
                case "Q" -> {
                    running = false;
                }
            }
        }
    }

}