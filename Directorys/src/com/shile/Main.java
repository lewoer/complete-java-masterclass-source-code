package com.shile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Filter;

/**
 * Path dir = ...
 * try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
 * for (Path entry: stream) {
 * ...
 * }
 * }
 *
 * 2. 使用文件系统的时候使用java.Nio, 使用write,read时候使用java.io
 */
public class Main {

    public static void main(String[] args) {

        // 过滤掉目录
//        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
//            @Override
//            public boolean accept(Path path) throws IOException {
//                return (Files.isRegularFile(path));
//            }
//        };
        /*lambda表达*/
        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);
//        Path directory = FileSystems.getDefault().getPath("FileTree/Dir2"); // hard-code
        Path directory = FileSystems.getDefault().getPath("FileTree" + File.separator+ "Dir2");
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory,filter)) {
            for (Path path : contents) {
                System.out.println(path.getFileName());
            }

        } catch (IOException | DirectoryIteratorException e) {  // | 位运算
            System.out.println(e.getMessage());
        }

        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        try {
            Path tempFile = Files.createTempFile("myapp",".appext");
            System.out.println("Temporary File path = " + tempFile.toAbsolutePath());
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for (FileStore store : stores) {
            System.out.println("drive = "+ store);
            System.out.println("fileStore = " + store.name());
        }
        System.out.println("******************");
        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for (Path path : rootPaths) {
            System.out.println(path);
        }
        System.out.println("--walking tree for Dir2--");
        Path dir2Path = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        try {
            Files.walkFileTree(dir2Path, new PrintNames());
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("--copy Dir2 to Dir4/Dir2Copy--");
        Path copyPath = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir4" + File.separator + "Dir2Copy");
        // FileTree/Dir4/Dir3Copy
        try {
            /*遍历文件树*/
            Files.walkFileTree(dir2Path,new CopyFiles(dir2Path,copyPath));
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

        /*IO 和 NIO方法的映射*/
        File file = new File("C:\\examples\\file.txt");
        Path convertedPath = file.toPath();
        System.out.println("convertedPath = " + convertedPath);

        File parent = new File("C:\\examples");
        File resolvedFile = new File(parent,"dir\\file.txt");
        System.out.println(resolvedFile.toPath());

        resolvedFile = new File("C:\\examples","dir\\file.txt");
        System.out.println(resolvedFile.toPath());

        Path parentPath = Paths.get("C:\\examples");
        Path childRelativePath = Paths.get("dir\\file.txt");
        System.out.println(parentPath.resolve(childRelativePath));

        File WorkingDirectory = new File("").getAbsoluteFile(); // equals new File(this.getAbsolutePath())
        System.out.println("Working directory = " + WorkingDirectory.getAbsolutePath());

        System.out.println("--print Dir2 contents using list()--");
        File dir2File = new File(WorkingDirectory,"FileTree\\Dir2");
        String[] dir2Contents = dir2File.list();
        for (int i=0; i<dir2Contents.length; i++) {
            System.out.println("i= " + i + ": " + dir2Contents[i]);
        }

        System.out.println("--print Dir2 contents using listFiles()--");
        File[] dir2Files = dir2File.listFiles();
        for (int i=0; i<dir2Files.length; i++) {
            System.out.println("i= " + i + ": " + dir2Files[i].getName());
        }
    }
}
