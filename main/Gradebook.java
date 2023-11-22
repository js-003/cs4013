import java.util.HashMap;

public class Gradebook {
    private final HashMap<String, Grades> grades = new HashMap<>();

    public void addGrade(String test, Grades results) {
        this.grades.put(test, results);
    }

    public Double getAverage(String test) {
        Integer total = 0;
        Grades results = grades.get(test);
        for (Integer grade : results.getResults().values()) {
            total += grade;
        }
        return (double) (total / results.getResults().values().size());
    }

    public Double getClassAverage() {
        Double total = 0.0;
        for (String test : this.grades.keySet()) {
            total += this.getAverage(test);
        }
        return (total / this.grades.values().size());
    }

    public Double getStudentAverage(String ID) {
        Integer total = 0;
        for (String test : this.grades.keySet()) {
            total += this.grades.get(test).getResult(ID);
        }
        return (double) (total / this.grades.values().size());
    }
}
