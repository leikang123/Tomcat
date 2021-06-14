package myTomcat;

import java.util.ArrayList;
import java.util.List;

public class ServletMappingConfig{
	 public static  List<ServletMapping> servletMapping = new ArrayList<>();
	 
	 static{
		 servletMapping.add(new ServletMapping("findGirl","/girl","mytomcat.FindGirlServlet"));
		 servletMapping.add(new ServletMapping("helloworld","/world","mytomcat.helloworldServlet"));
	 }
}