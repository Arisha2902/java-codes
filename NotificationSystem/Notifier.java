
package NotificationSystem;
import java.util.ArrayList;
import java.util.List;

public class Notifier {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) { observers.add(o); }

    public void broadcast(String msg) {
        for (Observer o : observers) { o.update(msg); }
    }

    public static void main(String[] args) {
        Notifier central = new Notifier();
        central.addObserver(new EmailClient("admin@tech.com"));
        central.broadcast("Server Update Successful");
    }
}