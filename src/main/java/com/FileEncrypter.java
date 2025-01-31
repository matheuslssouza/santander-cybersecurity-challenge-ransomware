package com;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class FileEncrypter {

    private static final int BUFFER_SIZE = 1024;
    private static final int END_OF_FILE = -1;
    private static final String ALGORITHM = "AES";
    private static final int KEY_SIZE = 128;
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private static final int CIPHER_MODE = Cipher.ENCRYPT_MODE;

    private final String inputFilePath;
    private final String outputFilePath;

    // Constructor
    public FileEncrypter(String inputFilePath) {
        this.inputFilePath = inputFilePath.replace('\\', '/');
        this.outputFilePath = this.inputFilePath + ".enc";
        encryptFile();
    }

    // Process File to Encrypt
    public void encryptFile() {
        try {
            FileInputStream fis = new FileInputStream(inputFilePath);
            FileOutputStream fos = new FileOutputStream(outputFilePath);

            SecretKey AESGeneratedKey = generateAESKey();
            String encodedKey = Base64.getEncoder().encodeToString(AESGeneratedKey.getEncoded());
            System.out.println("Secret Key (Base64): " + encodedKey);

            Cipher cipher = createCipher(CIPHER_MODE, AESGeneratedKey);
            CipherOutputStream cos = new CipherOutputStream(fos, cipher);

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            // Write the data encrypted for another document
            while ((bytesRead = fis.read(buffer)) != END_OF_FILE) {
                cos.write(buffer, 0, bytesRead);
            }

            System.out.println("File successfully encrypted: " + outputFilePath);

            cos.close();
            fos.close();
            fis.close();

            Files.deleteIfExists(Path.of(inputFilePath));

        } catch (Exception e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }

    // Generate secret key to use in algorithm
    private SecretKey generateAESKey() throws Exception {
        KeyGenerator secretKey = KeyGenerator.getInstance(ALGORITHM);
        secretKey.init(KEY_SIZE);
        return secretKey.generateKey();
    }

    // Algorithm to encrypt (For more security, change for CBC mode in TRANSFORMATION)
    private Cipher createCipher(int mode, SecretKey AESGeneratedKey) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(mode, AESGeneratedKey);
        return cipher;
    }

}

