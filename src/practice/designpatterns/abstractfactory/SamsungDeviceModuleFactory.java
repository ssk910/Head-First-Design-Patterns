package practice.designpatterns.abstractfactory;

public class SamsungDeviceModuleFactory implements ModuleFactory {
    @Override
    public Graphic createGraphic() {
        return new IntelGraphic();
    }

    @Override
    public GPS createGPS() {
        return new MotololaGPS();
    }

    @Override
    public WIFI createWIFI() {
        return new QualcommWIFI();
    }
}