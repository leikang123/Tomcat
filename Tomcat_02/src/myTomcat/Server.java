package myTomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	// 统计服务器访问了多少次
	private static int count = 0;
	public static void main(String[] args) throws IOException {
		// 建立端口连接
		ServerSocket ss = new ServerSocket(9021);
		System.out.println("等待客户端连接。。。。。。。");
		// 阻塞方法等待客户端连接
		 Socket s = ss.accept();
		 System.out.println("客户端连接上。。。。");
		 // 解析请求
		InputStream is = s.getInputStream();
		HttpRequest request  =new HttpRequest(is);
		String uri = request.getUri();
		// 定义存放信息缓存的地方
		byte[] buff = new byte[1024];
		int len = is.read(buff);
		if(len >0) {
			// 解析信息
			String msg =new String(buff,0,len);
			System.out.println("====="+msg+"==========");
		}else {
			System.out.println("falie");
		}
		OutputStream os =s.getOutputStream();
		// 资源响应给客户
		HttpResponse response = new HttpResponse(os);
	     //这里需要判断是静态资源
		if(isStatic(uri)) {
			response.writeFile(uri.substring(1));
		}
		ss.close();
	}
public static boolean isStatic(String uri) {
	boolean isStatic =false;
	//定义一个静态资源集合
	String [] suffixs= {"html","css","jpg","js","jpeg","png"};
	for(String str: suffixs) {
		if(uri.endsWith("."+suffixs)) {
			isStatic = true;
		}
	}
	return isStatic;
}
} 
