import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class DataAggregator {

    private Map<String, List<Double>> dataGroups;

    public DataAggregator() {
        this.dataGroups = new HashMap<>();
    }

    public void addData(String group, double value) {
        dataGroups.putIfAbsent(group, new ArrayList<>());
        dataGroups.get(group).add(value);
    }

    public double getSum(String group) {
        List<Double> values = dataGroups.get(group);
        if (values == null) return 0;
        return values.stream().mapToDouble(Double::doubleValue).sum();
    }

    public double getAverage(String group) {
        List<Double> values = dataGroups.get(group);
        if (values == null || values.isEmpty()) return 0;
        return getSum(group) / values.size();
    }

    public double getMax(String group) {
        List<Double> values = dataGroups.get(group);
        if (values == null || values.isEmpty()) return 0;
        return values.stream().mapToDouble(Double::doubleValue).max().orElse(0);
    }

    public int getGroupSize(String group) {
        List<Double> values = dataGroups.get(group);
        return values != null ? values.size() : 0;
    }
}
