package practice.designpatterns.factorymethod.ImageReaderExpansion;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageWriter extends Writer {
    @Override
    EncodedImage createEncodedImage(File imageFile, byte[] imageInByte, String format) {
        EncodedImage encodedImage = null;
        try {
            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imageInByte));
            ImageIO.write(bufferedImage, format, imageFile);

            switch (format) {
            case Extensions.BMP:
                encodedImage = new BMPEncodedImage(imageInByte);
                break;
            case Extensions.PNG:
//                    return new PNGDecodedImage(imageInByte);
            default:
                break;
            }
        } catch (IOException e) {
            System.out.println("failed to encode.");
        } finally {
            return  encodedImage;
        }
    }
}
