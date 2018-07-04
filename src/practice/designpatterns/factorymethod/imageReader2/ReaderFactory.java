package practice.designpatterns.factorymethod.imageReader2;

class ReaderFactory {
    ImageReader createReader(String imgFile) {
        String format = imgFile.substring(imgFile.indexOf('.') + 1, imgFile.length());

        if (format.equals("bmp")) {
            return new BMPReader(imgFile);
        } else if (format.equals("png")) {
            return new PNGReader(imgFile);
        } else {
            return null;
        }
    }
}
