package DataVault;

public class VaultApp {
    public static void main(String[] args) {
        SecureWriter sw = new SecureWriter();
        try {
            sw.writeData("TopSecretData");
            System.out.println("Data vault updated.");
        } catch (VaultException e) {
            System.err.println(e.getMessage());
        }
    }
}