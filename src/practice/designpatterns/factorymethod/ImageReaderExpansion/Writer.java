package practice.designpatterns.factorymethod.ImageReaderExpansion;

import com.sun.istack.internal.Nullable;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class Writer {
    private Logger logger = Logger.getLogger(getClass().getName());

    /* 객체를 생성하는 메소드 */
    abstract EncodedImage createEncodedImage(File imageFile, byte[] imageInByte, String format);

    /**
     * 전달받은 byte 배열을 전달받은 포맷으로 인코딩하여 인코딩된 이미지의 File 객체를 리턴.
     *
     * @param path        : 생성할 파일이 저장될 경로
     * @param fileName    : 새로 생성할 파일 이름
     * @param imageInByte : 이미지 파일의 byte 배열
     * @param format      : 인코딩할 포맷
     * @return 인코딩된 이미지의 File 객체
     */
    public EncodedImage encodeImage(@Nullable String path, @Nullable String fileName, byte[] imageInByte, String format) {
        File file = null;

        /* 파일의 이름을 전달받지 못했을 경우 default 이름을 설정 */
        if (fileName == null) {
            fileName = "out";
            logger.log(Level.INFO, "No information for file name. Set name for default");
        }

        /* path가 null로 넘어왔을 경우 디폴트 path를 설정 */
        if (path == null) {
            String classPath;      // 현재 클래스의 경로.
            String packagePath;    // 패키지의 경로.

            classPath = this.getClass().getName().replaceAll("[.]", "\\\\");
            packagePath = classPath.substring(0, classPath.lastIndexOf("\\"));
            path        = "src\\" + packagePath + "\\img\\";

            logger.log(Level.INFO, "No information for file path. Set path for default");
        }

        logger.log(Level.INFO, "Path for file to create: " + path);
        logger.log(Level.INFO, "Name for file to create: " + fileName);

        /* 객체를 생성하는 createEncodedImage 메소드 호출 */
        try {
            logger.log(Level.INFO, "File format: " + format);
            file = new File("" + path + fileName + "." + format);
        } catch (NullPointerException e) {
            logger.log(Level.SEVERE, e.getMessage());
            System.out.println("File not found.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            System.out.println("Error caused.");
        } finally {
            return createEncodedImage(file, imageInByte, format);
        }
    }
}
