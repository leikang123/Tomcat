package myTomcat;

import java.io.IOException;

public class FindGirlServlet extends MyServlet{

	@Override
	public void doGet(MyRequest request, MyResponse response) {
		
		try {
			response.write("get girl......");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(MyRequest request, MyResponse response) {
		
		try {
			response.write("post girl.........");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
