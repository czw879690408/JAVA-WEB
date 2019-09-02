package com.czw.music.controller;


import com.czw.music.dao.MusicMapper;
import com.czw.music.enrity.music;
import com.czw.music.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RequestMapping("/music")
@Controller
public class MusicCon {

    @Autowired
    MusicMapper musicMapper;


    @ResponseBody
    @PostMapping("getAllMusic")
    public List<music> getAllMusic(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        System.out.println(musicMapper.findAll());

        return musicMapper.findAll();
    }

    @GetMapping("insert")
    public String insertMusic(){
        return "insertMusic";
    }

    @GetMapping("home")
    public String home(Map<String,Object> map){
        map.put("music",musicMapper.findAll());
        return "musicList";
    }

    @PostMapping("upload")
    public String uploadMusic(HttpServletRequest request) throws IOException {
        CommonsMultipartResolver commonsMultipartFile = new CommonsMultipartResolver(request.getSession().getServletContext());
        if(commonsMultipartFile.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
            Iterator<String> fNames = multipartHttpServletRequest.getFileNames();
            while (fNames.hasNext()){
                String fName = fNames.next();
                //获取文件
                MultipartFile file = multipartHttpServletRequest.getFile(fName);
                File path = new File("static");
                File uploadpath = new File(path.getPath()+File.separator+"music"+File.separator+file.getOriginalFilename());
                System.out.println("path = " + uploadpath);
                File newFile = new File("C:\\Users\\DELL\\Desktop\\新建文件夹\\music\\src\\main\\resources\\static\\music"+ File.separator+file.getOriginalFilename());
                System.out.println("newFile = " + newFile.getParent());
//                System.out.println("newFile.getPath() = " + newFile.get);
                if (newFile.exists()){
                    newFile.mkdirs();
                }
                file.transferTo(newFile);
                musicMapper.insertMusic(newFile.getName(),"/music/"+newFile.getName(),0);
            }
        }
        return "redirect:home";
    }

//    @PostMapping("upload")
//    public String uploadMusic(@RequestParam("music") MultipartFile[] files) throws IOException {
//        if (files.length == 0) {
//            return "file is empty.";
//        }
//        for(MultipartFile file:files) {
//            String originalFilename = file.getOriginalFilename();
//            String newFileName = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf(".") - 1);
//            File newfile = null;
//            File path = new File(ResourceUtils.getURL("classpath:").getPath());
//            System.out.println("path = " + path);
//            File upload = new File(path.getAbsolutePath(), "static/music/");
//            System.out.println("upload = " + upload);
//            if (!upload.exists()) upload.mkdirs();
//            String uploadPath = upload + File.separator;
//            System.out.println("uploadPath = " + uploadPath);
//
//            newfile = new File("static/music/" + newFileName);
//            System.out.println("newfile = " + newfile);
//            file.transferTo(newfile);
//            if (newfile.exists()) {
//                musicMapper.insertMusic(originalFilename, uploadPath, 0);
//                System.out.println(newfile.getAbsolutePath());
//                System.out.println("上传成功");
//            } else System.out.println("上传失败");
//        }
//        return "redirect:home";
//    }
}
