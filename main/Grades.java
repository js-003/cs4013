import java.util.HashMap;

/**
 * This class is for storing class results for a single test/exam.
 *
 */
public class Grades {
    // Store results for each student
    private HashMap<String, Integer> results;

    // Maximum possible result for an exam.
    private Integer maxResult;

    /**
     * Initiate an empty results map and setting the maximum result to 0
     */
    public Grades() {
        this.results = new HashMap<>();
        this.maxResult = 0;
    }

    /**
     * Allow the specification of the maximum possible result for an exam.
     *
     * @param maxResult The maximum possible result for an exam.
     */
    public Grades(Integer maxResult) {
        this.results = new HashMap<>();
        this.maxResult = maxResult;
    }

    /**
     * Set the maximum possible result for an exam
     *
     * @param maxResult The maximum possible result for an exam.
     */
    public void setMaxResult(Integer maxResult) {
        this.maxResult = maxResult;
    }

    /**
     * Set the result for an specific student identified by their ID.
     *
     * @param ID      The student's ID.
     * @param result  The result obtained by the student in an exam.
     */
    public void setResult(String ID, Integer result) {
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
    public Integer getResult(String ID) {
        return this.results.get(ID);
    }

    /**
     * Get the maximum possible result for an exam
     *
     * @return The maximum possible result for an exam
     */
    public Integer getMaxResult() {
        return this.maxResult;
    }

    /**
     * Get a map with all stored results, where each entry represents a student and their result
     *
     * @return A map containing all stored results.
     */
    public HashMap<String, Integer> getResults() {
        return results;
    }
}
