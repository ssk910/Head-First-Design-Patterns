package practice.designpatterns.abstractfactory;

public class AppleDeviceModuleFactory implements ModuleFactory {
    @Override
    public Graphic createGraphic() {
        return new SnapdragonGraphic();
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
