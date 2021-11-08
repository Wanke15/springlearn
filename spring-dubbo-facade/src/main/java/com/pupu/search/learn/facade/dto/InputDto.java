package com.pupu.search.learn.facade.dto;

import lombok.SneakyThrows;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class InputDto {
    static List<String> texts;

    @SneakyThrows
    public InputDto() {
        String filePath = "C:\\Users\\jeffk\\Documents\\Work\\pupu\\论文\\水浒传.txt";
        StringBuffer buffer = new StringBuffer();
        InputStream is = new FileInputStream(filePath);
        String line; // 用来保存每行读取的内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // 读取第一行
        while (line != null) { // 如果 line 为空说明读完了
            buffer.append(line); // 将读到的内容添加到 buffer 中
            buffer.append("\n"); // 添加换行符
            line = reader.readLine(); // 读取下一行
        }
        reader.close();
        is.close();

        texts = Arrays.asList(buffer.toString().split("\n"));
    }

    public List<String> getTexts() {
        return texts;
    }

}
