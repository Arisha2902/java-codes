package IoTDevice;

public class SmartController {
    private DeviceStatus status = DeviceStatus.OFFLINE;
    private int temperature = 25;
    private DeviceConfiguration config = new DeviceConfiguration();

    public void updateTemperature(int newTemp) {
        if (newTemp > config.maxTemperature) {
            this.status = DeviceStatus.ERROR;
        } else {
            this.temperature = newTemp;
            this.status = DeviceStatus.BUSY;
        }
    }

    public String getReport() {
        return "Status: " + status + " | Temp: " + temperature + "°C";
    }
}