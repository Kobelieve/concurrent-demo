package com.kobe.book;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

    public static void main(String[] args) {
        urlTest();
    }

    public static void urlTest() {
        try {
            // 创建一个URL实例
            URL url = new URL("http://www.tlwok.com");
            System.out.println("协议：" + url.getProtocol());
            System.out.println("主机：" + url.getHost());
            System.out.println("授权：" + url.getAuthority());
            System.out.println("内容：" + url.getContent());
            System.out.println("端口：" + url.getPort());
            System.out.println("文件路径：" + url.getPath());
            System.out.println("文件名：" + url.getFile());
            System.out.println("相对路径：" + url.getRef());
            System.out.println("查询字符串：" + url.getQuery());
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
