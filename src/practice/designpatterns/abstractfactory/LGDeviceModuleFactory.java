package practice.designpatterns.abstractfactory;

public class LGDeviceModuleFactory implements ModuleFactory {
    @Override
    public Graphic createGraphic() {
        return new IntelGraphic();
    }

    @Override
    public GPS createGPS() {
        return new SiRFGPS();
    }

    @Override
    public WIFI createWIFI() {
        return new BroadcomWIFI();
    }
}