package practice.designpatterns.factorymethod.imageReader2;

public class BMPReader implements ImageReader {
    private DecodedImage decodedImage;

    public BMPReader(String image) {
        this.decodedImage = new DecodedImage(image);
    }

    @Override
    public DecodedImage getDecodedImage() {
        return decodedImage;
    }
}
