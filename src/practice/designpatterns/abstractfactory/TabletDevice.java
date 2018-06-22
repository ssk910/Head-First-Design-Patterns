package practice.designpatterns.abstractfactory;

public class TabletDevice extends Device {
    ModuleFactory module;

    public TabletDevice(ModuleFactory module) {
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
