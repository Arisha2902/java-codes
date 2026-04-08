import java.util.ArrayList;
import java.util.List;

public class DataFilter {

    public static List<Integer> filterEven(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        if (numbers == null) return result;
        for (int num : numbers) {
            if (num % 2 == 0) {
                result.add(num);
            }
        }
        return result;
    }

    public static List<Integer> filterOdd(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        if (numbers == null) return result;
        for (int num : numbers) {
            if (num % 2 != 0) {
                result.add(num);
            }
        }
        return result;
    }

    public static List<Double> filterInRange(List<Double> numbers, double min, double max) {
        List<Double> result = new ArrayList<>();
        if (numbers == null) return result;
        for (double num : numbers) {
            if (num >= min && num <= max) {
                result.add(num);
            }
        }
        return result;
    }
}
