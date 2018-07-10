package practice.designpatterns.factorymethod.ImageReaderExpansion;

import com.sun.istack.internal.Nullable;

import java.io.*;

/**
 * "Creator"에 해당하는 추상 클래스.
 * 객체 생성을 해주는 메소드를 추상 메소드로 선언.
 *
 * @version     1.0 06 Jul 2018
 * @author      Seokgyu Hwang
 */
abstract class Reader {
    abstract DecodedImage createDecodedImage(InputStream imageFile, String format);

    /**
     * 전달 받은 이미지 파일의 확장자로 포맷을 추찰하고, createDecodedImage()에
     * 이미지 파일과 포맷을 전달하여 디코드된 이미지를 리턴.
     *
     * @param imageFile : 이미지 파일.
     * @return DecodedImage 객체.
     */
    public DecodedImage decodeImage(@Nullable String path, String fileName, String format) {
//        String format;

//        format = imageFile.substring(imageFile.indexOf('.') + 1, imageFile.length());

        return readImage(path, fileName, format);
//        return createDecodedImage(imageFile, format);
    }

    private DecodedImage readImage(String path, String fileName, String format) {
        InputStream inputStream = null;

        if (path == null) {
            String classToPath = this.getClass().getName().replaceAll("[.]", "\\\\");
            String packageDir = classToPath.substring(0, classToPath.lastIndexOf("\\"));
            path = "src\\" + packageDir + "\\img\\";
        }

        try {
            File file = new File("" + path + fileName);
            inputStream = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {

        } finally {
            return createDecodedImage(inputStream, format);
        }

    }
}
