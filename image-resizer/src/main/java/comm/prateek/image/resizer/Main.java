package comm.prateek.image.resizer;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String[] files = {"MC_choked_5.jpg", "MC_choked_2.jpg", "LF_Algorithm-and-Blues_HN_01.jpg",
                            "MC_choked_HN_02.jpg", "LF_Algorithm-and-Blues_HN_25.jpg"};
        Arrays.stream(files).forEach(file -> {
            try {
                processImage(classloader, file);
                processImage1(classloader, file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    private static void processImage(ClassLoader classloader, String fileName) throws IOException {
        InputStream is = classloader.getResourceAsStream(fileName);
        BufferedImage bufferedImage = ImageIO.read(is);
        System.out.println(bufferedImage.getHeight());
        System.out.println(bufferedImage.getData());
        BufferedImage image1 = Scalr.resize(bufferedImage, bufferedImage.getWidth()/3, bufferedImage.getHeight()/3);
        ImageIO.write(image1, "jpg",
                new File("/tmp/" +fileName.split("\\.")[0]+"_by3_"+System.currentTimeMillis()+".jpg"));
    }

    private static void processImage1(ClassLoader classloader, String fileName) throws IOException {
        InputStream is = classloader.getResourceAsStream(fileName);
        BufferedImage bufferedImage = ImageIO.read(is);
        System.out.println(bufferedImage.getHeight());
        System.out.println(bufferedImage.getData());
        BufferedImage image1 = Scalr.resize(bufferedImage, bufferedImage.getWidth()/2, bufferedImage.getHeight()/2);
        ImageIO.write(image1, "jpg",
                new File("/tmp/"+fileName.split("\\.")[0]+"_by2_"+System.currentTimeMillis()+".jpg"));
    }
}