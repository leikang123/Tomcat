package myTomcat;

import java.io.IOException;
import java.io.InputStream;

/**
 * 解析客户端的请求
 * @author mac1094
 *
 */

public class HttpRequest {
	// 所有的解析请求始于uri
	private String uri;
	public HttpRequest(InputStream is)throws IOException{
		// 定义存放信息缓存的地方
				byte[] buff = new byte[1024];
				int len = is.read(buff);
				if(len >0) {
					// 解析信息
					String msg =new String(buff,0,len);
					uri=msg.substring(msg.indexOf("/"),msg.indexOf("/HTTP/1.1")-1);
					System.out.println("===="+msg+"========");
					System.out.println("uri:"+uri);
				}else {
					System.out.println("faile");
				}
				
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}

}
