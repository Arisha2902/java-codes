import java.util.ArrayList;
import java.util.List;

public class DataSorter {

    public static List<Integer> bubbleSort(List<Integer> list) {
        if (list == null) return new ArrayList<>();
        List<Integer> sorted = new ArrayList<>(list);
        int n = sorted.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sorted.get(j) > sorted.get(j + 1)) {
                    int temp = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, temp);
                }
            }
        }
        return sorted;
    }

    public static List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> merged = new ArrayList<>();
        if (list1 == null) return list2 != null ? new ArrayList<>(list2) : new ArrayList<>();
        if (list2 == null) return new ArrayList<>(list1);

        merged.addAll(list1);
        merged.addAll(list2);
        return bubbleSort(merged);
    }
}
