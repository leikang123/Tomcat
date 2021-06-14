package myTomcat;

import java.io.IOException;
import java.io.InputStream;

/**
 * 封装请求对象
 * @author mac1094
 *
 */
public class MyRequest {
	//路径
	private String uri;
	//方法
   private String method;
   
   
   public MyRequest(InputStream inputStream)throws IOException {
	   String httpRequest ="";
	   byte[] buff = new byte[1024];
	   int len = 0;
	   if((len = inputStream.read(buff))>0) {
		   httpRequest= new String(buff,0,len);
		   
	   }
	   String httpHead = httpRequest.split("\n")[0];
	   uri= httpHead.split("\\s")[1];
	   method=httpHead.split("\\s")[0];
	   System.out.println(this);
   }


public Object getMethod() {
	return null;
}


public Object getUrl() {
	return null;
}
}
