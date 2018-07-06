package practice.designpatterns.decorator.iphone;

/**
 * "Concrete Decorator"에 해당하는 추상 클래스. "Decorator"인 OS를 상속받는다.
 * "Decorator" 확장을 통해 추가적은 행동을 정의한다.
 * iOS 6를 나타낸다.
 *
 * @version     1.0 06 Jul 2018
 * @author      Seokgyu Hwang
 */
public class OSSix extends OS {
    /* OS가 적용되는 기기 */
    Phone phone;

    public OSSix(Phone phone) {
        this.phone = phone;
    }

    /**
     * 기기에 이용 가능한 OS를 추가한다.
     * @return 기기의 이름에 OS를 추가한 내용.
     */
    @Override
    public String getDeviceOs() {
        return phone.getDeviceOs() + ", iOS 6";
    }

    /**
     * 기기에 탑재된 칩과 OS의 기능을 추가하여 나열.
     * @return 기기의 칩에 OS 기능을 추가한 내용.
     */
    @Override
    public String arrangeChipAndFeatures() {
        return phone.arrangeChipAndFeatures() + ", FaceTime";
    }
}
