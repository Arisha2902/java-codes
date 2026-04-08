package MessagingSystem;

public interface MessageProcessor {
    void process(Message<String> msg);
}