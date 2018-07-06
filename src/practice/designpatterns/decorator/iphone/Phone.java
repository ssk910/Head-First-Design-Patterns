package practice.designpatterns.decorator.iphone;

/**
 * "Component"에 해당하는 추상 클래스.
 * 추가되거나 수정되는 해동을 갖고 있는 객체를 위한 추상 클래스이다.
 *
 * @version     1.0 06 Jul 2018
 * @author      Seokgyu Hwang
 */
abstract class Phone {
    String deviceOsName = "unknown";

    /**
     * 해당 기기와 기기에서 이용 가능한 OS의 이름을 리턴한다.
     * @return 기기, OS 이름
     */
    public String getDeviceOs() {
        return deviceOsName;
    }

    /**
     * 기기에 탑재된 칩과 OS의 기능들을 나열한다
     * @return 칩, OS의 기능
     */
    public abstract String arrangeChipAndFeatures();
}
