package io.github.metin.dosyasifreleyici.Helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// Sıkıştırma işlemlerini gerçekleştirir.
public class Archive {


    // Girilen dosyayı zip dosyası olarak sıkıştırır.
    public static void zipFile(String sourceFileAddress) throws IOException {
        FileOutputStream fos = new FileOutputStream(sourceFileAddress + ".zip");
        ZipOutputStream zos = new ZipOutputStream(fos);

        File file = new File(sourceFileAddress);
        zipFile(file, file.getName(), zos);

        zos.close();
        fos.close();
    }


    // Girilen dosyayı zip dosyası olarak sıkıştırır. ZipOutputStream nesnesi verilir. Bu sayede tek bir zip dosyasına birden fazla dosya sıkıştırılabilir.
    private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }

        if (fileToZip.isDirectory()) {
            File[] children = fileToZip.listFiles();
            if (children != null) {
                for (File childFile : children) {
                    zipFile(childFile, fileName + File.separator + childFile.getName(), zipOut);
                }
            }
        } else {
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileName);
            zipOut.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) >= 0) {
                zipOut.write(buffer, 0, length);
            }

            fis.close();
        }
    }
}
