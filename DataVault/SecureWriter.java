package DataVault;
import java.io.FileWriter;
import java.io.IOException;

public class SecureWriter {
    public void writeData(String data) throws VaultException {
        // Tests Try-With-Resources
        try (FileWriter writer = new FileWriter(VaultConstants.FILE_NAME)) {
            writer.write("KEY:" + VaultConstants.DEFAULT_KEY + "|" + data);
        } catch (IOException e) {
            throw new VaultException("Failed to write to vault");
        }
    }
}