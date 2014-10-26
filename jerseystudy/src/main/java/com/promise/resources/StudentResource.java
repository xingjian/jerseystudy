/** @文件名: StudentResource.java @创建人：邢健  @创建日期： 2013-12-9 上午8:48:16 */

package com.promise.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

/**   
 * @类名: StudentResource.java 
 * @包名: com.promise.resources 
 * @描述: 学生
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2013-12-9 上午8:48:16 
 * @版本: V1.0   
 */
@Path("/student")
public class StudentResource {

	@GET
	@Produces("text/plain")
	@Path("/getStudentDesc")
	public String getStudentDesc(){
		return "this is student resource!";
	}

	@GET
	@Produces("text/plain")
	public String sayHello(){
		return "this is hello world!";
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("/getStudentList")
	public List<Student> getStudentList(){
		List<Student> list = new ArrayList<Student>();
		Student student = new Student();
		student.setUserName("jerseytest");
		student.setAge(30);
		list.add(student);
		return list;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getStudent")
	public Student getStudent(){
		Student student = new Student();
		student.setUserName("jerseytest");
		student.setAge(30);
		return student;
	}
	
	@GET  
    @Produces(MediaType.TEXT_HTML)  
    public String sayHtmlHello() {  
        return "<html> " + "<title>" + "Hello Jersey" + "</title>"  
                + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";  
    }  

	/**  
     * 客户端请求方式为：  
     * service.path("rest").path("hello").accept(MediaType.TEXT_XML).get(String.class)  
     * @return  
     */  
    @GET  
    @Produces(MediaType.TEXT_XML)  
    public String sayXMLHello() {  
        return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";  
    } 
    
    /**  
     * 客户端发送post请求  
     * service.path("rest").path("hello").accept(MediaType.TEXT_PLAIN_TYPE).post(String.class)  
     * service.path("rest").path("hello").post(String.class,"9999999")  
     */  
    @POST  
    public String sayStringHellp(String str){  
        System.out.println(str);  
        return "success";  
    }
	
    
    /**  
     * 也可以在“hello” 的路径下继续添加访问路径  
     * 此时的访问路径就是/hello/first  
     * service.path("rest").path("hello").path("first").post(String.class,"9999999")  
     * @return  
     */  
    @Path("/first")  
    @POST  
    public String sayPathHelp(String str){  
        System.out.println("first:"+str);  
        return "success";  
    }  

    /**  
     * 也可以以传递的参数作为访问路径，起到动态路径设定  
     * 此时的访问路径就是"/hello/变量str"  
     * "@PathParam("str")String str"说明这个“String str”参数的来源是包含在请求路径中的请求参数  
     * service.path("rest").path("hello").path(param).post(String.class)  
     * @return  
     */  
    @Path("/{str}")  
    @POST  
    public String sayParamHelp(@PathParam("str")String str){  
        System.out.println("first/"+str+":"+str);  
        return "success";  
    }  
      
    /**  
     * 也可以以传递的参数作为访问路径，起到动态路径设定  
     * 此时的访问路径就是"/hello/变量str"  
     * "@PathParam("str")String str"说明这个“String str”参数的来源是包含在请求路径中的请求参数  
     * service.path("rest").path("hello").path("123").path("456").post(String.class)  
     * @return  
     */  
    @Path("/{str}/{str2}")  
    @POST  
    public String sayManyParamHelp(@PathParam("str")String str,@PathParam("str2")String str2){  
        System.out.println("first/"+str+":"+str+":str2"+str2);  
        return "success";  
    }     

    @POST
	@Consumes("application/x-www-form-urlencoded")
	public String testPost(MultivaluedMap<String, String> formParams) {
    	return "testPost sucess";
    }
}
