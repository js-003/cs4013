/*public class DriverGrades {
    public static void main(String[] args){

        Grades grades = new Grades();
        grades.setResult("01234", 74);
        grades.setResult("56789", 100);

        GradebookTesting gradebookTesting = new GradebookTesting();
        gradebook.addGrade("Midterm", grades);

        System.out.println(gradebook.getStudentGrade("01234"));
        System.out.println(gradebook.getStudentGrade("56789"));


    }
} */

    public class DriverGrades {
        public static void main(String[] args){

            Grades grades = new Grades();
            grades.setResult("01234", 20);
            grades.setResult("56789", 100);

            GradebookTesting gradebookTesting = new GradebookTesting();
            System.out.println(gradebookTesting.getGrade(grades.getResult("01234")));
            System.out.println(gradebookTesting.getGrade(grades.getResult("56789")));

        }
    }
