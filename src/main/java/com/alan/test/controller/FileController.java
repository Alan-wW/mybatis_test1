package com.alan.test.controller;

import com.alan.test.entity.request.User;
import com.alan.test.entity.resp.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileController {

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile file){
        String path = "/Users/alan/Documents/code/Java_Project/mybatis/";
        File newFile = new File(path);
        if(!newFile.exists()){
            newFile.mkdirs();
        }
        try {
            file.transferTo(new File(newFile, UUID.randomUUID().toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.ok();
    }

    /**
     * 文件下载
     */
    @GetMapping("/download")
    public void download(@RequestParam("fileName")String fileNanme, HttpServletResponse response) throws IOException {
        String path = "/Users/alan/Documents/code/Java_Project/mybatis/";
        FileInputStream inputStream = new FileInputStream(new File(path, fileNanme));
        // 设置响应头、以附件形式打开文件
        response.setHeader("content-disposition", "attachment; fileName=" + fileNanme);
        ServletOutputStream outputStream = response.getOutputStream();
        int len = 0;
        byte[] data = new byte[1024];
        while ((len = inputStream.read(data)) != -1) {
            outputStream.write(data, 0, len);
        }
        outputStream.close();
        inputStream.close();
    }

    @PostMapping("/test")
    public void test(User user){
        String str = "name: %s,age: %s,list: %s";
        // format = String.format(str, user.getName(), user.getAge(), user.getId());
       // System.out.println(format);

    }
    @PostMapping("/test2")
    public void test2(String name){
        System.out.println(name);
    }
}
