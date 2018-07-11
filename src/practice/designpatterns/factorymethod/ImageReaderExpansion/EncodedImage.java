package practice.designpatterns.factorymethod.ImageReaderExpansion;

import java.io.File;

abstract class EncodedImage {
    File imageFile;    // 이미지 파일
    String format;     // 이미지 파일의 포맷

    /**
     * 인코딩 된 이미지 파일의 File 객체를 이용하기 위해 리턴
     *
     * @return File 객체
     */
    public File getEncodedImageFile() {
        return imageFile;
    }
}
