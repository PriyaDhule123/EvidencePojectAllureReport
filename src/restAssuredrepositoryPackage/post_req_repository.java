package restAssuredrepositoryPackage;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeTest;

import restAssuredCommonFunctionPackage.UtilitiyCommonFunction;

public class post_req_repository {
	@BeforeTest
	public static String base_URI() {
		String baseURI="https://reqres.in/";
		return baseURI;
	}
	public static String request_Body11() throws IOException {
		 ArrayList<String> data=UtilitiyCommonFunction.readDataExcel("Post_Test_Data","Post_TC_11");
				
		  String req_name= data.get(1);                  
		  String req_job=data.get(2);
		String requestBody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		return requestBody;	
	}
	public static String request_Body12() throws IOException {
		 ArrayList<String> data=UtilitiyCommonFunction.readDataExcel("Post_Test_Data","Post_TC_12");
		  String req_name= data.get(1);                  
		  String req_job=data.get(2);
		String requestBody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		return requestBody;	
	}
	
	public static String resource() {
		String resource="api/users";
		return resource;
	}

}
