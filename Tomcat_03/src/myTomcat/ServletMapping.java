package myTomcat;

import java.util.ArrayList;
import java.util.List;

/**
 * Servlet配置
 * @author mac1094
 *
 */

public class ServletMapping {
	private String servletName;
	private String uri;
	private String clazz;
	
	public ServletMapping(String servletName,String uri,String clazz) {
		this.servletName=servletName;
		this.uri=uri;
		this.clazz=clazz;
	}
public String getServletName() {
	return servletName;
	
}
 public String getUri() {
	return uri;
	 
 }
 public String getClazz() {
	return clazz;
	 
 }
public void setServletName(String servletName) {
	this.servletName = servletName;
}
public void setUri(String uri) {
	this.uri = uri;
}
public void setClazz(String clazz) {
	this.clazz = clazz;
}
}

 
