package practice.designpatterns.decorator.iphone;

/**
 * "Decorator"에 해당하는 추상 클래스. "Component"인 Phone을 상속받는다.
 * "Component"의 내용을 따르지만 행동은 다르게 한다.
 *
 * @version     1.0 06 Jul 2018
 * @author      Seokgyu Hwang
 */
public abstract class OS extends Phone {
    /**
     * 여기서는 기기에서 이용 가능한 OS의 이름을 덧붙인다.
     * @return 이용 가능한 OS
     */
    public abstract String getDeviceOs();
}
