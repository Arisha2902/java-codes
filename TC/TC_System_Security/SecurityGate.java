public class SecurityGate {
    private Permission currentPerm;
    public void setAccess(Permission p) { this.currentPerm = p; }
    public void validate() {
        if (currentPerm != null && currentPerm.isGranted()) {
            System.out.println("Access Authorized");
        }
    }
}