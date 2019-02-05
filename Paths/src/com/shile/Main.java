package com.shile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {
    /**
     * 一,为什么要用nio里面的File而不用io里面的file?
     * 1. 在file类中的方法不抛出异常如File.delete()
     * 2. File.rename()在不同的系统中表现不一样,违背java跨平台特性
     * 3. 不支持symbolic 文件(类似于快捷方式),经常用于网络,指向远程地址
     * 4. File类不提供获取文件元数据的方式,如权限,安全信息,所有者
     *
     * 二, FileSystems.getDefault().getPath()获取相对地址,或Paths.getPath()获取绝对地址
     *   Files.copy()
     *   Files.move()
     *   Files.createDirectory()
     *   Files.readAttributes()
     */

    public static void main(String[] args) {
        try {
            Path filePath = FileSystems.getDefault().getPath("Examples","Dir1/file1.txt");
            long size = Files.size(filePath);
            System.out.println("size = " + size);
            System.out.println("last modifier "  + Files.getLastModifiedTime(filePath));

            // 使用readAttributes返回文件属性,进行批量操作
            BasicFileAttributes attrs = Files.readAttributes(filePath,BasicFileAttributes.class);
            System.out.println("Size = " + attrs.size() + "\n" +
                                "Last modified = " + attrs.lastModifiedTime() + "\n" +
                                "Created time = " + attrs.creationTime() + "\n" +
                                "is Directory = " + attrs.isDirectory() + "\n" +
                                "is regular file = " + attrs.isRegularFile());

//            Path dirToCreate = FileSystems.getDefault().getPath("Examples/Dir2/Dir3/Dir4/Dir5/Dir6");
//            Files.createDirectories(dirToCreate);

//            Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.createDirectories(dirToCreate);

//            Path fileToCreate = FileSystems.getDefault().getPath("Examples","file2.txt");
//            Files.createFile(fileToCreate);

//            Path fileToDelete = FileSystems.getDefault().getPath("Examples","Dir1","file1copy.txt");
//            Files.deleteIfExists(fileToDelete);
//            Path fileToMove = FileSystems.getDefault().getPath("Examples","file2.txt");
//            Path destination = FileSystems.getDefault().getPath("Examples","file1.txt");
//            Files.move(fileToMove,destination);

//            Path sourceFile = FileSystems.getDefault().getPath("Examples","file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples","file1copy.txt");
//            Files.copy(sourceFile,copyFile, StandardCopyOption.REPLACE_EXISTING);
//
//            sourceFile = FileSystems.getDefault().getPath("Examples","Dir1");
//            copyFile = FileSystems.getDefault().getPath("Examples","Dir4");
//            Files.copy(sourceFile,copyFile, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            ;
        }
//	    Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
//	    printFile(path);
////	    Path filePath = FileSystems.getDefault().getPath("files","subdirectoryFile.txt");
//        /* . 代表本地目录, .. 代表父类目录*/
//	    Path filePath = Paths.get(".","files","subdirectoryFile.txt");
//	    printFile(filePath);
////	    filePath = Paths.get("D:\\masterjavaproject\\outthere.txt");
//	    filePath = Paths.get("D:\\","masterjavaproject","outthere.txt");
//	    printFile(filePath);
//
//	    filePath = Paths.get(".");
//        System.out.println(filePath.toAbsolutePath());
//
//        Path path2 = FileSystems.getDefault().getPath(".","files","..","files","subdirectoryFile.txt");
//        System.out.println(path2.normalize().toAbsolutePath());
//        printFile(path2.normalize());
//
//        Path path3 = FileSystems.getDefault().getPath("thisfilesdoesntexit.txt");
//        System.out.println(path3.toAbsolutePath());
//
//        Path path4 = FileSystems.getDefault().getPath("D:\\","kan","wadkhaks.txt");
//        System.out.println(path4.toAbsolutePath());
//
//        Path path5 = FileSystems.getDefault().getPath("files");
//        System.out.println("Exits = " + Files.exists(path5));
//        System.out.println("Exits = " + Files.exists(path4));
//    }
//
//    private static void printFile(Path path) {
//        try(BufferedReader fileReader = Files.newBufferedReader(path)) {
//            String line;
//            while ((line = fileReader.readLine()) != null) {
//                System.out.println(line);
//            }
//
//        }catch (IOException ioe) {
//            System.out.println(ioe.getMessage());
//            ioe.printStackTrace();
//        }
    }
}
