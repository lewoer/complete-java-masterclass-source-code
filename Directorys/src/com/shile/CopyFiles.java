package com.shile;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 22:46 2019/1/27
 */
public class CopyFiles extends SimpleFileVisitor<Path> {

    private Path sourceRoot;
    private Path targetRoot;

    public CopyFiles(Path sourceRoot, Path targetRoot) {
        this.sourceRoot = sourceRoot;
        this.targetRoot = targetRoot;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error accessing file: " +  file.toAbsolutePath() + " " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        /*在这个path和给定的path间构建一个相对路径*/
        Path relativePath = sourceRoot.relativize(dir);
        System.out.println("RelativizedPath = " + relativePath);
        Path copyDir = targetRoot.resolve(relativePath);
        System.out.println("Resolved path for copy = " + copyDir);

        try {
            Files.copy(dir,copyDir);

        }catch (IOException e) {
            System.out.println(e.getMessage());
            return FileVisitResult.SKIP_SUBTREE;  // 跳过这个目录下条目
        }
        return FileVisitResult.CONTINUE; // 当从preVisitDirectory方法返回,继续访问当前目录下文件
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path relativePath = sourceRoot.relativize(file);
        System.out.println("RelativizedPath = " + relativePath);
        Path copyDir = targetRoot.resolve(relativePath);
        System.out.println("Resolved path for copy = " + copyDir);

        try {
            Files.copy(file,copyDir);

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return FileVisitResult.CONTINUE; // 当从preVisitDirectory方法返回,继续访问当前目录下文件
    }
}
