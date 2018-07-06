package practice.designpatterns.factorymethod.ImageReaderNew;

/**
 * "Concrete Creator"에 해당하는 클래스. "Creator"인 Reader 클래스를 상속하여
 * createDecodedImage() 메소드를 구현한다. 여기서 객체를 생성하는 역할을 한다.
 *
 * @version     1.0 06 Jul 2018
 * @author      Seokgyu Hwang
 */
public class ImageReader extends Reader {
    /**
     * 포맷을 전달받고, 각 포맷에 해당하는 DecodedImage 객체를 생성하고 리턴.
     *
     * @param imageFile : 이미지 파일.
     * @param format    : 이미지 파일의 확장자를 통해 추출한 이미지 포맷.
     * @return 해당 포맷에 해당하는 DecodedImage 객체
     */
    @Override
    DecodedImage createDecodedImage(String imageFile, String format) {
        switch (format) {
        case Extensions.BMP:
            return new BMPDecodedImage(imageFile);
        case Extensions.PNG:
            return new PNGDecodedImage(imageFile);
        default:
            return null;
        }
    }
}
