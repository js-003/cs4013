import java.util.HashMap;
import java.util.Map;

/**
 * @author Irene
 * The Gradebook class represents a grading system for an specific module and date.
 * It extends the GradingDatabase class to store student results.
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
     * Constructor for creating a Gradebook with grade details.
     *
     * @param moduleCode       The code of the module for which the gradebook is created.
     * @param date             The date associated with the grading results.
     * @param grades           Array of grade labels
     * @param percentageCutOff Array of percentage cutoffs corresponding to each grade.
     * @param score            Array of scores corresponding to each grade.
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
     * Constructor for creating a Gradebook with default grade details.
     *
     * @param moduleCode The code of the module.
     * @param date       The date associated with the grading results.
     */
    public Gradebook(String moduleCode, String date) {
        this.Grades = new String[]{"A1", "A2", "B1", "B2", "B3", "C1", "C2", "C3", "D1", "D2", "F"};
        this.PercentageCutOff = new double[]{80, 72, 64, 60, 56, 52, 48, 40, 35, 30, 0};
        this.Score = new double[]{4.00, 3.60, 3.20, 3.00, 2.80, 2.60, 2.40, 2.00, 1.60, 1.20, 0.00};
        this.moduleCode = moduleCode;
        this.date = date;
        resultsList = new HashMap<>();
        gdb = new GradingDatabase();
        gdb.loadFromFile();
    }

    /**
     * Store examination results in the grading database.
     * Go over resultsList again and store each result in the database.
     */
    public void storeExamination() {
        for (Map.Entry<String, Double> set : resultsList.entrySet()) {
            gdb.storeResult(set.getKey(), date, moduleCode, getGrade(set.getValue()), getScore(set.getValue()));
        }
        gdb.saveToFile();
    }

    /**
     * Add a student result to the resultsList.
     *
     * @param id     The student ID.
     * @param result The result obtained by the student.
     */
    public void addStudentResult(String id, double result) {
        resultsList.put(id, result);
    }

    /**
     * Retrieve the corresponding grade for a given result percentage.
     *
     * @param result The result percentage of a student.
     * @return The grade associated with the result percentage.
     */
    private String getGrade(double result) {
        for (int i = 0; i < Grades.length; i++) {
            if (result >= PercentageCutOff[i]) {
                return Grades[i];
            }
        }
        return "NG";
    }

    /**
     * Retrieve the corresponding score for a given result percentage.
     *
     * @param result The result percentage of a student.
     * @return The score associated with the result percentage.
     */
    private double getScore(double result) {
        for (int i = 0; i < Score.length; i++) {
            if (result >= PercentageCutOff[i]) {
                return Score[i];
            }
        }
        return 0.00;
    }
}