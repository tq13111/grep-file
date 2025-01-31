package com.github.hcsp.io;

import java.io.*;

public class FileSearch {
    // 找到第一个包含text的行的行号，行号从1开始计算。若没找到，则返回-1。
    // 如果指定的文件不存在或者无法被读取，抛出一个IllegalArgumentException。
    // 请不要让这个方法抛出checked exception
    public static int grep(File target, String text) {
        try (FileInputStream inputStream = new FileInputStream(target);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            //BufferedReader是可以按行读取文件

            String str = null;
            int i = 0;
            while ((str = bufferedReader.readLine()) != null) {
                i++;
                if ( str.contains(text) ){
                    return i;
                }
            }
            return -1;
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }


    }

    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println("结果行号：" + grep(new File(projectDir, "log1.txt"), "BBB"));
    }
}
