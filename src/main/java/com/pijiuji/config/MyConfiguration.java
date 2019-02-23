package com.pijiuji.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {  //如果是Windows系统
            registry.addResourceHandler("/smallapple/**")
                    // /apple/**表示在磁盘apple目录下的所有资源会被解析为以下的路径
                    .addResourceLocations("file:E:/pijiuji/image/") //媒体资源
                    .addResourceLocations("file:E:/pijiuji/video/") //媒体资源
                    .addResourceLocations("classpath:/META-INF/resources/");  //swagger2页面
        } else {  //linux 和mac
            registry.addResourceHandler("/smallapple/**")
                    .addResourceLocations("file:/pijiuji/file/image/")   //媒体资源
                    .addResourceLocations("file:/pijiuji/file/files/")   //媒体资源
                    .addResourceLocations("file:/pijiuji/file/video/")   //媒体资源
                    .addResourceLocations("classpath:/META-INF/resources/");  //swagger2页面;
        }
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600);
    }
}
