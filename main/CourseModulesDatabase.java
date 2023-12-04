import java.io.*;
import java.util.*;

/**
 * COurse Module DB allows for storing modules in courses where each semester is an array of the modules
 */
public class CourseModulesDatabase {
    private String courseCode;
    private String moduleCode;
    private final String FILENAME = "CourseModuleDB.csv";

    private HashMap<String, ArrayList<ArrayList<String>>> myMap;

    private CourseDatabase courseDB;
    private ModuleDatabase moduleDB;
    public CourseModulesDatabase() {
        myMap = new HashMap<>();
        courseDB = new CourseDatabase();
        courseDB.loadFromFile();
        moduleDB = new ModuleDatabase();
        moduleDB.loadFromFile();
        loadFromFile();
    }

    /**
     * Saves the treemap into the csv for storage and reuse
     */
    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(FILENAME))) {
            for (Map.Entry<String, ArrayList<ArrayList<String>>> entry : myMap.entrySet()) {
                String courseCode = entry.getKey();
                ArrayList<ArrayList<String>> semesters = entry.getValue();
                List<String> semesterStrings = new ArrayList<>();

                for (ArrayList<String> semester : semesters) {
                    String joinedModules = String.join(";", semester);
                    semesterStrings.add(joinedModules);
                }

                String line = courseCode + "," + String.join("|", semesterStrings);
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a storage of the modules in a given course per semester
     * @param courseCode The param is used as a key in terms of hashmaps
     * @param numberOfSemesters Allocates the semesters for the module storage
     */
    public void addCourse(String courseCode, int numberOfSemesters) {
        if (!courseDB.getUniqueIdentifier().contains(courseCode)) {
            System.out.println("Course has not been created");
            return;
        }

        if (myMap.containsKey(courseCode)) {
            System.out.println("Course already exists.");
            return;
        }

        // Initialize an empty structure for the new course with specified number of semesters
        ArrayList<ArrayList<String>> semesters = new ArrayList<>();
        for (int i = 0; i < numberOfSemesters; i++) {
            semesters.add(new ArrayList<>()); // Add an empty list for each semester
        }

        myMap.put(courseCode, semesters);
        System.out.println("Course added with " + numberOfSemesters + " semesters: " + courseCode);
    }

    /**
     * The CSV is read and the information is stored as a treemap
     */
    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2);
                String courseCode = parts[0];
                String[] semesterData = parts[1].split("\\|");

                ArrayList<ArrayList<String>> semesters = new ArrayList<>();
                for (String semester : semesterData) {
                    ArrayList<String> modules = new ArrayList<>(Arrays.asList(semester.split(";")));
                    semesters.add(modules);
                }

                myMap.put(courseCode, semesters);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Stores a given modules in a semester which in turn is stored by the course code key value
     * @param courseCode
     * @param semesterIndex
     * @param moduleCode
     */
    public void createModule(String courseCode, int semesterIndex, String moduleCode) {
        if(!moduleDB.getUniqueIdentifier().contains(moduleCode)){
            System.out.println("Module has not been created");
        }

        if (!myMap.containsKey(courseCode)) {
            System.out.println("Course code not found.");
            return;
        }

        ArrayList<ArrayList<String>> semesters = myMap.get(courseCode);
        if (semesterIndex-1>= semesters.size()) {
            System.out.println("Invalid semester index.");
            return;
        }

        ArrayList<String> modules = semesters.get(semesterIndex-1);
        if (modules.contains(moduleCode)) {
            System.out.println("Module already exists in the semester.");
            return;
        }

        modules.add(moduleCode);
    }

    /**
     * originally planned for the removal of the given modules for a course if reworking is required
     * @param courseCode
     * @param semesterIndex
     * @param moduleCode
     */
    public void removeModule(String courseCode, int semesterIndex, String moduleCode) {
        if (!myMap.containsKey(courseCode)) {
            System.out.println("Course code not found.");
            return;
        }

        ArrayList<ArrayList<String>> semesters = myMap.get(courseCode);
        if (semesterIndex -1>= semesters.size()) {
            System.out.println("Invalid semester index.");
            return;
        }

        ArrayList<String> modules = semesters.get(semesterIndex-1);
        if (!modules.contains(moduleCode)) {
            System.out.println("Module not found in the semester.");
            return;
        }

        modules.remove(moduleCode);

    }

    /**
     * The list of semester that hold the modules that are stored in a map with the course key
     * @param courseCode    The two letter and 3 number id like reference
     * @return Arraylist of ArrayLists of type String
     */
    public ArrayList<ArrayList<String>> getModules(String courseCode){
        return myMap.get(courseCode);
    }
}