package com.bw.contrller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping("product")
public class UnloadController {
    @Value("${file.domain}")
    private String fileDomain;
    @Value("${file.path}")
    private String filePath;

    /**
     * 文件上传接口
     * @param file
     * @return
     */
    @PostMapping("upload")
    public Object upload(@RequestParam("file") MultipartFile file){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("result",false);
        /** 文件名 **/
//        String originalFilename = file.getOriginalFilename();
        String fileName  = UUID.randomUUID().toString()+".jpg";
        /** 文件保存地址 **/
        File destFile = new File(filePath+fileName);
        try {
            /*保存文件*/
            file.transferTo(destFile);
            resultMap.put("result",true);
            resultMap.put("fileName",fileName);
            resultMap.put("imgUrl",fileDomain+fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return resultMap;
        }
        return resultMap;
    }

    @GetMapping("del")
    public Object upload(@RequestParam("fileName") String fileName){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("result",false);
        /** 文件地址 **/
        File destFile = new File(filePath+fileName);
        destFile.delete();
        resultMap.put("result",true);
        return resultMap;
    }


}
