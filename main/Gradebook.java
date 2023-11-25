import java.util.HashMap;

public class Gradebook {
    private final HashMap<String, Grades> grades;

    public Gradebook() {
        this.grades = new HashMap<>();
    }

    public void addGrade(String test, Grades results) {
        this.grades.put(test, results);
    }

    public Double getAverage(String test) {
        Integer total = 0;
        Grades results = grades.get(test);
        for(Integer grade : results.getResults().values()) {
            total += grade;
        }
        return (double) (total/results.getResults().values().size());
    }

    public Double getClassAverage() {
        Double total = 0.0;
        for(String test : this.grades.keySet()) {
            total += this.getAverage(test);
        }
        return (total/this.grades.values().size());
    }

    public Double getStudentAverage(String ID) {
        Integer total = 0;
        for(String test : this.grades.keySet()) {
            total += this.grades.get(test).getResult(ID);
        }
        return (double) (total/this.grades.values().size());
    }

    public GradeType getStudentGrade(String ID) {
        Double average = getStudentAverage(ID);
        if (average > 80) {
            return GradeType.A1;
        }
        if (average > 72) {
            return GradeType.A2;
        }
        if (average > 64) {
            return GradeType.B1;
        }
        if (average > 60) {
            return GradeType.B2;
        }
        if (average > 56) {
            return GradeType.B3;
        }
        if (average > 52) {
            return GradeType.C1;
        }
        if (average > 48) {
            return GradeType.C2;
        }
        if (average > 40) {
            return GradeType.C3;
        }
        if (average > 35) {
            return GradeType.D1;
        }
        if (average > 30) {
            return GradeType.D2;
        }
        if (average > 0) {
            return GradeType.F;
        }
        return GradeType.NG;
    }

}
