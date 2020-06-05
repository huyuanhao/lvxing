package com.tencent.mid.sotrage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    public static String readEntireFile(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[4096];
        int i = 0;
        do {
            sb.append(cArr, 0, i);
            i = fileReader.read(cArr);
        } while (i >= 0);
        fileReader.close();
        return sb.toString();
    }

    public static List<String> readEntireFileLines(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                fileReader.close();
                bufferedReader.close();
                return arrayList;
            }
            arrayList.add(readLine.trim());
        }
    }

    public static File createDir(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        if (!file.getParentFile().exists()) {
            createDir(file.getParentFile().getAbsolutePath());
        }
        file.mkdir();
        return file;
    }
}
