package comm.prateek.image.resizer;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

public class ImageResizer {

    private static final Logger logger = Logger.getLogger(ImageResizer.class.getName());

    /**
     * Static method to resize the passed inputStream of Image and write the resized image
     * to the output stream passed.
     * @param inputStream - Input stream for the image file which needs to be resized
     * @param outputStream - Output stream for the resized image
     * @param resizeRatio - Resize ratio. The image height and width is divided by the passed ratio.
     *                    Example resize ratio = 0.5 means to reduce the height and width aspect to 50%
     * @param outputFileFormat - The output file format like jpg, png, etc. This ensures correct encoding.
     */
    public static void resizeImage(InputStream inputStream, OutputStream outputStream, Integer resizeRatio,
                                   String outputFileFormat) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        logger.info("Input image : height = " + bufferedImage.getHeight() + ",width = " + bufferedImage.getWidth());
        BufferedImage image1 = Scalr.resize(bufferedImage, bufferedImage.getWidth() * resizeRatio, bufferedImage.getHeight() * resizeRatio);
        logger.info("Resized image : height = " + bufferedImage.getHeight() * resizeRatio + ",width = " + bufferedImage.getWidth() * resizeRatio);
        ImageIO.write(image1, outputFileFormat, outputStream);
    }

    /**
     * Static method to resize the passed inputStream of Image and write the resized image
     * to the output stream passed.
     * @param inputStream - Input stream for the image file which needs to be resized
     * @param outputFile - Output file for the resized image
     * @param resizeRatio - Resize ratio. The image height and width is divided by the passed ratio.
     *                    Example resize ratio = 0.5 means to reduce the height and width aspect to 50%
     * @param outputFileFormat - The output file format like jpg, png, etc. This ensures correct encoding.
     */
    public static void resizeImage(InputStream inputStream, File outputFile, Integer resizeRatio,
                                   String outputFileFormat) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        logger.info("Input image : height = " + bufferedImage.getHeight() + ",width = " + bufferedImage.getWidth());
        BufferedImage image1 = Scalr.resize(bufferedImage, bufferedImage.getWidth() * resizeRatio, bufferedImage.getHeight() * resizeRatio);
        logger.info("Resized image : height = " + bufferedImage.getHeight() * resizeRatio + ",width = " + bufferedImage.getWidth() * resizeRatio);
        ImageIO.write(image1, outputFileFormat, outputFile);
    }
}

