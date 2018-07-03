package practice.designpatterns.factorymethod.imageReader2;

public class PNGReader implements ImageReader {
    private DecodedImage decodedImage;

    public PNGReader(String image) {
        this.decodedImage = new DecodedImage(image);
    }

    @Override
    public DecodedImage getDecodedImage() {
        return decodedImage;
    }
}
