package com;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

import java.io.UnsupportedEncodingException;

public class CustomHttpResponse {
    private HttpRequest request;
    private ChannelHandlerContext context;

    public CustomHttpResponse(HttpRequest request, ChannelHandlerContext context) {
        this.request = request;
        this.context = context;
    }

    public void write(String content) throws Exception {
        // 创建响应对象
        FullHttpResponse response = new DefaultFullHttpResponse(
                HttpVersion.HTTP_1_1,
                HttpResponseStatus.OK,
                Unpooled.wrappedBuffer(content.getBytes("UTF-8")));

        // 初始化响应头
        // 获取到响应头
        HttpHeaders headers = response.headers();
        // 设置响应内容类型
        headers.set(HttpHeaderNames.CONTENT_TYPE, "text/json");
        // 设置响应体长度
        headers.set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
        // 设置缓存过期时长
        headers.set(HttpHeaderNames.EXPIRES, 0);
        // 若HTTP请求连接是长连接，则设置响应连接也为长连接
        if(HttpUtil.isKeepAlive(request)) {
            headers.set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
        }

        // 将响应对象写入到Channel
        context.writeAndFlush(response);
    }
}
