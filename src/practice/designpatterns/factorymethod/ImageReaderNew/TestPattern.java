/**
 *  @(#)TestPattern.java        1.0 2018/07/06
 */


package practice.designpatterns.factorymethod.ImageReaderNew;

/**
 * main 메소드가 구현된 메인 클래스.
 *
 * @version     1.0 06 Jul 2018
 * @author      Seokgyu Hwang
 */
public class TestPattern {
    public static void main(String[] args) {
        /* 이미지 파일 */
        final String bmpFile = "imageFile.bmp";
        final String pngFile = "imageFile.png";
        final String gifFile = "imageFile.gif";

        Reader reader = new ImageReader();

        try {
            /* 이미지 파일을 디코딩 한다 */
            reader.decodeImage(bmpFile).decode();
            reader.decodeImage(pngFile).decode();
            reader.decodeImage(gifFile).decode();
        } catch (NullPointerException e) {
            /* gif 포맷에 해당하는 객체는 구현이 안되어 있다 */
            System.out.println("This format is not supported yet. :(");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
