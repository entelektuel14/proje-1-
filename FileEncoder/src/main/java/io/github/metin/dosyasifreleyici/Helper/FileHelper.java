package io.github.metin.dosyasifreleyici.Helper;

import java.io.File;


// Dosya işlemleri için yardımcı sınıf
public class FileHelper {
    
    // Dosyanın uzantısını döndürür
    public static String getExtension(File file) {
        String fileName = file.getName();
        int i = fileName.lastIndexOf('.');
        if (i == -1) return null;
        return fileName.substring(i+1);
    }

    // Dosyanın adını döndürür
    public static String getFileName(File file) {
        String fileName = file.getName();
        int i = fileName.lastIndexOf('.');
        if (i == -1) return fileName;
        return fileName.substring(0, i-1);
    }

    // Dosya ve içindeki tüm dosyaları siler. Rekürsif olarak çalışır
    public static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                deleteFolder(f);
            }
        }
        folder.delete();
    }
}
