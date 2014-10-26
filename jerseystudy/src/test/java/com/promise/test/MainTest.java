/** @文件名: MainTest.java @创建人：邢健  @创建日期： 2013-12-9 上午9:24:44 */

package com.promise.test;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * @类名: MainTest.java
 * @包名: com.promise.test
 * @描述: 测试用例
 * @作者: xingjian xingjian@yeah.net
 * @日期:2013-12-9 上午9:24:44
 * @版本: V1.0
 */
public class MainTest {

	@Test
	public void testGetStudentDesc() {
		Client c = Client.create();
		WebResource r = c.resource("http://localhost:8888/jerseystudy/rest/student/getStudentDesc");
		ClientResponse response = r.get(ClientResponse.class);
		System.out.println(response.getStatus());
		System.out.println(response.getHeaders().get("Content-Type"));
		String entity = response.getEntity(String.class);
		System.out.println(entity);
		//预测结果=> 200 [text/plain] this is student resource!
	}

	@Test
	public void testSayHello() {
		Client c = Client.create();
		WebResource r = c.resource("http://localhost:8888/jerseystudy/rest/student");
		ClientResponse response = r.get(ClientResponse.class);
		System.out.println(response.getStatus());
		System.out.println(response.getHeaders().get("Content-Type"));
		String entity = response.getEntity(String.class);
		System.out.println(entity);
		//预测结果=> 200 [text/plain] this is hello world!
	}
	
	@Test
	public void testGetStudentListXML() {
		Client c = Client.create();
		WebResource r = c.resource("http://localhost:8888/jerseystudy/rest/student/getStudentList");
		ClientResponse response = r.get(ClientResponse.class);  
		System.out.println(response.getHeaders().get("Content-Type"));
		String entity = response.getEntity(String.class);
		System.out.println(entity);
		//预测结果[application/xml]
		//<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		//<students><student><age>30</age><userName>jerseytest</userName></student></students>
	}
	
	@Test
	public void testGetStudentJSON() {
		Client c = Client.create();
		WebResource r = c.resource("http://localhost:8888/jerseystudy/rest/student/getStudent");
		ClientResponse response = r.get(ClientResponse.class);
		System.out.println(response.getHeaders().get("Content-Type"));
		String entity = response.getEntity(String.class);
		System.out.println(entity);
		//预测结果[application/json]
		//{"userName":"jerseytest","age":30}
	}
	
	@Test
	public void testOther(){
		ClientConfig config = new DefaultClientConfig();  
        Client client = Client.create(config);  
        WebResource service = client.resource(getBaseURI());  
        // Fluent interfaces   
        System.out.println("1:"+service.path("rest").path("student").accept(MediaType.TEXT_PLAIN).get(ClientResponse.class).toString());  
        // Get plain text   
        System.out.println("2:"+service.path("rest").path("student").accept(MediaType.TEXT_PLAIN).get(String.class));  
        // Get XML   
        System.out.println("3:"+service.path("rest").path("student").accept(MediaType.TEXT_XML).get(String.class));  
        // The HTML   
        System.out.println("4:"+service.path("rest").path("student").accept(MediaType.TEXT_HTML).get(String.class));  
        System.out.println("5:"+service.path("rest").path("student").accept(MediaType.TEXT_PLAIN_TYPE).post(String.class));  
        System.out.println("6:"+service.path("rest").path("student").post(String.class,"9999999"));  
        System.out.println("7:"+service.path("rest").path("student").path("first").post(String.class,"9999999"));  
        String param = "test";  
        //传递单个参数param变量作为动态路径并且作为参数   
        System.out.println("8:"+service.path("rest").path("student").path(param).post(String.class));  
        //多个参数包含在路径中传递到方法中作为参数使用    ,123,456作为参数       
        System.out.println("9:"+service.path("rest").path("student").path("123").path("456").post(String.class));  
	}
	
	private static URI getBaseURI() {  
        return UriBuilder.fromUri("http://localhost:8888/jerseystudy/").build();  
    }
}
