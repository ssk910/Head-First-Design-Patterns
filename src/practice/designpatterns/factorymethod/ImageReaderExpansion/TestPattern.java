/**
 *  @(#)TestPattern.java        1.0 2018/07/06
 */


package practice.designpatterns.factorymethod.ImageReaderExpansion;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * main 메소드가 구현된 메인 클래스.
 *
 * @version     1.0 06 Jul 2018
 * @author      Seokgyu Hwang
 */
public class TestPattern {
    public static void main(String[] args) {
        /* 이미지 파일 */
        final String bmpFile = "sample_bmp.bmp";
        final String pngFile = "imageFile.png";
        final String gifFile = "sample_gif.gif";

        Reader reader = new ImageReader();

        try {

            String classToPath = TestPattern.class.getName().replaceAll("[.]", "\\\\");
            String packageDir = classToPath.substring(0, classToPath.lastIndexOf("\\"));
            String imgDir = "src\\" + packageDir + "\\img\\";
            String currentDir = (new File("" + imgDir)).getAbsolutePath();

            System.out.println(currentDir);

            File file = new File("" + imgDir + bmpFile);
            ByteArrayOutputStream os = new ByteArrayOutputStream();


            // read
            BufferedImage bufferedImage = ImageIO.read(file);
            InputStream is = new ByteArrayInputStream(os.toByteArray());
//            InputStream is = new BufferedInputStream(new FileInputStream(file));


            ImageIO.read(is);
            System.out.println(bufferedImage.getWidth() + "/" + bufferedImage.getHeight());

            // write
//            ImageIO.write(bufferedImage, "BMP", (new File("" + imgDir + "out.bmp")));
            ImageIO.write(bufferedImage, "PNG", (new File("" + imgDir + "out.png")));


//            BufferedImage bufferedImage = new BufferedImage(, BufferedImage.TYPE_INT_ARGB)

            /* 이미지 파일을 디코딩 한다 */
            reader.decodeImage(bmpFile).decode();
            reader.decodeImage(pngFile).decode();
            reader.decodeImage(gifFile).decode();
        } catch (NullPointerException e) {
            /* gif 포맷에 해당하는 객체는 구현이 안되어 있다 */
            System.out.println("This format is not supported yet. :(");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/**
 * memo..
 *
 * 이미지 파일을 읽어 byte array로 디코딩하여 리턴.
 * writer도 생성해서 원하는 이미지 포맷으로 다시 인코딩하는 기능도 추가할 것.
 *
 * 참고
 * How to convert BufferedImage to byte[] in Java?
 * : https://www.mkyong.com/java/how-to-convert-bufferedimage-to-byte-in-java/
 *
 * How to convert BufferedImage to InputStream?
 * : https://stackoverflow.com/questions/4251383/how-to-convert-bufferedimage-to-inputstream
 *
 * How to read an Image from a file, inputStream, or URL
 * : https://www.java-tips.org/java-se-tips-100019/40-javax-imageio/1725-how-to-read-an-image-from-a-file-inputstream-or-url.html
 *
 * How to use Java 8 Encode (Decode) an Image to Base64
 * : http://javasampleapproach.com/java/java-advanced/java-8-encode-decode-an-image-base64
 *
 * How to get image height and width using java?
 * : https://stackoverflow.com/a/9083914/4284814
 *
 * How to read and write image file in Java
 * : https://www.dyclassroom.com/image-processing-project/how-to-read-and-write-image-file-in-java
 */
