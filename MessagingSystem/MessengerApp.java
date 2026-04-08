package MessagingSystem;

public class MessengerApp {
    public static void main(String[] args) {
        Message<String> textMsg = new Message<>("hello world");
        ConsoleProcessor proc = new ConsoleProcessor();
        proc.process(textMsg);
    }
}