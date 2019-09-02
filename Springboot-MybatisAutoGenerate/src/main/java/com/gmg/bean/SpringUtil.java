package com.gmg.bean;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.*;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.ServletContext;
import java.io.*;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author gmg
 * @title: SpringUtil
 * @projectName demo
 * @description: TODO
 * @date 2019/9/2 15:41
 */
public class SpringUtil {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Resource res1 = new FileSystemResource("");

        Resource res2 = new ClassPathResource("conf/file1.txt");

        InputStream ins1 = res1.getInputStream();
        InputStream ins2 = res2.getInputStream();

        File clsFile = ResourceUtils.getFile("classpath:conf/file1.txt");
        String httpFilePath = "file:D:/masterSpring/chapter23/src/conf/file1.txt";


        Resource res = new ClassPathResource("conf/file1.txt");
        // ① 将文件内容拷贝到一个 byte[] 中
        byte[] fileData = FileCopyUtils.copyToByteArray(res.getFile());

        // ② 将文件内容拷贝到一个 String 中
        String fileStr = FileCopyUtils.copyToString(new FileReader(res.getFile()));
        // ③ 将文件内容拷贝到另一个目标文件
        FileCopyUtils.copy(res.getFile(),
                new File(res.getFile().getParent()+ "/file2.txt"));
        // ④ 将文件内容拷贝到一个输出流中
        OutputStream os = new ByteArrayOutputStream();


        // ① jdbc.properties 是位于类路径下的文件
        Properties props = PropertiesLoaderUtils.loadAllProperties("jdbc.properties");
        System.out.println(props.getProperty("jdbc.driverClassName"));

        Resource res0 = new ClassPathResource("conf/file1.txt");
        // ① 指定文件资源对应的编码格式（UTF-8）
        EncodedResource encRes = new EncodedResource(res0,"UTF-8");
        // ② 这样才能正确读取文件的内容，而不会出现乱码
        String content = FileCopyUtils.copyToString(encRes.getReader());

        HtmlUtils.htmlEscape("");

        SerializationUtils.serialize("");

        DigestUtils.md5Digest(content.getBytes());

        Method s= ReflectionUtils.findMethod(Object.class,"methodName");

        ClassUtils.forName("int",ClassUtils.getDefaultClassLoader());


    }
}
