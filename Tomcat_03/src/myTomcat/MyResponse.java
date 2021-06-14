package myTomcat;

import java.io.IOException;
import java.io.OutputStream;

/*
 * 
 * 封装响应对象
 */
public class MyResponse {
	private OutputStream outputStream;
	public MyResponse(OutputStream outputStream)throws IOException {
		this.outputStream=outputStream;
	}
 public void write(String content)throws IOException {
	 StringBuffer httpResponse = new StringBuffer();
	 httpResponse.append("HTTP/1.1 200 ok\n")
	             .append("content-type:text-html\n")
	             .append("<html><body>")
	             .append(content)
	             .append("</body></html>");
	        
	 outputStream.write(httpResponse.toString().getBytes());
	 outputStream.close();
	 
 }
}
