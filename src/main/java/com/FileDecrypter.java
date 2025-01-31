package com;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Base64;

public class FileDecrypter {

        private static final int BUFFER_SIZE = 1024;
        private static final int END_OF_FILE = -1;
        private static final String ALGORITHM = "AES";
        private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
        private static final int CIPHER_MODE = Cipher.DECRYPT_MODE;

        private String encryptFilePath;
        private String decryptFilePath;
        private byte[] secretKey;

        public FileDecrypter(String encryptFilePath, String secretKey) {
            this.encryptFilePath = encryptFilePath.replace('\\', '/');
            this.decryptFilePath = encryptFilePath.replace(".enc", "");
            this.secretKey = Base64.getDecoder().decode(secretKey);
            decryptFile();
        }

        public void decryptFile() {
            try (FileInputStream fis = new FileInputStream(encryptFilePath);
                 FileOutputStream fos = new FileOutputStream(decryptFilePath)) {

                SecretKey AESGeneratedKey = new SecretKeySpec(secretKey, ALGORITHM);
                Cipher cipher = createCipher(CIPHER_MODE, AESGeneratedKey);

                try (CipherInputStream cis = new CipherInputStream(fis, cipher)) {
                    byte[] buffer = new byte[BUFFER_SIZE];
                    int bytesRead;

                    while ((bytesRead = cis.read(buffer)) != END_OF_FILE) {
                        fos.write(buffer, 0, bytesRead);
                    }

                    System.out.println("File successfully decrypted: " + decryptFilePath);
                }

            } catch (Exception e) {
                System.err.println("Error processing file: " + e.getMessage());
            }
        }

        private Cipher createCipher(int mode, SecretKey AESGeneratedKey) throws Exception {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(mode, AESGeneratedKey);
            return cipher;
        }


    }

