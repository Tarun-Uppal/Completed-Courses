package com.company;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {
        try {

            Path filePath = FileSystems.getDefault().getPath("Examples","dir1\\file1.txt");
            long size = Files.size(filePath);
            System.out.println("Size = " + size);
            System.out.println("Last modified = " + Files.getLastModifiedTime(filePath));

            BasicFileAttributes attrs = Files.readAttributes(filePath,BasicFileAttributes.class);
            System.out.println("Size = " + attrs.size());
            System.out.println("Last Modified = " + attrs.lastModifiedTime());
            System.out.println("Created = " + attrs.creationTime());
            System.out.println("Is directory = " + attrs.isDirectory());
            System.out.println("Is regular file = " + attrs.isRegularFile());

//            Path dirToCreate = FileSystems.getDefault().getPath("Examples\\dir2\\dir3\\dir4\\dir5\\dir6\\dir7");
//            Files.createDirectories(dirToCreate);

//            Path dirToCreate = FileSystems.getDefault().getPath("Examples","dir2\\dir3\\dir4\\dir5\\dir6");
//            Files.createDirectories(dirToCreate);

//            Path dirToCreate = FileSystems.getDefault().getPath("Examples","dir4");
//            Files.createDirectory(dirToCreate);

//            Path fileToCreate = FileSystems.getDefault().getPath("Examples","file2.txt");
//            Files.createFile(fileToCreate);

//            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "dir1","fileCopy.txt");
//            Files.deleteIfExists(fileToDelete);

//            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path destination = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Files.move(fileToMove, destination);


//            Path fileToMove = FileSystems.getDefault().getPath("Examples", "fileCopy.txt");
//            Path destination = FileSystems.getDefault().getPath("Examples", "Dir1", "fileCopy.txt");
//            Files.move(fileToMove, destination);

//            Path sourceFile = FileSystems.getDefault().getPath("Examples","file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples","fileCopy.txt");
//            Files.copy(sourceFile,copyFile, StandardCopyOption.REPLACE_EXISTING);

//            sourceFile = FileSystems.getDefault().getPath("Examples","Dir1");
//            copyFile = FileSystems.getDefault().getPath("Examples","Dir4");
//            Files.copy(sourceFile,copyFile, StandardCopyOption.REPLACE_EXISTING);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


//        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
//        printFile(path);
//
//        Path filePath = Paths.get(".","files","SubDirectoryFile.txt");
//        printFile(filePath);
//
//        System.out.println();
//        System.out.println("Random Location");
/*
//        filePath = Paths.get("J:\\","Section 14","OutThere.txt");
//        printFile(filePath);
*/

//        path = Paths.get(".");
//        System.out.println(path.toAbsolutePath());
//
//        Path path3 = FileSystems.getDefault().getPath("thisFileDoesntExist.txt");
//        System.out.println(path3.toAbsolutePath());
//
//        Path path4 = Paths.get("QWER");
//        System.out.println(path4.toAbsolutePath());
//
//        filePath = FileSystems.getDefault().getPath("files");
//        System.out.println("exists = " + Files.exists(filePath));
//
//        System.out.println("Exists = (path 4) " + Files.exists(path4));
//      }

//    private static void printFile(Path path){
//        try (BufferedReader fileReader = Files.newBufferedReader(path)){
//            String line;
//            while ((line = fileReader.readLine()) != null){
//                System.out.println(line);
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
}
