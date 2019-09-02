package com.czw.music.enrity;

import com.czw.music.dao.UserMapper;
import com.czw.music.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class test1 {

    @Autowired
    static UserMapper userMapper;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\DELL\\Desktop\\muss2\\muss2.text");
        System.out.println(file);
        Tool.ReName(file,"C:\\Users\\DELL\\Desktop\\muss");


    }
//    public static boolean ReName(String path,String newname) {//文件重命名
//        //Scanner scanner=new Scanner(System.in);
//        File file=new File(path);
//        if(file.exists()) {
//            File newfile=new File("C:\\Users\\DELL\\Desktop\\muss2\\3.text");//创建新名字的抽象文件
//            if(file.renameTo(newfile)) {
//                System.out.println("重命名成功！");
//                return true;
//            }
//            else {
//                System.out.println("重命名失败！新文件名已存在");
//                return false;
//            }
//        }
//        else {
//            System.out.println("重命名文件不存在！");
//            return false;
//        }
//
//    }
}
