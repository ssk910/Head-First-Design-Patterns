package practice.designpatterns.abstractfactory;

public class AppleDeviceAgency extends Agency {
    @Override
    protected Device createDevice(String item) {
        Device device = null;
        ModuleFactory module = new AppleDeviceModuleFactory();

        if (item.equals("tablet")) {
            device = new TabletDevice(module);
            device.setName("Apple's Tablet Device");
        } else if (item.equals("mobile")) {
            device = new MobileDevice(module);
            device.setName("Apple's Mobile Device");
        } else if (item.equals("laptop")) {
            device = new LaptopDevice(module);
            device.setName("Apple's Laptop Device");
        }

        return device;
    }
}
