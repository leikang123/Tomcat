package myTomcat;

import java.io.IOException;

public class HelloWorldServlet extends MyServlet{

	@Override
	public void doGet(MyRequest request, MyResponse response) {
		try {
			response.write("get world.......");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void doPost(MyRequest request, MyResponse response) {
		try {
			response.write("post world.........");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
