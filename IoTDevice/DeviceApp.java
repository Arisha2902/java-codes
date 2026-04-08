package IoTDevice;

public class DeviceApp {
    public static void main(String[] args) {
        SmartController controller = new SmartController();
        controller.updateTemperature(45);
        System.out.println(controller.getReport());
        
        controller.updateTemperature(150); // Triggers Error State
        System.out.println("Alert: " + controller.getReport());
    }
}