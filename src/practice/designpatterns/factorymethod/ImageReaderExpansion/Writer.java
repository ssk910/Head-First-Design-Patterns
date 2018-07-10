package practice.designpatterns.factorymethod.ImageReaderExpansion;

import com.sun.istack.internal.Nullable;

import java.io.*;

abstract class Writer {
    abstract EncodedImage createEncodedImage(File imageFile, byte[] imageInByte, String format);

    public EncodedImage encodeImage(@Nullable String path, String fileName, byte[] imageInByte, String format) {
        return writeImage(path, fileName, imageInByte, format);
    }

    private EncodedImage writeImage(String path, String fileName, byte[] imageInByte, String format) {
        File file = null;

        if (path == null) {
            String classToPath = this.getClass().getName().replaceAll("[.]", "\\\\");
            String packageDir = classToPath.substring(0, classToPath.lastIndexOf("\\"));
            path = "src\\" + packageDir + "\\img\\";
        }

        try {
            file = new File("" + path + fileName);
        } catch (NullPointerException e) {
            // can not find a file
        } finally {
            return createEncodedImage(file, imageInByte, format);
        }

    }
}
