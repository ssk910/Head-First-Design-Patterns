package practice.designpatterns.factorymethod.ImageReaderExpansion;

import java.io.File;

public class PNGEncodedImage extends EncodedImage {
    public PNGEncodedImage(File imageFile) {
        this.imageFile = imageFile;
        this.format = Extensions.PNG;
    }
}
