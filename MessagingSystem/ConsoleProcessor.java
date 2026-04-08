

package MessagingSystem;

public class ConsoleProcessor implements MessageProcessor {
    @Override
    public void process(Message<String> msg) {
        System.out.println("Processing: " + msg.getContent().toUpperCase());
    }
}