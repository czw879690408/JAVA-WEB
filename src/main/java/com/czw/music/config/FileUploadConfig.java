package com.czw.music.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

@Configuration
public class FileUploadConfig{
        /**
         * 文件上传配置
         *
         * @return MultipartConfigElement
         */
        @Bean
        public MultipartConfigElement multipartConfigElement() {
            MultipartConfigFactory factory = new MultipartConfigFactory();
            // 单个文件最大
            factory.setMaxFileSize("10240KB");
            // 设置总上传数据总大小
            factory.setMaxRequestSize("102400KB");
            return factory.createMultipartConfig();
        }
}
