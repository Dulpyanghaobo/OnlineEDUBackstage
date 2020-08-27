package org.example;

import cn.hutool.core.io.FileUtil;

import java.io.File;

public class FileDev {
    public static void main(String[] args) {
        String savePath = "/Users/mac/IdeaProjects/QFP2020/QFP-index-zuul-serivce/src/main/java/org/example/Images.xcassets";

        File saveFile = new File(savePath);

        traverseFolder2(savePath);

    }
    public static void traverseFolder2(String path) {

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        traverseFolder2(file2.getAbsolutePath());
                    } else {
                        System.out.println("文件:" + file2.getAbsolutePath());
                        String endPath = "/Users/mac/IdeaProjects/QFP2020/QFP-index-zuul-serivce/src/main/java/org/example/copy/";
                        File filePath = new File(endPath+file2.getName());
                        file2.renameTo(filePath);
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
}
