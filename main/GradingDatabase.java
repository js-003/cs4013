import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.io.*;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * GradingDatabase represents a simple database for storing student grades.
 * The functionality is to store, remove, load, and save student grades for different modules
 */
public class GradingDatabase {
    // HashMap to store student grades indexed by student ID
    private HashMap<String, ArrayList<ArrayList<Object>>> module_grades;

    // File name for storing and loading data
    private final String file_name = "StudentGradingDB.csv";

    /**
     * Constructor for GradingDatabase class. Initialises the module_grades HashMap.
     */
    protected GradingDatabase() {
        module_grades = new HashMap<>();
        loadFromFile();
    }

    /**
     * Store the result of a student for a specific module.
     *
     * @param id         The student ID.
     * @param date       The date results come out.
     * @param moduleCode The code of the module.
     * @param grade      The grade achieved by the student.
     * @param score      The score obtained by the student.
     */
    protected void storeResult(String id, String date, String moduleCode, String grade, double score) {
        ArrayList<Object> gradeDetails = new ArrayList<>(Arrays.asList(moduleCode, date, grade, score));
        module_grades.computeIfAbsent(id, k -> new ArrayList<>()).add(gradeDetails);
    }

    /**
     * Remove the result of a student for a specific module and date.
     *
     * @param id         The student ID.
     * @param moduleCode The code of the module.
     * @param date       The date results come out.
     * @return true if the result is successfully removed, false if not.
     */
    public boolean removeResult(String id, String moduleCode, String date) {
        if (!module_grades.containsKey(id)) {
            System.out.println("Student ID not found.");
            return false;
        }

        ArrayList<ArrayList<Object>> gradesList = module_grades.get(id);
        for (ArrayList<Object> gradeInfo : gradesList) {
            if (gradeInfo.get(0).equals(moduleCode) && gradeInfo.get(1).equals(date)) {
                gradesList.remove(gradeInfo);
                System.out.println("Result removed for module " + moduleCode + " on date " + date);
                return true;
            }
        }

        System.out.println("Result not found for given module and date.");
        return false;
    }

    /**
     * Load student grades from a CSV file and populate the module_grades HashMap
     */
    protected void loadFromFile() {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file_name))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                String id = row[0];
                ArrayList<ArrayList<Object>> gradesList = new ArrayList<>();

                for (int i = 1; i < row.length; i += 4) {
                    String moduleCode = row[i];
                    String date = row[i + 1];
                    String grade = row[i + 2];
                    double score = Double.parseDouble(row[i + 3]);
                    ArrayList<Object> gradeInfo = new ArrayList<>(Arrays.asList(moduleCode, date, grade, score));
                    gradesList.add(gradeInfo);
                }

                module_grades.put(id, gradesList);
            }
        } catch (IOException e) {
            System.out.println("Error reading from the file: " + e.getMessage());
        }
    }

    /**
     * Save the current student grades to a CSV file.
     * Write the student grades stored in the module_grades HashMap to the specified CSV file.
     * The CSV file format includes student ID, module code, date, grade, and score.
     * Display a success message if it is successful, or an error message if it fails.
     */
    protected void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file_name)))) {
            for (Map.Entry<String, ArrayList<ArrayList<Object>>> entry : module_grades.entrySet()) {
                StringBuilder csvLine = new StringBuilder(entry.getKey());
                for (ArrayList<Object> gradeInfo : entry.getValue()) {
                    csvLine.append(",").append(String.join(",", gradeInfo.stream().map(Object::toString).collect(Collectors.toList())));
                }
                writer.println(csvLine);
            }
            System.out.println("Data saved to " + file_name);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Retrieve the grades of an specific student.
     *
     * @param id The student ID for which grades are needed to get back.
     * @return ArrayList of ArrayLists representing the grades of the specified student.
     * Each inner ArrayList contains module code, date, grade, and score for an specific module.
     * Returns null if the student ID is not found.
     */
    public ArrayList<ArrayList<Object>> getGrades(String id) {
        return module_grades.get(id);
    }
}