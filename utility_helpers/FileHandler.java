import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private String fileName;
    private List<String> content;

    public FileHandler(String fileName) {
        this.fileName = fileName;
        this.content = new ArrayList<>();
    }

    public void addLine(String line) {
        if (line != null) {
            content.add(line);
        }
    }

    public List<String> getLines() {
        return new ArrayList<>(content);
    }

    public int getLineCount() {
        return content.size();
    }

    public void clear() {
        content.clear();
    }

    public String getFileName() {
        return fileName;
    }
}
