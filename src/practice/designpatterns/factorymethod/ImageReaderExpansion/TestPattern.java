/**
 *  @(#)TestPattern.java        1.0 2018/07/06
 */


package practice.designpatterns.factorymethod.ImageReaderExpansion;

import java.io.File;
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
        final String bmpFile = "imageFile.bmp";
        final String pngFile = "imageFile.png";
        final String gifFile = "imageFile.gif";

        Reader reader = new ImageReader();

        try {

//            Path p4 = FileSystems.getDefault().getPath(".");
            File file = new File("" + "src");
            System.out.println(file.getAbsolutePath());
//            String[] arr = TestPattern.class.getName().replaceAll("[.]", "\\").split("[.]");
//            List<String> list = Arrays.asList(arr);
//            list.get(list.size() - 1);


//            System.out.println("\\");
            System.out.println(TestPattern.class.getName().replaceAll("[.]", "\\\\"));
//            System.out.println(TestPattern.class.getResource(list.get(list.size() - 1) + ".class").getPath().toString());

//            System.out.println(p4.toAbsolutePath().toString());
//            File file = new

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
