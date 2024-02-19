package com.project.blog.controller;

import cn.hutool.core.io.FileUtil;
import com.project.blog.common.Result;
import com.project.blog.exception.CustomException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
public class FilesController {

    @Value("${server.ip}")
    private String serverIp;
    @Value("${server.port}")
    private String serverPort;
    @Value("${files.uploads.path}")
    private String filesUploadsPath;

    @PostMapping("/uploads")
    public Result uploads(@RequestParam MultipartFile file) throws IOException {

        //获取到文件类型 image/png
        String contentType = file.getContentType();

        List<String> listType = new ArrayList<>();
        //图片格式
        listType.add("image/png");
        listType.add("image/jpeg");
        listType.add("image/jpg");

        //视频格式
        listType.add("video/mp4");
        if (!listType.contains(contentType)) {
            throw new CustomException("图片只允许png，jpeg，jpg格式，视频只允许mp4格式上传");
        }

        InputStream inputStream = file.getInputStream();
        //生成文件名 uuid
        String uuid = UUID.randomUUID().toString();
        //获取上传文件扩展名
        String fix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //生成文件完整名称
        String fileName = uuid + fix;
        //生成文件完整路径
        String absolutePath = filesUploadsPath + fileName;

        File folder = new File(filesUploadsPath);
        //文件夹不存在就递归创建文件夹
        if (!folder.exists()) {
            folder.mkdirs();
        }
        int len = 0;
        FileOutputStream fileOutputStream = new FileOutputStream(absolutePath);

        while ((len = inputStream.read()) != -1) {
            fileOutputStream.write(len);
        }
        fileOutputStream.close();
        inputStream.close();

        HashMap<Object, Object> map = new HashMap<>();
        map.put("url", "http://" + serverIp + ":" + serverPort + "/views?fileName=" + fileName);
        map.put("alt", file.getOriginalFilename());
        return new Result().success(map);
    }

    @GetMapping("/views")
    public void views(@RequestParam String fileName, HttpServletResponse response) throws IOException {

        String[] split = fileName.split("/");
        String name = split[split.length-1];

        File file = new File(filesUploadsPath + name);
        //设置输出流格式
        ServletOutputStream outputStream = response.getOutputStream();
        response.addHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(name,"UTF-8"));

        //任意类型的二进制流数据
        response.setContentType("application/octet-stream");
        //读取文件字节流
        outputStream.write(FileUtil.readBytes(file));
        outputStream.flush();
        outputStream.close();
    }


    @PostMapping("/wangeditorUploads")
    public Object wangeditorUploads(@RequestParam MultipartFile file) throws IOException {

        //获取到文件类型 image/png
        String contentType = file.getContentType();

        List<String> listType = new ArrayList<>();
        //图片格式
        listType.add("image/png");
        listType.add("image/jpeg");
        listType.add("image/jpg");

        //视频格式
        listType.add("video/mp4");
        if (!listType.contains(contentType)) {
            throw new CustomException("图片只允许png，jpeg，jpg格式，视频只允许mp4格式上传");
        }

        InputStream inputStream = file.getInputStream();
        //生成文件名 uuid
        String uuid = UUID.randomUUID().toString();
        //获取上传文件扩展名
        String fix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //生成文件完整名称
        String fileName = uuid + fix;
        //生成文件完整路径
        String absolutePath = filesUploadsPath + fileName;

        File folder = new File(filesUploadsPath);
        //文件夹不存在就递归创建文件夹
        if (!folder.exists()) {
            folder.mkdirs();
        }
        int len = 0;
        FileOutputStream fileOutputStream = new FileOutputStream(absolutePath);

        while ((len = inputStream.read()) != -1) {
            fileOutputStream.write(len);
        }
        fileOutputStream.close();
        inputStream.close();



        HashMap<Object, Object> resultMap = new HashMap<>();

        HashMap<Object, Object> map = new HashMap<>();
        map.put("url", "http://" + serverIp + ":" + serverPort + "/views?fileName=" + fileName);
        map.put("href", "http://" + serverIp + ":" + serverPort + "/views?fileName=" + fileName);
        map.put("alt", file.getOriginalFilename());
        resultMap.put("errno",0);
        resultMap.put("data",map);
        return resultMap;
    }


}
