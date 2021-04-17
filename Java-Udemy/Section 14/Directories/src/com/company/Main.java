package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);

        Path directory = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory,filter)){
            for (Path file: contents){
                System.out.println(file.getFileName());
            }
        }catch (IOException | DirectoryIteratorException e){
            System.out.println(e.getMessage());
        }

        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        try {
            Path tempFile = Files.createTempFile("myApp",".appExt");
            System.out.println("Temporary file path " + tempFile.toAbsolutePath());

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for (FileStore store : stores){
            System.out.println("Volume name/Drive letter " + store);
            System.out.println("File store = " + store.name());
        }

        System.out.println("**********************");
        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for (Path path: rootPaths){
            System.out.println(path);
        }

        System.out.println("Walking tree for dir 2");
        Path Dir2Path = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
         try {
             Files.walkFileTree(Dir2Path,new PrintNames());
         }catch (IOException e){
             System.out.println(e.getMessage());
         }
        System.out.println("-----Copy Dir2 to Dir4/Dir2Copy-----");
         Path copyPath = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir4" + File.separator + "Dir2Copy");
         try {
             Files.walkFileTree(Dir2Path,new CopyFiles(Dir2Path,copyPath));
         }catch (IOException e){
             System.out.println(e.getMessage());
         }

        File file = new File("\\Example\\file.txt");
        Path convertedPath = file.toPath();
        System.out.println("Converted path " + convertedPath.toAbsolutePath());

        File parent = new File("Example");
        File resolvedFile = new File(parent,"Dir1/file1.txt");
        System.out.println(resolvedFile.toPath());

        resolvedFile = new File("Example","Dir1\\file1.txt");
        System.out.println(resolvedFile.toPath());

        Path parentPath = Paths.get("Example");
        Path childRelativePath = Paths.get("Dir1\\file1.txt");
        System.out.println(parentPath.resolve(childRelativePath));

        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println("Working Directory " + workingDirectory.getAbsolutePath());

        System.out.println("---------- print Dir2 contents using list() ----------------");
        File dir2File = new File(workingDirectory,"\\FileTree\\Dir2");
        String[] dir2Contents = dir2File.list();
        for (String name : dir2Contents){
            System.out.println(name);
        }

        System.out.println("------print dir2 contents using list files() ------");
        File[] dir2Files = dir2File.listFiles();
        for (File name: dir2Files){
            System.out.println(name.getName());
        }
    }
}
