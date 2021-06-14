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
		String html ="<html><head><title>欢迎各位同学！</html></head><body>当前时间:"
				+"<br/>服务器回复：</font size='12' color='blue'>大家今天有收获吗？</font></title></body>";
		//信息输出
		os.write(html.getBytes());
		os.flush();
		os.close();
		s.close();
		ss.close();
	}

} 
