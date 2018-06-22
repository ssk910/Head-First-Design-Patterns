package practice.designpatterns.abstractfactory;

public class TestPattern {
    public static void main(String[] args) {
        Agency samsungDeviceAgency = new SamsungDeviceAgency();
        Agency appleDeviceAgency = new AppleDeviceAgency();
        Agency lgDeviceAgency = new LGDeviceAgency();
        Device device;

        /* Samsung Device */
        device = samsungDeviceAgency.orderDevice("tablet");
        System.out.println("person1 ordered a " + device + "\n");
        device = samsungDeviceAgency.orderDevice("mobile");
        System.out.println("person2 ordered a " + device + "\n");
        device = samsungDeviceAgency.orderDevice("laptop");
        System.out.println("person3 ordered a " + device + "\n");

        /* Apple Device */
        device = appleDeviceAgency.orderDevice("tablet");
        System.out.println("person1 ordered a " + device + "\n");
        device = appleDeviceAgency.orderDevice("mobile");
        System.out.println("person2 ordered a " + device + "\n");
        device = appleDeviceAgency.orderDevice("laptop");
        System.out.println("person3 ordered a " + device + "\n");

        /* LG Device */
        device = lgDeviceAgency.orderDevice("tablet");
        System.out.println("person1 ordered a " + device + "\n");
        device = lgDeviceAgency.orderDevice("mobile");
        System.out.println("person2 ordered a " + device + "\n");
        device = lgDeviceAgency.orderDevice("laptop");
        System.out.println("person3 ordered a " + device + "\n");
    }
}
