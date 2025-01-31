package com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Encrypt and Decrypt program, be careful! ");
        while (true) {
            System.out.println("Press 1 for encrypt, 2 for decrypt and 3 for exit: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Insert the link of archive to encrypt");
                    System.out.println("Link example: C:/Users/Documentos/Ransomware/teste.txt");
                    String directoryForEncrypt = scanner.nextLine();
                    FileEncrypter encrypter = new FileEncrypter(directoryForEncrypt);
                    break;
                case 2:
                    System.out.println("Insert the link of archive to Decrypt");
                    System.out.println("Link example: C:/Users/Documentos/Ransomware/teste.txt.enc");
                    String directoryForDecrypt = scanner.nextLine();
                    System.out.println("Insert the Secret Key to Decrypt:");
                    String secretKey = scanner.nextLine();
                    FileDecrypter decrypter = new FileDecrypter(directoryForDecrypt, secretKey);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}