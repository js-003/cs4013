import java.util.HashMap;

/**
 * This class represents a gradebook, which stores grades for exams for different students.
 */
public class Gradebook {
    // A map to store grades for different exams
    private final HashMap<String, Grades> grades;

    /**
     * Initiate an empty gradebook.
     */
    public Gradebook() {
        this.grades = new HashMap<>();
    }

    /**
     * Add grades for an specific exam to the gradebook.
     *
     * @param test    The name or identifier of an exam.
     * @param results The Grades object containing results for an exam
     */
    public void addGrade(String test, Grades results) {
        this.grades.put(test, results);
    }

    /**
     * Calculate and return the average score for an specific exam.
     *
     * @param test The identifier of an exam
     * @return The average score for the specified exam
     */
    public Double getAverage(String test) {
        Double total = 0.0;
        Grades results = grades.get(test);
        for(Double grade : results.getResults().values()) {
            total += grade;
        }
        return (double) (total/results.getResults().values().size());
    }

    /**
     * Calculate and return the class average across all exams
     *
     * @return The class average across all exams
     */
    public Double getClassAverage() {
        Double total = 0.0;
        for(String test : this.grades.keySet()) {
            total += this.getAverage(test);
        }
        return (total/this.grades.values().size());
    }

    /**
     * Calculate and return the average score for an specific student across all exams
     *
     * @param ID The student's ID
     * @return The average score for the specified student across all exams
     */
    public Double getStudentAverage(String ID) {
        Double total = 0.0;
        for(String test : this.grades.keySet()) {
            total += this.grades.get(test).getResult(ID);
        }
        return (double) (total/this.grades.values().size());
    }

    /**
     * Determine and return the grade type for an specific student based on their average
     *
     * @param ID The student's ID.
     * @return The GradeType representing the determined grade for the student.
     */
    public GradeType getStudentGrade(String ID) {
        Double average = getStudentAverage(ID);
        if (average >= 80) {
            return GradeType.A1;
        }
        if (average >= 72) {
            return GradeType.A2;
        }
        if (average >= 64) {
            return GradeType.B1;
        }
        if (average >= 60) {
            return GradeType.B2;
        }
        if (average >= 56) {
            return GradeType.B3;
        }
        if (average >= 52) {
            return GradeType.C1;
        }
        if (average >= 48) {
            return GradeType.C2;
        }
        if (average >= 40) {
            return GradeType.C3;
        }
        if (average >= 35) {
            return GradeType.D1;
        }
        if (average >= 30) {
            return GradeType.D2;
        }
        if (average >= 0) {
            return GradeType.F;
        }
        return GradeType.NG;
    }

    public void addTestResult(String sId, Grades grade) {
    }
}