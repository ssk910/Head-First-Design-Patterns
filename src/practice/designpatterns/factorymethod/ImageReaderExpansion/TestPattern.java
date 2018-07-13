/**
 *  @(#)TestPattern.java        1.0 2018/07/06
 */


package practice.designpatterns.factorymethod.ImageReaderExpansion;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * main 메소드가 구현된 메인 클래스.
 *
 * @version     1.0 06 Jul 2018
 * @author      Seokgyu Hwang
 */
public class TestPattern {
    private static Logger logger = Logger.getLogger(TestPattern.class.getName());

    public static void main(String[] args) {
        /* 이미지 파일 */
        final String fileName = "sample";
        final String bmpFile = "sample_bmp.bmp";
        final String pngFile = "sample_png.png";
        final String gifFile = "sample_gif.gif";

        /* 포맷 */
        String encodeFormat = null;
        String decodeFormat = null;

        Scanner scanner = new Scanner(System.in);

        Reader reader = new ImageReader();
        Writer writer = new ImageWriter();
        DecodedImage decodedImage = null;
        EncodedImage encodedImage = null;
        byte[] decodedImageInByte = null;

        System.out.print("디코딩할 이미지의 포맷(bmp, png) : ");
        decodeFormat = scanner.nextLine().toLowerCase();
        System.out.print("인코딩할 이미지의 포맷(bmp, png) : ");
        encodeFormat = scanner.nextLine().toLowerCase();

        try {
            /* 이미지 파일을 디코딩 한다 */
            decodedImage = reader.decodeImage(null, fileName + "." + decodeFormat);
            System.out.println("Image decoded.");

            /* 디코딩한 이미지의 byte 배열을 저장 */
            decodedImageInByte = decodedImage.getDecodedImageInByte();

            /* byte 배열을 다시 인코딩 */
            encodedImage = writer.encodeImage(null, null, decodedImageInByte, encodeFormat);

            logger.log(Level.INFO, "File created at " + encodedImage.getEncodedImageFile().getAbsolutePath());
            System.out.println("Created an image file at " + encodedImage.getEncodedImageFile().getAbsolutePath());
        } catch (NullPointerException e) {
            /* 포맷에 해당하는 객체가 구현이 안되어 있을 경우 */
            logger.log(Level.SEVERE, "Class is not defined.");
            System.out.println("Sorry. This format is not supported yet. :(");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            System.out.println("Error caused.");
        }
    }
}


/**
 * memo..
 *
 * 이미지 파일을 읽어 byte array로 디코딩하여 리턴.
 * writer도 생성해서 원하는 이미지 포맷으로 다시 인코딩하는 기능도 추가할 것.
 *
 * 참고
 * How to convert BufferedImage to byte[] in Java?
 * : https://www.mkyong.com/java/how-to-convert-bufferedimage-to-byte-in-java/
 *
 * How to convert BufferedImage to InputStream?
 * : https://stackoverflow.com/questions/4251383/how-to-convert-bufferedimage-to-inputstream
 *
 * How to read an Image from a file, inputStream, or URL
 * : https://www.java-tips.org/java-se-tips-100019/40-javax-imageio/1725-how-to-read-an-image-from-a-file-inputstream-or-url.html
 *
 * How to use Java 8 Encode (Decode) an Image to Base64
 * : http://javasampleapproach.com/java/java-advanced/java-8-encode-decode-an-image-base64
 *
 * How to get image height and width using java?
 * : https://stackoverflow.com/a/9083914/4284814
 *
 * How to read and write image file in Java
 * : https://www.dyclassroom.com/image-processing-project/how-to-read-and-write-image-file-in-java
 */
