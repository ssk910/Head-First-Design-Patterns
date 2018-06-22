package practice.designpatterns.abstractfactory;

public class MobileDevice extends Device {
    ModuleFactory module;

    public MobileDevice(ModuleFactory module) {
        this.module = module;
    }

    @Override
    void prepare() {
        System.out.println("preparing " + name);
        graphic = module.createGraphic();
        gps = module.createGPS();
        wifi = module.createWIFI();
    }
}