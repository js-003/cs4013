import java.util.HashMap;
import java.util.Map;

public class Gradebook extends GradingDatabase {
    private String[] Grades;
    private double[] PercentageCutOff;
    private double[] Score;
    private HashMap<String, Double> resultsList;

    private String moduleCode;

    private String date;

    private GradingDatabase gdb;

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

    public Gradebook(String moduleCode, String date) {
        this.Grades = new String[] {"A1", "A2", "B1", "B2", "B3", "C1", "C2", "C3", "D1", "D2", "F", "NG", "I"};
        this.PercentageCutOff = new double[] {80, 72, 64, 60, 56, 52, 48, 40, 35, 30, 0, -1, -2};
        this.Score = new double[] {4.00, 3.60, 3.20, 3.00, 2.80, 2.60, 2.40, 2.00, 1.60, 1.20, 0.00, 0.00};
        this.moduleCode = moduleCode;
        this.date = date;
        resultsList = new HashMap<>();
        gdb = new GradingDatabase();
        gdb.loadFromFile();
    }

    public void storeExamination() {
        for (Map.Entry<String, Double> set : resultsList.entrySet()) {
            gdb.storeResult(set.getKey(), date, moduleCode, getGrade(set.getValue()), getScore(set.getValue()));
        }
        gdb.saveToFile();
    }

    public String getGrade(double result) {
        for (int i = 0; i < Grades.length; i++) {
            if (result >= PercentageCutOff[i]) {
                return Grades[i];
            }
        }
        return "NG";
    }

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
     * Set the result for a specific student identified by their ID.
     *
     * @param ID     The student's ID.
     * @param result The result obtained by the student in an exam.
     */
    public void setResult(String ID, double result) {
        this.resultsList.put(ID, result);
    }

    /**
     * Delete all stored results.
     */
    public void delete() {
        this.resultsList = new HashMap<>();
    }

    /**
     * Delete a student's data for an exam.
     *
     * @param ID A student's ID
     */
    public void delete(String ID) {
        this.resultsList.remove(ID);
    }

    /**
     * Get a student's data for an exam.
     *
     * @param ID A student's ID
     */

    public Double getResult(String ID) {
        return this.resultsList.get(ID);
    }

    /**
     * Get a map with all stored results, where each entry represents a student and their result
     *
     * @return A map containing all stored results.
     */

    public HashMap<String, Double> getResults(Double value) {
        return resultsList;
    }

    public void setIGrade(String ID) {
        this.resultsList.put(ID, -2.0);
    }
    public Gradebook(String testName){
        setIGrade(testName);
    }
}