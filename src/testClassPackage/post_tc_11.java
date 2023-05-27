package testClassPackage;
import java.io.IOException;
import java.time.LocalDateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import restAssuredCommonFunctionPackage.APICommonFunction;
import restAssuredCommonFunctionPackage.UtilitiyCommonFunction;
import restAssuredrepositoryPackage.post_req_repository;

public class post_tc_11 {
	@Test
	public static void execute() throws IOException 
	{ 
		 for(int i=0;i<5;i++)
		 {
			 String baseURI=post_req_repository.base_URI();
			 String requestBody=post_req_repository.request_Body11();	
			 String resource=post_req_repository.resource();
			 int statusCode=APICommonFunction.res_statusCode(baseURI, requestBody, resource);	
					 
			 if(statusCode==201)
			 {
				 String responseBody=APICommonFunction.res_responseBody(baseURI, requestBody, resource);
				 post_tc_11.validator(statusCode, requestBody, responseBody);
				 UtilitiyCommonFunction.evidencefilecreater("post_tc_11", requestBody, responseBody);
				
				 break;
			 }
			 else
			 {
				 System.out.println("correct status code is not find hence retrying the API");	
			 }
		 }
		 }
		 public static void validator(int statusCode,String requestBody,String responseBody)
		 {
			 JsonPath jspres=new JsonPath(responseBody);
		     String res_name=jspres.getString("name");
		     String res_job=jspres.getString("job");
		     int res_id=jspres.getInt("id");
		     String res_createdAt=jspres.getString("createdAt");
		     res_createdAt=res_createdAt.substring(0,11);
		     
		     JsonPath jspreq=new JsonPath(requestBody);
		     String req_name=jspreq.getString("name");
		     String req_job=jspreq.getString("job");
		     LocalDateTime Date=LocalDateTime.now();
		     String exp_Date=Date.toString().substring(0,11);
		   
		     Assert.assertEquals(statusCode,201);
		     Assert.assertEquals(res_name,req_name);
		     Assert.assertEquals(res_job,req_job);
		     Assert.assertEquals(res_createdAt,exp_Date);
		     Assert.assertNotNull(res_id);
		     
		 
	}
 
	
}