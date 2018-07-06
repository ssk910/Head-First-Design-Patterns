package practice.designpatterns.decorator.iphone;

/**
 * "Concrete Component"에 해당하는 클래스. "Component"인 Phone을 상속받는다.
 * 이 객체에서 새로운 행동이 추가적으로 덧붙여진다.
 * iPhone 6를 나타낸다.
 *
 * @version     1.0 06 Jul 2018
 * @author      Seokgyu Hwang
 */
public class PhoneSix extends Phone {
    /**
     * 생성자에서 기기의 이름을 초기화한다.
     */
    public PhoneSix() {
        deviceOsName = "iPhone 6";
    }

    /**
     * 기기에 탑재된 칩을 리턴
     * @return 칩
     */
    @Override
    public String arrangeChipAndFeatures() {
        return "Apple A8 chip";
    }
}
