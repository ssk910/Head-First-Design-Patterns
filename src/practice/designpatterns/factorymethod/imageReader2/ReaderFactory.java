package practice.designpatterns.factorymethod.imageReader2;

class ReaderFactory {
    ImageReader createReader(String imgFile) {
        String format = imgFile.substring(imgFile.indexOf('.') + 1, imgFile.length());

        if (format.equals(Extensions.BMP)) {
            return new BMPReader(imgFile);
        } else if (format.equals(Extensions.PNG)) {
            return new PNGReader(imgFile);
        } else {
            return null;
        }
    }
}
