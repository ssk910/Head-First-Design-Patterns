package practice.designpatterns.abstractfactory;

public class LGDeviceAgency extends Agency {
    @Override
    protected Device createDevice(String item) {
        Device device = null;
        ModuleFactory module = new LGDeviceModuleFactory();

        if (item.equals("tablet")) {
            device = new TabletDevice(module);
            device.setName("LG's Tablet Device");
        } else if (item.equals("mobile")) {
            device = new MobileDevice(module);
            device.setName("LG's Mobile Device");
        } else if (item.equals("laptop")) {
            device = new LaptopDevice(module);
            device.setName("LG's Laptop Device");
        }

        return device;
    }
}
