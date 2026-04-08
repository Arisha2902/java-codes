package MessagingSystem;

public class Message<T> {
    private T content;

    public Message(T content) {
        this.content = content;
    }

    public T getContent() { return content; }
}