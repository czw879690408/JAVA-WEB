package com.czw.music.tool;

import java.io.File;

public final  class Tool {

    /**
     * 移动文件至指定目录
     *
     * @param file          需要转移的文件
     * @param newpath       目标目录
     * @return              转移是否成功
     */
    public static boolean ReName(File file,String newpath) {//文件重命名
        System.out.println("tool: "+file.toString());
        //Scanner scanner=new Scanner(System.in);
        if(file.exists()) {
            File newfile=new File(newpath+File.separator+file.getName());//创建新名字的抽象文件
            if(file.renameTo(newfile)) {
                System.out.println("重命名成功！");
                return true;
            }
            else {
                System.out.println("重命名失败！新文件名已存在");
                return false;
            }
        }
        else {
            System.out.println("重命名文件不存在！");
            return false;
        }

    }

}
