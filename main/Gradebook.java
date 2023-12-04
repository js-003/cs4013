import java.util.HashMap;
import java.util.Map;

/**
 * Represent a Gradebook for student examination results.
 * Extend GradingDatabase to utilise the functionality for storing results.
 */
public class Gradebook extends GradingDatabase {

    private String[] Grades;
    private double[] PercentageCutOff;
    private double[] Score;
    private HashMap<String, Double> resultsList;
    private String moduleCode;
    private String date;
    private GradingDatabase gdb;

    /**
     * Construct a Gradebook with the follow parameters.
     *
     * @param moduleCode       The code of the module.
     * @param date             The date of the examination.
     * @param grades           An array of grades.
     * @param percentageCutOff An array of percentage cutoff values corresponding to grades.
     * @param score            An array of score values corresponding to grades.
     */
    public Gradebook(String moduleCode, String date, String[] grades, double[] percentageCutOff, double[] score) {
        this.moduleCode = moduleCode;
        this.Grades = grades;
        this.PercentageCutOff = percentageCutOff;
        this.Score = score;
        this.date = date;
        resultsList = new HashMap<>();
        gdb = new GradingDatabase();
        gdb.loadFromFile();
    }

    /**
     * Construct a Gradebook with default grade labels and corresponding cutoff values and scores.
     *
     * @param moduleCode The code of the module for which the Gradebook is created.
     * @param date       The date when results are out.
     */
    public Gradebook(String moduleCode, String date) {
        this.Grades = new String[]{"A1", "A2", "B1", "B2", "B3", "C1", "C2", "C3", "D1", "D2", "F", "NG", "I"};
        this.PercentageCutOff = new double[]{80, 72, 64, 60, 56, 52, 48, 40, 35, 30, 0, -1, -2};
        this.Score = new double[]{4.00, 3.60, 3.20, 3.00, 2.80, 2.60, 2.40, 2.00, 1.60, 1.20, 0.00, 0.00};
        this.moduleCode = moduleCode;
        this.date = date;
        resultsList = new HashMap<>();
        gdb = new GradingDatabase();
        gdb.loadFromFile();
    }

    /**
     * Construct a Gradebook and sets the result to an "I" grade for an specific student identified by their ID.
     *
     * @param testName The ID of the student.
     */
    public Gradebook(String testName) {
        setIGrade(testName);
    }

    /**
     * Store examination results for all students in the Gradebook to the database.
     */
    public void storeExamination() {
        for (Map.Entry<String, Double> set : resultsList.entrySet()) {
            gdb.storeResult(set.getKey(), date, moduleCode, getGrade(set.getValue()), getScore(set.getValue()));
        }
        gdb.saveToFile();
    }

    /**
     * Retrieve the corresponding grade for a given result based on percentage cutoff values.
     *
     * @param result The result obtained by a student in an exam
     * @return The grade corresponding to the given result.
     */
    public String getGrade(double result) {
        for (int i = 0; i < Grades.length; i++) {
            if (result >= PercentageCutOff[i]) {
                return Grades[i];
            }
        }
        return "NG";
    }

    /**
     * Add a student's examination result to the Gradebook.
     *
     * @param id     The ID of the student.
     * @param result The result obtained by the student in an exam.
     */
    public void addStudentResult(String id, double result) {
        resultsList.put(id, result);
    }

    private double getScore(double result) {
        for (int i = 0; i < Score.length; i++) {
            if (result >= PercentageCutOff[i]) {
                return Score[i];
            }
        }
        return 0.00;
    }

    /**
     * Set the result for an specific student identified by their ID.
     *
     * @param ID     The student's ID.
     * @param result The result obtained by the student in an exam.
     */
    public void setResult(String ID, double result) {
        this.resultsList.put(ID, result);
    }

    /**
     * Delete all stored results in the Gradebook.
     */
    public void delete() {
        this.resultsList = new HashMap<>();
    }

    /**
     * Delete an specific student's data for an exam.
     *
     * @param ID A student's ID.
     */
    public void delete(String ID) {
        this.resultsList.remove(ID);
    }

    /**
     * Get the result for an specific student identified by their ID.
     *
     * @param ID A student's ID.
     * @return The result obtained by the specified student.
     */
    public Double getResult(String ID) {
        return this.resultsList.get(ID);
    }

    /**
     * Get a map with all stored results, where each entry represents an student and their result.
     *
     * @return A map containing all stored results.
     */
    public HashMap<String, Double> getResults(Double value) {
        return resultsList;
    }

    /**
     * Set the result to an "I" grade for an specific student identified by their ID.
     *
     * @param ID The student's ID.
     */
    public void setIGrade(String ID) {
        this.resultsList.put(ID, -2.0);
    }

}