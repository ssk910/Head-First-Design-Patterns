package practice.designpatterns.factorymethod.ImageReaderExpansion;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * "Concrete Creator"에 해당하는 클래스. "Creator"인 Reader 클래스를 상속하여
 * createEncodedImage() 메소드를 구현한다. 여기서 객체를 생성하는 역할을 한다.
 *
 * @version     1.0 06 Jul 2018
 * @author      Seokgyu Hwang
 */
public class ImageReader extends Reader {
    private Logger logger = Logger.getLogger(getClass().getName());

    /**
     * 이미지 파일의 stream과 포맷을 전달받고, 각 포맷에 해당하는 DecodedImage 객체를 생성하고 리턴.
     *
     * @param inputStream : 이미지 파일 스트림.
     * @param format      : 이미지 파일의 확장자를 통해 추출한 이미지 포맷.
     * @return 해당 포맷에 해당하는 DecodedImage 객체
     */
    @Override
    DecodedImage createDecodedImage(InputStream inputStream, String format) {
        byte[]       imageInByte = null;     // 이미지를 디코드하여 바이트 배열로 변환된 결과
        DecodedImage decodedImage = null;    // 디코드한 이미지 정보를 담고 있는 객체

        try {
            /* InputStream을 byte배열로 변환 */
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            ImageIO.write(bufferedImage, format, stream);
            stream.flush();
            imageInByte = stream.toByteArray();
            stream.close();
            logger.log(Level.INFO, "Convert InputStream to byte array");

            /* 포맷에 맞는 "product" 객체를 생성 */
            switch (format) {
            case Extensions.BMP:
                decodedImage = new BMPDecodedImage(imageInByte);
                break;
            case Extensions.PNG:
                decodedImage = new PNGDecodedImage(imageInByte);
                break;
            default:
                decodedImage = null;
                logger.log(Level.WARNING, "Can not find format.");
                break;
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
            System.out.println("File not found.");
        } finally {
            return decodedImage;
        }
    }
}
