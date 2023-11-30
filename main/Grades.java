import java.util.HashMap;

/**
 * This class is for storing class results for a single test/exam.
 */
public class Grades {
    // Store results for each student
    private HashMap<String, Double> results;


    public Grades() {
        this.results = new HashMap<>();
    }


    public Grades(String testName, double parseDouble) {
        setResult(testName, parseDouble);
    }


    /**
     * Set the result for an specific student identified by their ID.
     *
     * @param ID     The student's ID.
     * @param result The result obtained by the student in an exam.
     */
    public void setResult(String ID, double result) {
        this.results.put(ID, result);
    }

    /**
     * Delete all stored results.
     */
    public void delete() {
        this.results = new HashMap<>();
    }

    /**
     * Delete a student's data for an exam.
     *
     * @param ID A student's ID
     */
    public void delete(String ID) {
        this.results.remove(ID);
    }

    /**
     * Get a student's data for an exam.
     *
     * @param ID A student's ID
     */
    public Double getResult(String ID) {
        return this.results.get(ID);
    }

    /**
     * Get a map with all stored results, where each entry represents a student and their result
     *
     * @return A map containing all stored results.
     */
    public HashMap<String, Double> getResults() {
        return results;
    }

    public Double setIGrade() {
        return 0.0;
    }
}


