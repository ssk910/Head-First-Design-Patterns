package practice.designpatterns.abstractfactory;

public class SamsungDeviceAgency extends Agency {
    @Override
    protected Device createDevice(String item) {
        Device device = null;
        ModuleFactory module = new SamsungDeviceModuleFactory();

        if (item.equals("tablet")) {
            device = new TabletDevice(module);
            device.setName("Samsung's Tablet Device");
        } else if (item.equals("mobile")) {
            device = new MobileDevice(module);
            device.setName("Samsung's Mobile Device");
        } else if (item.equals("laptop")) {
            device = new LaptopDevice(module);
            device.setName("Samsung's laptop Device");
        }

        return device;
    }
}