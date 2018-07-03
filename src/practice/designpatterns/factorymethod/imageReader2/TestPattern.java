package practice.designpatterns.factorymethod.imageReader2;

/**
 * @link {https://shorturl.at/PQW01}
 */
public class TestPattern {
    public static void main(String[] args) {
        String bmpFile = "img.bmp";
        String pngFile = "img.png";
        DecodedImage decodedImage;

        ReaderFactory readerFactory = new ReaderFactory();

        decodedImage = readerFactory.createReader(bmpFile).getDecodedImage();
        System.out.println(decodedImage);
        decodedImage = readerFactory.createReader(pngFile).getDecodedImage();
        System.out.println(decodedImage);
    }
}
