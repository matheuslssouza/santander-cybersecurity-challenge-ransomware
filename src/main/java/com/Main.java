package com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Encrypt and Decrypt program, be careful! ");
        System.out.println("Press 1 for encrypt, 2 for decrypt and 3 for exit: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                System.out.println("Insert the link of archive to encrypt");
                System.out.println("Link example: C:/Users/Documentos/Ransomware/teste.txt");
                Scanner scanner1 = new Scanner(System.in);
                String directoryForEncrypt = scanner1.nextLine();
                FileEncrypter encrypter = new FileEncrypter(directoryForEncrypt);
            case 2:;
            case 3: break;
        }

    }
}