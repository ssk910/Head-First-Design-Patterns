package practice.designpatterns.factorymethod.imageReader2;

/**
 * @link {https://shorturl.at/PQW01}
 */
public class TestPattern {
    public static void main(String[] args) {
        String bmpFile = "img.bmp"; // bmp
        String pngFile = "img.png"; // png
        String gifFile = "img.gif"; // gif

        ReaderFactory readerFactory = new ReaderFactory();
        ImageDecoder imageDecoder = new ImageDecoder(readerFactory);
        DecodedImage decodedImage;

        // Decode .bmp file
        decodedImage = imageDecoder.decodeImage(bmpFile);
        System.out.println(decodedImage);

        // Decode .png file
        decodedImage = imageDecoder.decodeImage(pngFile);
        System.out.println(decodedImage);

        // Decode .gif file
        decodedImage = imageDecoder.decodeImage(gifFile);
        System.out.println(decodedImage);
    }
}
