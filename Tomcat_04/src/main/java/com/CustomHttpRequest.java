package com;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

import java.util.List;
import java.util.Map;

public class CustomHttpRequest {
    private HttpRequest request;
    private ChannelHandlerContext context;

    public CustomHttpRequest(HttpRequest request, ChannelHandlerContext context) {
        this.request = request;
        this.context = context;
    }

    // 获取请求的URI，其中是包含请求路径与请求参数的
    public String getUri() {
        return request.uri();
    }

    // 获取请求方式（POST、GET等）
    public String getMethod() {
        return request.method().name();
    }

    // 获取所有请求参数列表
    public Map<String, List<String>> getParameters() {
        QueryStringDecoder decoder = new QueryStringDecoder(request.uri());
        return decoder.parameters();
    }

    // 获取到请求路径
    public String getPath() {
        return new QueryStringDecoder(request.uri()).path();
    }

    // 获取指定名称的参数
    public List<String> getParameters(String name) {
        return this.getParameters().get(name);
    }

    public String getParameter(String name) {
        List<String> list = this.getParameters(name);
        if(list == null) {
            return null;
        }
        return list.get(0);
    }


}
