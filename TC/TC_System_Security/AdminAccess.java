public class AdminAccess extends AbstractAccess {
    public AdminAccess() { super(10); }
    public boolean isGranted() { return level >= 10; }
}