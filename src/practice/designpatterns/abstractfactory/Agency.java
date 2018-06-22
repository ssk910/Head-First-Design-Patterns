package practice.designpatterns.abstractfactory;

public abstract class Agency {
    protected abstract Device createDevice(String item);

    public Device orderDevice(String type) {
        Device device = createDevice(type);
        System.out.println("--- Manufacturing a " + device.getName() + " ---");
        device.prepare();
        device.assemble();
        device.box();

        return device;
    }
}
