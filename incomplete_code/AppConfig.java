public class AppConfig {
    private String appName;
    private int maxUsers;

    public AppConfig(String appName, int maxUsers) {
        this.appName = appName;
        this.maxUsers = maxUsers;
    }

    public String getAppName() {
        return appName;
    }

    public int getMaxUsers() {
        return maxUsers;
    }
}
