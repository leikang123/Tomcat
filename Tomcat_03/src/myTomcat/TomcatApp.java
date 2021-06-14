package myTomcat;
/**
 * 	启动类
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class TomcatApp {
	// 启动端口号
	private int port=9022;
	 private Map<String,String> urlServletMap = new HashMap<String,String>();
	 
	public TomcatApp(int port) {
		super();
		this.port = port;
	}
	
	
	public void start() {
		initServletMapping();
		
		ServerSocket  serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("mycat is start.......");
			while(true) {
				Socket socket = serverSocket.accept();
				InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();
				MyRequest request = new MyRequest(inputStream);
				MyResponse response = new MyResponse(outputStream);
				// 请求分发
				dispatch(request,response);
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(serverSocket !=null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}


	private void dispatch(MyRequest request, MyResponse response) {
           String clazz =urlServletMap.get(request.getUrl());
		   try {
			Class<MyServlet> myServletClass = (Class<MyServlet>) Class.forName(clazz);
			MyServlet myServlet = myServletClass.newInstance();
			myServlet.service(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void initServletMapping() {
	for(ServletMapping servletMapping : ServletMappingConfig.servletMapping) {
		urlServletMap.put(servletMapping.getUri(),servletMapping.getClazz());
		
	}
		
	}
public static void main(String[] args) {
	new TomcatApp(9022).start();
}
}
