package thatdz.assignment.assigmentjava5.uitls;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageManager {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ImageManager.class);

    public static boolean copyFile(String pathCopy, String pathSoure) throws IOException {
        File outFile = new File(pathCopy);
        File inFile = new File(pathSoure);
        try {
            if (outFile.createNewFile()) {
                LOGGER.info("File is created !!");
            } else {
                LOGGER.info("File is already exist");
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        try (
                InputStream in = new BufferedInputStream(
                        new FileInputStream(inFile));
                OutputStream out = new BufferedOutputStream(
                        new FileOutputStream(outFile))) {
            byte[] buffer = new byte[5120];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
            return true;
        } catch (IOException e) {
            System.out.println("e");
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(copyFile(
                    "C:\\Users\\Rittam\\OneDrive\\document\\javaproject\\All_java_project\\assigmentjava5\\src\\main\\webapp\\assets\\img\\dongsp\\filecp.png",
                    "C:\\Users\\Rittam\\OneDrive\\document\\javaproject\\All_java_project\\assigmentjava5\\src\\main\\webapp\\assets\\img\\dongsp\\dongsp15.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
