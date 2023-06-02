package io.github.metin.dosyasifreleyici.Helper.AES;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

// ECB modu ile AES şifreleme işlemlerini gerçekleştirir.
public class ECB {

    // Girilen metni AES/ECB/PKCS5Padding ile şifreler. Şifreleme için girilen anahtar kullanılır.
    public static byte[] encryptECB(byte[] plaintext, String key) throws Exception {
        // Cipher sınıfı, şifreleme ve deşifreleme işlemlerini gerçekleştirmek için kullanılır.
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        // Girilen anahtarın uzunluğu 256 bit olmalıdır.
        SecretKeySpec secretKey = new SecretKeySpec(generateKey(key), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(plaintext);
    }

    // Decrypts the given ciphertext with the given key.
    public static byte[] decryptECB(byte[] ciphertext, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec secretKey = new SecretKeySpec(generateKey(key), "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(ciphertext);
    }

    // Girilen anahtarın uzunluğunu önemsiz hale getirilebilmek için 256 bitlik hash değerini döndürür.
    private static byte[] generateKey(String key) throws Exception {
        // MessageDigest sınıfı, hash değerlerini hesaplamak için kullanılır.
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        // Girilen anahtarın UTF-8 formatında byte dizisini döndürür.
        return digest.digest(key.getBytes(StandardCharsets.UTF_8));
    }

}
