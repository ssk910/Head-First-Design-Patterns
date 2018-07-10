package practice.designpatterns.factorymethod.ImageReaderExpansion;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * "Concrete Creator"에 해당하는 클래스. "Creator"인 Reader 클래스를 상속하여
 * createEncodedImage() 메소드를 구현한다. 여기서 객체를 생성하는 역할을 한다.
 *
 * @version     1.0 06 Jul 2018
 * @author      Seokgyu Hwang
 */
public class ImageReader extends Reader {
    /**
     * 포맷을 전달받고, 각 포맷에 해당하는 DecodedImage 객체를 생성하고 리턴.
     *
     * @param inputStream : 이미지 파일.
     * @param format      : 이미지 파일의 확장자를 통해 추출한 이미지 포맷.
     * @return 해당 포맷에 해당하는 DecodedImage 객체
     */
    @Override
    DecodedImage createDecodedImage(InputStream inputStream, String format) {
        byte[] imageInByte = null;

        try {
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            ImageIO.write(bufferedImage, format, stream);
            stream.flush();
            imageInByte = stream.toByteArray();
            stream.close();
        } catch (IOException e) {
            System.out.println("can not find a file... :(");
        } finally {
            switch (format) {
            case Extensions.BMP:
                return new BMPDecodedImage(imageInByte);
            case Extensions.PNG:
//                    return new PNGDecodedImage(imageInByte);
            default:
                return null;
            }
        }
    }
}
