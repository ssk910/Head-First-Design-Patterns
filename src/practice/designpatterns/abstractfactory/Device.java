package practice.designpatterns.abstractfactory;

public abstract class Device {
    String name;
    Graphic graphic;
    GPS gps;
    WIFI wifi;

    abstract void prepare();

    void assemble() {
        System.out.println("assembling the device.");
    }

    void box() {
        System.out.println("boxing assembled device.");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(name);
        result.append("\nmodules included : \n");

        if (graphic != null) {
            result.append(graphic);
            result.append("\n");
        }

        if (gps != null) {
            result.append(gps);
            result.append("\n");
        }

        if (wifi != null) {
            result.append(wifi);
            result.append("\n");
        }

        return result.toString();
    }
}