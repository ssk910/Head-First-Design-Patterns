package practice.designpatterns.factorymethod.ImageReaderNew;

/**
 * "Concrete Product"에 해당하는 클래스. "Product"인 DecodedImage 클래스를 상속받는다.
 * "Concrete Product"는 "Creator"의 메소드에 의해 사용된다.
 * "Product"의 내용을 구현하는 역할이지만, 이 예제에서는 생성자로 "Product"의 멤버 필드를 초기화한다.
 * PNG 포맷에 해당한다.
 *
 * @version     1.0 06 Jul 2018
 * @author      Seokgyu Hwang
 */
public class PNGDecodedImage extends DecodedImage {
    public PNGDecodedImage(String imageFile) {
        this.imageFile = imageFile;
        this.format = "png";
    }
}
