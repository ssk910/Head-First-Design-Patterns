package practice.designpatterns.factorymethod.ImageReaderExpansion;

import java.awt.image.BufferedImage;
import java.io.File;

public class BMPEncodedImage extends EncodedImage {
    public BMPEncodedImage(byte[] imageFile) {
        this.imageFile = imageFile;
        this.format = Extensions.BMP;
    }
}
