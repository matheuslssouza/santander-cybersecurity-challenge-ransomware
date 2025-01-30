package com;
import java.io.*;

public class Encrypter {

    public static final int BUFFER_SIZE= 1024;
    public static final int END_OF_FILE = -1;
    
    private String inputFilePath;
    private String outputFilePath;

    // Open the archive to be encrypted
    public Encrypter (){

        //I need change name classes, Encrypter for FileEncrypter, and FileDecrypter. Put just one method for both classes
        //I need put the command line to user insert the directory for encrypt e decrypt like: C:/Users/Documentos/Ransomware/teste_encrypted.txt
            try {
                File file = new File(outputFilePath);
                FileInputStream fis = new FileInputStream(inputFilePath);
                FileOutputStream fos = new FileOutputStream(outputFilePath);
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead;

                while((bytesRead = fis.read(buffer)) != END_OF_FILE){
                    fos.write(buffer,0, bytesRead);
                }



            } catch (IOException e) {
                System.out.println("File not found: ");
            }

        }
}
