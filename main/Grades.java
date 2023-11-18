import java.util.HashMap;

public class Grades {
    private HashMap<String, Integer> results = new HashMap<>();
    private Integer maxResult = 0;

    public void setMaxResult(Integer maxResult) {
        this.maxResult = maxResult;
    }

    public void setResult(String ID, Integer result) {
    }

    public void delete() {

    }

    public void delete(String ID) {

    }

    public Integer getResult(String ID) {
        return 0;
    }

    public Integer getMaxResult() {
        return 0;
    }

    public HashMap<String, Integer> getResults() {
        return results;
    }
}
