package practice.designpatterns.factorymethod.ImageReaderNew;

/**
 * "Creator"에 해당하는 추상 클래스.
 * 객체 생성을 해주는 메소드를 추상 메소드로 선언.
 *
 * @version     1.0 06 Jul 2018
 * @author      Seokgyu Hwang
 */
abstract class Reader {
    abstract DecodedImage createDecodedImage(String imageFile, String format);

    /**
     * 전달 받은 이미지 파일의 확장자로 포맷을 추찰하고, createDecodedImage()에
     * 이미지 파일과 포맷을 전달하여 디코드된 이미지를 리턴.
     *
     * @param imageFile : 이미지 파일.
     * @return DecodedImage 객체.
     */
    public DecodedImage decodeImage(String imageFile) {
        String format;

        format = imageFile.substring(imageFile.indexOf('.') + 1,
                         imageFile.length());

        return createDecodedImage(imageFile, format);
    }
}
