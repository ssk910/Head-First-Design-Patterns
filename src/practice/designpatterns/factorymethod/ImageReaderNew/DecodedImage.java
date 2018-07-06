package practice.designpatterns.factorymethod.ImageReaderNew;

/**
 * "Product"에 해당하는 추상 클래스.
 * "Creator"가 이 클래스를 통해 "Concrete Product"에 접근할 수 있다.
 *
 * @version     1.0 06 Jul 2018
 * @author      Seokgyu Hwang
 */
abstract class DecodedImage {
    String imageFile;   // 이미지 파일
    String format;      // 이미지 파일의 포맷

    /**
     * 여기서 디코드 작업을 수행하지만, 이 예제는 과정을 표현하는 예제이다.
     */
    public void decode() {
        System.out.println("decoded imageFile\t: [" + imageFile + "]");
        System.out.println("imageFile format\t: [" + format + "]");
        System.out.println("---------------------------------");
    }
}
