public class UserService {
    private Logger logger;

    public UserService(Logger logger) {
        this.logger = logger;
    }

    public void createUser(String username) {
        logger.log("Creating user: " + username);
        System.out.println("User created: " + username);
    }

    public void deleteUser(String username) {
        
    }
}
