package practice.designpatterns.factorymethod.imageReader2;

public class DecodedImage {
    private String image;

    public DecodedImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "file decoded:" + image;
    }
}