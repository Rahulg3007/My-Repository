package Spotify;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class NegativeScenarios {
	
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	
	@BeforeClass
	public void initRequestAndResponseSpec()
	{
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		
		requestSpecBuilder.setBaseUri("https://api.spotify.com/v1");
		
		requestSpecBuilder.addHeader("Content-Type", "application/json");
		
		requestSpecBuilder.log(LogDetail.ALL);
		
		requestSpecification = requestSpecBuilder.build();
		
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
		
		responseSpecBuilder.expectContentType(ContentType.JSON);
		
		responseSpecBuilder.log(LogDetail.ALL);
		
		responseSpecification = responseSpecBuilder.build();
		
	}
	
	
	@Test(priority = 1)
	public void shouldNotBeAbleToCreatePlaylist()
	{
		given(requestSpecification)
		
		.body("{\r\n"
				+ "    \"name\": \"ATT Nov Batch first playlist2\",\r\n"
				+ "    \"description\": \"Testing the playlist api using postman\",\r\n"
				+ "    \"public\": false\r\n"
				+ "}")
		
		.when()
		
		.post("users/31scfm43vfowwk7lu7ubz4xnsbse/playlists")
		
		.then()
		
		.spec(responseSpecification)
		
		.assertThat()
		
		.statusCode(401);
		
		
		
		
	}
	
	@Test(priority = 2)
	public void shouldNotBeAuthorized()
	{
		given(requestSpecification)
		
		.headers("Authorization", "Bearer BQB-1uGapIwoXUky-t-o5xx8Ax3J1nfnE4Snmi9tLcQaC0jqMNLe_-moLXVuTEDplc2gk3ytnyai7giU8gMa9EAQTHgjXsgk3XbRDXUbzbY4NFgzIqRlFPa2osgHsCb4Gdb63Hu9UlAKU_BJYYrg9V3atF6u_Q3XnREirVcMHCN4ytDrXDwtLYtnANQ3vUo35xVwJvFnlkaP6JukgCNZkUbKnhIG7z6l_VcMJUYh0jMtD0qDQNZxneWb43IxeepRTck")
		
		.body("{\r\n"
				+ "    \"name\": \"ATT Nov Batch first playlist2\",\r\n"
				+ "    \"description\": \"Testing the playlist api using postman\",\r\n"
				+ "    \"public\": false\r\n"
				+ "}")
		
		.when()
		
		.post("users/31scfm43vfowwk7lu7ubz4xnsbse/playlists")
		
		.then()
		
		.spec(responseSpecification)
		
		.assertThat()
		
		.statusCode(401);
		
		
		
		
	}

}