package LibrarySystem;

public class DVD extends LibraryItem {
    private int durationMinutes;

    public DVD(String id, String title, int durationMinutes) {
        super(id, title);
        this.durationMinutes = durationMinutes;
    }

    @Override
    public void displayDetails() {
        System.out.println("[DVD] ID: " + id + " | Title: " + title + " | Duration: " + durationMinutes + " mins");
    }
}