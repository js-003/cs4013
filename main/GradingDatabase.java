import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.io.*;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The GradingDatabase class represents a database for storing student grading information.
 */
public class GradingDatabase {
    private HashMap<String, ArrayList<ArrayList<Object>>> module_grades;

    private final String file_name = "StudentGradingDB.csv";

    /**
     * Constructor for the GradingDatabase class.
     * Initialise the module_grades HashMap and load data from the file
     */
    public GradingDatabase() {
        module_grades = new HashMap<>();
        loadFromFile();
    }

    /**
     * Store an student's grading result in the database.
     *
     * @param id         The student ID.
     * @param date       The date of the grading result
     * @param moduleCode The code of the module where the result is stored.
     * @param grade      The grade obtained by the student.
     * @param score      The corresponding score of the grade.
     */
    protected void storeResult(String id, String date, String moduleCode, String grade, double score) {
        ArrayList<Object> gradeDetails = new ArrayList<>(Arrays.asList(moduleCode, date, grade, score));
        module_grades.computeIfAbsent(id, k -> new ArrayList<>()).add(gradeDetails);
    }

    /**
     * Remove an specific grading result for a student based on module code and date.
     *
     * @param id         The student ID.
     * @param moduleCode The code of the module where the result is to be removed.
     * @param date       The date of the grading result to be removed.
     * @return True if the result is successfully removed, false if it is not.
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
     * Load grading information from the specified file into the database.
     */
    public void loadFromFile() {
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
     * Save the current grading information in the database to the specified file.
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
     * Retrieve the list of grading details for an specific student.
     *
     * @param id The student ID.
     * @return ArrayList of grading details for an specific student.
     */
    public ArrayList<ArrayList<Object>> getGrades(String id) {
        return module_grades.get(id);
    }
}
