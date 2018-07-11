package practice.designpatterns.factorymethod.ImageReaderExpansion;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageWriter extends Writer {
    private Logger logger = Logger.getLogger(getClass().getName());

    /**
     * 이미지 파일의 포맷과 byte 배열을 전달받고, 각 포맷에 해당하는 EncodedImage 객체를 생성하고 리턴.
     *
     * @param imageFile   : 파일 쓰기할 File 객체
     * @param imageInByte : 인코딩할 byte 배열
     * @param format      : 인코딩 포맷
     * @return
     */
    @Override
    EncodedImage createEncodedImage(File imageFile, byte[] imageInByte, String format) {
        EncodedImage encodedImage = null; // 인코딩한 이미지 정보를 담고 있는 객체

        try {
            /* byte 배열을 읽어서 파일 생성 */
            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imageInByte));
            System.out.println(ImageIO.write(bufferedImage, format, imageFile));

            // bmp로 생성하면 자꾸 false가 나옴... ?????


            /* 포맷에 맞는 "product" 객체를 생성 */
            switch (format) {
            case Extensions.BMP:
                encodedImage = new BMPEncodedImage(imageFile);
                break;
            case Extensions.PNG:
                encodedImage = new PNGEncodedImage(imageFile);
                break;
            default:
                encodedImage = null;
                logger.log(Level.WARNING, "Can not find format.");
                break;
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
            System.out.println("Failed to create a file.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            System.out.println("Error caused.");
        } finally {
            return encodedImage;
        }
    }
}
