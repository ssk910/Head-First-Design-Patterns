package practice.designpatterns.factorymethod;

public class TestPattern {
    public static void main(String[] args) {
        DecodedImage decodedImage;
        ImageReader reader = null;

        String img_jpeg = "/img/sample_jpeg.jpg";
        String img_gif = "/img/smaple_gif.gif";

        String format_jpeg = img_jpeg.substring(img_jpeg.indexOf('.') + 1, (img_jpeg.length()));
        String format_gif = img_gif.substring(img_gif.indexOf('.') + 1, (img_gif.length()));

//        reader = read(img_jpeg, format_jpeg);
        reader = read(img_gif, format_gif);

        try {
            decodedImage = reader.getDecodedImage();
            System.out.println(decodedImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static ImageReader read(String img, String format) {
        if (format.equals("gif")) {
            return new GifReader(img);
        } else if (format.equals("jpg")) {
            return new JpegReader(img);
        } else if (format.equals("jpeg")) {
            return new JpegReader(img);
        } else {
            return null;
        }
    }
}
