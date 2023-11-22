import java.util.HashMap;

public class Grades {
    private HashMap<String, Integer> results = new HashMap<>();
    private Integer maxResult = 0;

    public void setMaxResult(Integer maxResult) {
        this.maxResult = maxResult;
    }

    public void setResult(String ID, Integer result) {
        this.results.put(ID, result);
    }

    public void delete() {
        this.results = new HashMap<>();
    }

    public void delete(String ID) {
        this.results.remove(ID);
    }

    public Integer getResult(String ID) {
        return this.results.get(ID);
    }

    public Integer getMaxResult() {
        return this.maxResult;
    }

    public HashMap<String, Integer> getResults() {
        return results;
    }
}

