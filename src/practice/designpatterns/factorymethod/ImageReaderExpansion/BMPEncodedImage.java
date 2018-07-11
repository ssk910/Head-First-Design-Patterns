package practice.designpatterns.factorymethod.ImageReaderExpansion;

import java.io.File;

public class BMPEncodedImage extends EncodedImage {
    public BMPEncodedImage(File imageFile) {
        this.imageFile = imageFile;
        this.format = Extensions.BMP;
    }
}
