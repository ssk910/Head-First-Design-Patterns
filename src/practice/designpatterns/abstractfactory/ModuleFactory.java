package practice.designpatterns.abstractfactory;

public interface ModuleFactory {
    public Graphic createGraphic();
    public GPS createGPS();
    public WIFI createWIFI();
}