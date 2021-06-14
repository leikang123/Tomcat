package myTomcat;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 响应信息
 * @author mac1094
 *
 */

public class HttpResponse {
	private OutputStream os =null;

	public HttpResponse(OutputStream os)throws IOException {
		this.os=os;
		
	}
	/**
	 * 响应方法
	 */
	public void writeFile(String path)throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buff = new byte[1024];
		int len=0;
		while((len=fis.read(buff))!=-1) {
			os.flush();
		}
	}
	}


