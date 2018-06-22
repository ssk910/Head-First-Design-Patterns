package practice.designpatterns.abstractfactory;

public class LaptopDevice extends Device {
    ModuleFactory module;

    public LaptopDevice(ModuleFactory module) {
        this.module = module;
    }

    @Override
    void prepare() {
        System.out.println("preparing " + name);
        graphic = module.createGraphic();
        wifi = module.createWIFI();
    }
}
