package practice.designpatterns.factorymethod.ImageReaderExpansion;

import com.sun.istack.internal.Nullable;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * "Creator"에 해당하는 추상 클래스.
 * 객체 생성을 해주는 메소드를 추상 메소드로 선언.
 *
 * @version     1.0 06 Jul 2018
 * @author      Seokgyu Hwang
 */
abstract class Reader {
    private Logger logger = Logger.getLogger(getClass().getName());

    /* 객체를 생성하는 메소드 */
    abstract DecodedImage createDecodedImage(InputStream inputStream, String format);

    /**
     * 전달 받은 이미지 파일의 확장자로 포맷을 추출하고, createEncodedImage()에
     * 이미지 파일과 포맷을 전달하여 디코드된 이미지를 리턴.
     *
     * @param path     : 이미지 파일 경로.
     * @param fileName : 디코딩 대상이 되는 파일의 이름.
     * @return DecodedImage 객체.
     */
    public DecodedImage decodeImage(@Nullable String path, String fileName) {
        InputStream inputStream = null;

        /* path가 null로 넘어왔을 경우 디폴트 path를 설정 */
        if (path == null) {
            String classPath;      // 현재 클래스의 경로.
            String packagePath;    // 패키지의 경로.

            classPath = this.getClass().getName().replaceAll("[.]", "\\\\");
            packagePath = classPath.substring(0, classPath.lastIndexOf("\\"));
            path        = "src\\" + packagePath + "\\img\\";

            logger.log(Level.INFO, "No information for file path. Set path for default");
        }

        logger.log(Level.INFO, "Path for file to decode: " + path);

        /* 이미지 파일을 읽어 InputStream을 생성하여 객체를 생성하는 메소드 호출  */
        try {
            logger.log(Level.INFO, "File name: " + fileName);
            File file = new File("" + path + fileName);
            inputStream = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, e.getMessage());
            System.out.println("File not found.");
        } finally {
            return createDecodedImage(inputStream, extractFormat(fileName));
        }
    }

    /**
     * 파일 이름에서 "." 뒤의 문자열을 확장자로 판단하여 확장자 추출.
     * @param fileName : 파일 이름
     * @return 확장자
     */
    private String extractFormat(String fileName) {
        return fileName.substring(fileName.indexOf('.') + 1,
                fileName.length()).toLowerCase();
    }
}
