package com;
// 自定义Servlet规范
public abstract class CustomHttpServlet {
    public abstract void doGet(CustomHttpRequest request, CustomHttpResponse response) throws Exception;
    public abstract void doPost(CustomHttpRequest request, CustomHttpResponse response) throws Exception;
}
