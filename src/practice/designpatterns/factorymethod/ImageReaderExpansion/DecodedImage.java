package practice.designpatterns.factorymethod.ImageReaderExpansion;

/**
 * "Product"에 해당하는 추상 클래스.
 * "Creator"가 이 클래스를 통해 "Concrete Product"에 접근할 수 있다.
 *
 * @version     1.0 06 Jul 2018
 * @author      Seokgyu Hwang
 */
abstract class DecodedImage {
    byte[] imageInByte;    // 이미지 파일을 디코딩하여 byte 배열로 변환한 결과
    String format;         // 이미지 파일의 포맷

    /**
     * 변환된 byte 배열을 계속 이용하기 위해 리턴하는 메소드.
     *
     * @return 디코딩 된 이미지의 byte 배열
     */
    public byte[] getDecodedImageInByte() {
        return imageInByte;
    }
}
