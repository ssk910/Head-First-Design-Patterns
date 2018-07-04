package practice.designpatterns.factorymethod.imageReader2;

class ImageDecoder {
    private ReaderFactory readerFactory;

    ImageDecoder(ReaderFactory readerFactory) {
        this.readerFactory = readerFactory;
    }

    DecodedImage decodeImage(String imageFile) {
        return readerFactory.createReader(imageFile).getDecodedImage();
    }
}
